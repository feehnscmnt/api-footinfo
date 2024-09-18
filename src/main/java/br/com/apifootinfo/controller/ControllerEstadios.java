package br.com.apifootinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.apifootinfo.component.ComponentEstadios;
import org.springframework.data.web.PageableDefault;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityEstadios;
import br.com.apifootinfo.dto.DadosEstadiosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import br.com.apifootinfo.util.Constants;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Classe controller responsável pelo cadastro e pela consulta de estádios.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_STADIUMS)
public class ControllerEstadios implements Serializable {
	private static final long serialVersionUID = -8395496909317415854L;
	private transient ComponentEstadios componentEstadios;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param componentEstadios - serviço de estádios
	 * 
	 */
	public ControllerEstadios(ComponentEstadios componentEstadios) {
		this.componentEstadios = componentEstadios;
	}
	
	/**
	 * Método responsável pelo cadastramento dos estádios no banco de dados.
	 * 
	 * @param dadosEstadiosDTO - {@link DadosEstadiosDTO} - dados do estádio
	 * 
	 * @return dados do estádio em json em caso de sucesso
	 * 
	 */
	@PostMapping(Constants.ENDPOINT_STADIUMS_REGISTER)
	public ResponseEntity<Object> saveStadium(@RequestBody @Valid DadosEstadiosDTO dadosEstadiosDTO) {
		
		if (componentEstadios.existsByNomeEstadio(dadosEstadiosDTO.getNomeEstadio())) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseMessages(HttpStatus.CONFLICT.value(), "Este estádio já está cadastrado."));
			
		}
		
		var entityEstadio = new EntityEstadios();
		BeanUtils.copyProperties(dadosEstadiosDTO, entityEstadio);
		componentEstadios.save(entityEstadio);
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ResponseMessages(HttpStatus.CREATED.value(), "Estádio cadastrado com sucesso."));
		
	}
	
	/**
	 * Método responsável pela busca de todos os estádios no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return dados de todos os estádios em json
	 * 
	 */
	@GetMapping(Constants.ENDPOINT_STADIUMS_LIST_ALL)
	public ResponseEntity<List<EntityEstadios>> getAllStadiums(@PageableDefault(page = 0, size = 500, sort = "nomeEstadio", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(componentEstadios.findAll(pageable).getContent());
	}
	
}