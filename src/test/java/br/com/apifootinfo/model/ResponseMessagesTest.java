package br.com.apifootinfo.model;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.Serializable;

/**
 * Classe test para implementação dos testes unitários dos métodos equals, hashCode, toString e compare.
 * 
 * @author Felipe Nascimento
 * 
 */

class ResponseMessagesTest implements Serializable {
	private static final long serialVersionUID = 2396413633758785546L;
	private ResponseMessages responseMessages1;
	private ResponseMessages responseMessages2;
	private ResponseMessages responseMessages3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		responseMessages1 = new ResponseMessages(HttpStatus.CONFLICT.value(), "Este(a) atleta já está cadastrado(a).");
		responseMessages2 = new ResponseMessages(HttpStatus.CONFLICT.value(), "Este(a) atleta já está cadastrado(a).");
		responseMessages3 = new ResponseMessages(HttpStatus.CREATED.value(), "Atleta cadastrado(a) com sucesso.");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link ResponseMessages#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(responseMessages1, responseMessages2);
        assertNotEquals(responseMessages1, responseMessages3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link ResponseMessages#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(responseMessages1.hashCode(), responseMessages2.hashCode());
        assertNotEquals(responseMessages1.hashCode(), responseMessages3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link ResponseMessages#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(responseMessages1.toString(), responseMessages2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link ResponseMessages#compare(ResponseMessages responseMessages1, ResponseMessages responseMessages2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new ResponseMessages(HttpStatus.CONFLICT.value(),
        	"Este(a) atleta já está cadastrado(a).").compare(responseMessages1, responseMessages3) < 0);
	}
	
}