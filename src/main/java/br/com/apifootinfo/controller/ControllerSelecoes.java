package br.com.apifootinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.apifootinfo.component.ComponentSelecoes;
import org.springframework.data.web.PageableDefault;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntitySelecoes;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.dto.DadosSelecoesDTO;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import br.com.apifootinfo.util.Constants;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Classe controller responsável pelo cadastro e pela consulta de seleções.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_SELECTIONS)
public class ControllerSelecoes implements Serializable {
	private static final long serialVersionUID = 2237693272599669624L;
	private transient ComponentSelecoes componentSelecoes;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param componentSelecoes - serviço de seleções
	 * 
	 */
	public ControllerSelecoes(ComponentSelecoes componentSelecoes) {
		this.componentSelecoes = componentSelecoes;
	}
	
	/**
	 * Método responsável pelo cadastramento das seleções no banco de dados.
	 * 
	 * @param dadosSelecoesDTO - {@link DadosSelecoesDTO} - dados da seleção
	 * 
	 * @return dados da seleção em json em caso de sucesso
	 * 
	 */
	@PostMapping(Constants.ENDPOINT_SELECTIONS_REGISTER)
	public ResponseEntity<Object> saveSelection(@RequestBody @Valid DadosSelecoesDTO dadosSelecoesDTO) {
		
		if (componentSelecoes.existsByNomeSelecao(dadosSelecoesDTO.getNomeSelecao())) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseMessages(HttpStatus.CONFLICT.value(), "Esta seleção já está cadastrada."));
			
		}
		
		var entitySelecoes = new EntitySelecoes();
		BeanUtils.copyProperties(dadosSelecoesDTO, entitySelecoes);
		componentSelecoes.save(entitySelecoes);
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ResponseMessages(HttpStatus.CREATED.value(), "Seleção cadastrada com sucesso."));
		
	}
	
	/**
	 * Método responsável pela busca de todas as seleções no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return dados de todas as equipes em json
	 * 
	 */
	@GetMapping(Constants.ENDPOINT_SELECTIONS_LIST_ALL)
    public ResponseEntity<List<EntitySelecoes>> getAllSelections(@PageableDefault(page = 0, size = 500, sort = "nomeSelecao", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(componentSelecoes.findAll(pageable).getContent());
    }
	
}