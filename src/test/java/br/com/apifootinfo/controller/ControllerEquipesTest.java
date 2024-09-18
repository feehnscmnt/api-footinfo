package br.com.apifootinfo.controller;

import br.com.apifootinfo.component.impl.ComponentEquipesImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.data.domain.PageRequest;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.entity.EntityEquipes;
import br.com.apifootinfo.dto.DadosEquipesDTO;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.Serializable;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.List;

/**
 * Classe test para implementação dos testes unitários dos métodos de cadastro e consulta de equipes.
 * 
 * @author Felipe Nascimento
 * 
 */

class ControllerEquipesTest implements Serializable {
	private static final long serialVersionUID = -1186884021235196646L;
	
	@Mock
	private ComponentEquipesImpl componentEquipes;
	
	@InjectMocks
	private ControllerEquipes controllerEquipes;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
	 * Método responsável pelo teste unitário do método {@link ControllerEquipes#saveTeam(DadosEquipesDTO dadosEquipesDTO)}
	 * quando já existir a equipe informada cadastrada.
	 */
    @Test
    void testSaveTeamEquipeJaExiste() {
    	DadosEquipesDTO dadosEquipesDTO = new DadosEquipesDTO();
    	dadosEquipesDTO.setNomeEquipe("nomeEquipeExistente");
    	
    	when(componentEquipes.existsByNomeEquipe(dadosEquipesDTO.getNomeEquipe())).thenReturn(true);
    	
    	ResponseEntity<Object> responseSaveTeam = controllerEquipes.saveTeam(dadosEquipesDTO);
    	
    	verify(componentEquipes).save(any(EntityEquipes.class));
        assertEquals(HttpStatus.OK, responseSaveTeam.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Equipe cadastrada com sucesso."), responseSaveTeam.getBody());
    }
    
    /**
	 * Método responsável pelo teste unitário do método {@link ControllerEquipes#saveTeam(DadosEquipesDTO dadosEquipesDTO)} com sucesso.
	 */
    @Test
    void testSaveTeamSuccess() {
    	DadosEquipesDTO dadosEquipesDTO = new DadosEquipesDTO();
    	dadosEquipesDTO.setNomeEquipe("nomeNovaEquipe");
    	
    	when(componentEquipes.existsByNomeEquipe(dadosEquipesDTO.getNomeEquipe())).thenReturn(false);
    	
    	ResponseEntity<Object> responseSaveTeam = controllerEquipes.saveTeam(dadosEquipesDTO);
    	
    	verify(componentEquipes).save(any(EntityEquipes.class));
        assertEquals(HttpStatus.OK, responseSaveTeam.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Equipe cadastrada com sucesso."), responseSaveTeam.getBody());
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerEquipes#getAllTeams(Pageable pageable)}.
     */
    @Test
    void testGetAllTeams() {
    	EntityEquipes equipe1 = new EntityEquipes();
    	EntityEquipes equipe2 = new EntityEquipes();
    	List<EntityEquipes> equipes = Arrays.asList(equipe1, equipe2);
    	
    	Pageable pageable = PageRequest.of(0, 500);
        
        when(componentEquipes.findAll(pageable)).thenReturn(new PageImpl<>(equipes));
        
        ResponseEntity<List<EntityEquipes>> responseGetAllTeams = controllerEquipes.getAllTeams(pageable);
        
        assertEquals(HttpStatus.OK, responseGetAllTeams.getStatusCode());
        assertEquals(equipes, responseGetAllTeams.getBody());
    }
    
}