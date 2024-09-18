package br.com.apifootinfo.controller;

import br.com.apifootinfo.component.impl.ComponentEstadiosImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.data.domain.PageRequest;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityEstadios;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.dto.DadosEstadiosDTO;
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
 * Classe test para implementação dos testes unitários dos métodos de cadastro e consulta de estádios.
 * 
 * @author Felipe Nascimento
 * 
 */

class ControllerEstadiosTest implements Serializable {
	private static final long serialVersionUID = -2146859960302046732L;
	
	@Mock
	private ComponentEstadiosImpl componentEstadios;
	
	@InjectMocks
	private ControllerEstadios controllerEstadios;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerEstadios#saveStadium(DadosEstadiosDTO dadosEstadiosDTO)}
     * quando já existir o estádio informado cadastrado.
     */
    @Test
    void testSaveStadiumEstadioJaExiste() {
    	DadosEstadiosDTO dadosEstadiosDTO = new DadosEstadiosDTO();
    	dadosEstadiosDTO.setNomeEstadio("nomeEstadioExistente");
    	
    	when(componentEstadios.existsByNomeEstadio(dadosEstadiosDTO.getNomeEstadio())).thenReturn(true);
    	
    	ResponseEntity<Object> responseSaveStadium = controllerEstadios.saveStadium(dadosEstadiosDTO);
    	
    	verify(componentEstadios).save(any(EntityEstadios.class));
        assertEquals(HttpStatus.OK, responseSaveStadium.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Estádio cadastrado com sucesso."), responseSaveStadium.getBody());
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerEstadios#saveStadium(DadosEstadiosDTO dadosEstadiosDTO)} com sucesso.
     */
    @Test
    void testSaveStadiumSuccess() {
    	DadosEstadiosDTO dadosEstadiosDTO = new DadosEstadiosDTO();
    	dadosEstadiosDTO.setNomeEstadio("nomeNovoEstadio");
    	
    	when(componentEstadios.existsByNomeEstadio(dadosEstadiosDTO.getNomeEstadio())).thenReturn(false);
    	
    	ResponseEntity<Object> responseSaveStadium = controllerEstadios.saveStadium(dadosEstadiosDTO);
    	
    	verify(componentEstadios).save(any(EntityEstadios.class));
        assertEquals(HttpStatus.OK, responseSaveStadium.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Estádio cadastrado com sucesso."), responseSaveStadium.getBody());
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerEstadios#getAllStadiums(Pageable pageable)}.
     */
    @Test
    void testGetAllStadiums() {
    	EntityEstadios estadio1 = new EntityEstadios();
    	EntityEstadios estadio2 = new EntityEstadios();
    	List<EntityEstadios> estadios = Arrays.asList(estadio1, estadio2);
    	
    	Pageable pageable = PageRequest.of(0, 500);
    	
    	when(componentEstadios.findAll(pageable)).thenReturn(new PageImpl<>(estadios));
        
        ResponseEntity<List<EntityEstadios>> responseGetAllStadiums = controllerEstadios.getAllStadiums(pageable);
        
        assertEquals(HttpStatus.OK, responseGetAllStadiums.getStatusCode());
        assertEquals(estadios, responseGetAllStadiums.getBody());
    }
    
}