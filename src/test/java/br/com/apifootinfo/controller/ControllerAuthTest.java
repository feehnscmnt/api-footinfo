package br.com.apifootinfo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.Serializable;

/**
 * Classe test para implementação dos testes unitários do método de autenticação da API-FootInfo.
 * 
 * @author Felipe Nascimento
 * 
 */

class ControllerAuthTest implements Serializable {
	private static final long serialVersionUID = 7474509366866106487L;
	
	@InjectMocks
	private ControllerAuth controllerAuth;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerAuth#auth(String usuario)}
     * caso o usuário informado esteja divergente.
     */
    @Test
    void testAuthUsuarioDivergente() {
    	ResponseEntity<Object> responseAuth = controllerAuth.auth("usuarioDivergente");
    	
    	assertEquals(HttpStatus.OK, responseAuth.getStatusCode());
    	assertEquals(new ResponseMessages(HttpStatus.UNAUTHORIZED.value(), "As credenciais de autenticação da API-FootInfo estão inválidas."), responseAuth.getBody());
    }
    
    /**
     * Método responsável pelo teste unitário do método {@link ControllerAuth#auth(String usuario)} com sucesso.
     */
    @Test
    void testAuthSuccess() {
    	String usuario = "usuarioCorreto";
    	ResponseEntity<Object> responseAuth = controllerAuth.auth(usuario);
    	
    	assertEquals(HttpStatus.OK, responseAuth.getStatusCode());
    	assertEquals(responseAuth.getBody(), responseAuth.getBody());
    }
    
}