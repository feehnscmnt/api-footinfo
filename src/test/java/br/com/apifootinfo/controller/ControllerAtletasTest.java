package br.com.apifootinfo.controller;

import br.com.apifootinfo.component.impl.ComponentAtletasImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.data.domain.PageRequest;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.entity.EntityAtletas;
import br.com.apifootinfo.dto.DadosAtletasDTO;
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
 * Classe test para implementação dos testes unitários dos métodos de cadastro e consulta de atletas.
 * 
 * @author Felipe Nascimento
 * 
 */

class ControllerAtletasTest implements Serializable {
	private static final long serialVersionUID = -6777229943621795153L;
	
	@Mock
    private ComponentAtletasImpl componentAtletas;
	
	@InjectMocks
    private ControllerAtletas controllerAtletas;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
	 * Método responsável pelo teste unitário do método {@link ControllerAtletas#savePlayer(DadosAtletasDTO dadosAtletasDTO)}
	 * quando já existir o atleta informado cadastrado.
	 */
    @Test
    void testSavePlayerAtletaJaExiste() {
    	DadosAtletasDTO dadosAtletasDTO = new DadosAtletasDTO();
    	dadosAtletasDTO.setNomeAtleta("nomeAtletaExistente");
    	
        when(componentAtletas.existsByNomeAtleta(dadosAtletasDTO.getNomeAtleta())).thenReturn(true);
        
        ResponseEntity<Object> responseSavePlayer = controllerAtletas.savePlayer(dadosAtletasDTO);
        
        verify(componentAtletas).save(any(EntityAtletas.class));
        assertEquals(HttpStatus.OK, responseSavePlayer.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Atleta cadastrado(a) com sucesso."), responseSavePlayer.getBody());
    }
    
    /**
	 * Método responsável pelo teste unitário do método {@link ControllerAtletas#savePlayer(DadosAtletasDTO dadosAtletasDTO)} com sucesso.
	 */
    @Test
    void testSavePlayerSuccess() {
        DadosAtletasDTO dadosAtletasDTO = new DadosAtletasDTO();
        dadosAtletasDTO.setNomeAtleta("nomeNovoAtleta");
        
        when(componentAtletas.existsByNomeAtleta(dadosAtletasDTO.getNomeAtleta())).thenReturn(false);
        
        ResponseEntity<Object> responseSavePlayer = controllerAtletas.savePlayer(dadosAtletasDTO);
        
        verify(componentAtletas).save(any(EntityAtletas.class));
        assertEquals(HttpStatus.OK, responseSavePlayer.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Atleta cadastrado(a) com sucesso."), responseSavePlayer.getBody());
    }
    
    /**
	 * Método responsável pelo teste unitário do método {@link ControllerAtletas#getAllPlayers(Pageable pageable)}.
	 */
    @Test
    void testGetAllPlayers() {
        EntityAtletas atleta1 = new EntityAtletas();
        EntityAtletas atleta2 = new EntityAtletas();
        List<EntityAtletas> atletas = Arrays.asList(atleta1, atleta2);
        
        Pageable pageable = PageRequest.of(0, 500);
        
        when(componentAtletas.findAll(pageable)).thenReturn(new PageImpl<>(atletas));
        
        ResponseEntity<List<EntityAtletas>> responseGetAllPlayers = controllerAtletas.getAllPlayers(pageable);
        
        assertEquals(HttpStatus.OK, responseGetAllPlayers.getStatusCode());
        assertEquals(atletas, responseGetAllPlayers.getBody());
    }
    
}