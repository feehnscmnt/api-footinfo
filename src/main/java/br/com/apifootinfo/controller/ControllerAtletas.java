package br.com.apifootinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.apifootinfo.component.ComponentAtletas;
import org.springframework.data.web.PageableDefault;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityAtletas;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.dto.DadosAtletasDTO;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import br.com.apifootinfo.util.Constants;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Classe controller responsável pelo cadastro e pela consulta de atletas.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_ATHLETES)
public class ControllerAtletas implements Serializable {
	private static final long serialVersionUID = -6988367282902841060L;
	private transient ComponentAtletas componentAtletas;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param componentAtletas - {@link ComponentAtletas} - serviço de atletas
	 * 
	 */
	public ControllerAtletas(ComponentAtletas componentAtletas) {
		this.componentAtletas = componentAtletas;
	}
	
	/**
	 * Método responsável pelo cadastramento dos(as) atletas no banco de dados.
	 * 
	 * @param dadosAtletasDTO - {@link DadosAtletasDTO} - dados do(a) atleta
	 * 
	 * @return dados do(a) atleta em json em caso de sucesso
	 * 
	 */
	@PostMapping(Constants.ENDPOINT_ATHLETES_REGISTER)
	public ResponseEntity<Object> savePlayer(@RequestBody @Valid DadosAtletasDTO dadosAtletasDTO) {
		
		if (componentAtletas.existsByNomeAtleta(dadosAtletasDTO.getNomeAtleta())) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseMessages(HttpStatus.CONFLICT.value(), "Este(a) atleta já está cadastrado(a)."));
			
		}
		
		var entityAtleta = new EntityAtletas();
		BeanUtils.copyProperties(dadosAtletasDTO, entityAtleta);
		componentAtletas.save(entityAtleta);
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ResponseMessages(HttpStatus.CREATED.value(), "Atleta cadastrado(a) com sucesso."));
		
	}
	
	/**
	 * Método responsável pela busca de todos(as) os(as) atletas no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return dados de todos(as) os(as) atletas em json
	 * 
	 */
	@GetMapping(Constants.ENDPOINT_ATHLETES_LIST_ALL)
    public ResponseEntity<List<EntityAtletas>> getAllPlayers(@PageableDefault(page = 0, size = 500, sort = "nomeAtleta", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(componentAtletas.findAll(pageable).getContent());
    }
	
}