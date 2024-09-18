package br.com.apifootinfo.controller;

import br.com.apifootinfo.component.impl.ComponentSelecoesImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.data.domain.PageRequest;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntitySelecoes;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.http.ResponseEntity;
import br.com.apifootinfo.dto.DadosSelecoesDTO;
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
 * Classe test para implementação dos testes unitários dos métodos de cadastro e consulta de seleções.
 * 
 * @author Felipe Nascimento
 * 
 */

class ControllerSelecoesTest implements Serializable {
	private static final long serialVersionUID = -3024843128074785841L;
	
	@Mock
	private ComponentSelecoesImpl componentSelecoes;
	
	@InjectMocks
	private ControllerSelecoes controllerSelecoes;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerSelecoes#saveSelection(DadosSelecoesDTO dadosSelecoesDTO)}
     * quando já existir a seleção informada cadastrada.
     */
    @Test
    void testSaveSelectionSelecaoJaExiste() {
    	DadosSelecoesDTO dadosSelecoesDTO = new DadosSelecoesDTO();
    	dadosSelecoesDTO.setNomeSelecao("nomeSelecaoExistente");
    	
    	when(componentSelecoes.existsByNomeSelecao(dadosSelecoesDTO.getNomeSelecao())).thenReturn(true);
    	
    	ResponseEntity<Object> responseSaveSelection = controllerSelecoes.saveSelection(dadosSelecoesDTO);
    	
    	verify(componentSelecoes).save(any(EntitySelecoes.class));
        assertEquals(HttpStatus.OK, responseSaveSelection.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Seleção cadastrada com sucesso."), responseSaveSelection.getBody());
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerSelecoes#saveSelection(DadosSelecoesDTO dadosSelecoesDTO)} com sucesso.
     */
    @Test
    void testSaveSelectionSuccess() {
    	DadosSelecoesDTO dadosSelecoesDTO = new DadosSelecoesDTO();
    	dadosSelecoesDTO.setNomeSelecao("nomeNovaSelecao");
    	
    	when(componentSelecoes.existsByNomeSelecao(dadosSelecoesDTO.getNomeSelecao())).thenReturn(false);
    	
    	ResponseEntity<Object> responseSaveSelection = controllerSelecoes.saveSelection(dadosSelecoesDTO);
    	
    	verify(componentSelecoes).save(any(EntitySelecoes.class));
        assertEquals(HttpStatus.OK, responseSaveSelection.getStatusCode());
        assertEquals(new ResponseMessages(HttpStatus.CREATED.value(), "Seleção cadastrada com sucesso."), responseSaveSelection.getBody());
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerSelecoes#getAllSelections(Pageable pageable)}.
     */
    @Test
    void testGetAllSelections() {
    	EntitySelecoes selecao1 = new EntitySelecoes();
    	EntitySelecoes selecao2 = new EntitySelecoes();
    	List<EntitySelecoes> selecoes = Arrays.asList(selecao1, selecao2);
    	
    	Pageable pageable = PageRequest.of(0, 500);
    	
    	when(componentSelecoes.findAll(pageable)).thenReturn(new PageImpl<>(selecoes));
        
        ResponseEntity<List<EntitySelecoes>> responseGetAllSelections = controllerSelecoes.getAllSelections(pageable);
        
        assertEquals(HttpStatus.OK, responseGetAllSelections.getStatusCode());
        assertEquals(selecoes, responseGetAllSelections.getBody());
    }
    
}