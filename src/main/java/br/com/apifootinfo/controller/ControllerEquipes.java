package br.com.apifootinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.apifootinfo.component.ComponentEquipes;
import org.springframework.data.web.PageableDefault;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.entity.EntityEquipes;
import br.com.apifootinfo.dto.DadosEquipesDTO;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import br.com.apifootinfo.util.Constants;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Classe controller responsável pelo cadastro e pela consulta de equipes.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_TEAMS)
public class ControllerEquipes implements Serializable {
	private static final long serialVersionUID = 6203600801757931563L;
	private transient ComponentEquipes componentEquipes;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param componentEquipes - serviço de equipes
	 * 
	 */
	public ControllerEquipes(ComponentEquipes componentEquipes) {
		this.componentEquipes = componentEquipes;
	}
	
	/**
	 * Método responsável pelo cadastramento das equipes no banco de dados.
	 * 
	 * @param dadosEquipesDTO - {@link DadosEquipesDTO} - dados da equipe
	 * 
	 * @return dados da equipe em json em caso de sucesso
	 * 
	 */
	@PostMapping(Constants.ENDPOINT_TEAMS_REGISTER)
	public ResponseEntity<Object> saveTeam(@RequestBody @Valid DadosEquipesDTO dadosEquipesDTO) {
		
		if (componentEquipes.existsByNomeEquipe(dadosEquipesDTO.getNomeEquipe())) {
			
			return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseMessages(HttpStatus.CONFLICT.value(), "Esta equipe já está cadastrada."));
			
		}
		
		var entityEquipe = new EntityEquipes();
		BeanUtils.copyProperties(dadosEquipesDTO, entityEquipe);
		componentEquipes.save(entityEquipe);
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ResponseMessages(HttpStatus.CREATED.value(), "Equipe cadastrada com sucesso."));
		
	}
	
	/**
	 * Método responsável pela busca de todas as equipes no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return dados de todas as equipes em json
	 * 
	 */
	@GetMapping(Constants.ENDPOINT_TEAMS_LIST_ALL)
    public ResponseEntity<List<EntityEquipes>> getAllTeams(@PageableDefault(page = 0, size = 500, sort = "nomeEquipe", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(componentEquipes.findAll(pageable).getContent());
    }
	
}