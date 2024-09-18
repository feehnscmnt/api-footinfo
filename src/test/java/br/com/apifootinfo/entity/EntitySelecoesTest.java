package br.com.apifootinfo.entity;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.Serializable;
import java.util.UUID;

/**
 * Classe test para implementação dos testes unitários dos métodos equals, hashCode, toString e compare.
 * 
 * @author Felipe Nascimento
 * 
 */

class EntitySelecoesTest implements Serializable {
	private static final long serialVersionUID = 1604920124052596667L;
	private EntitySelecoes entitySelecoes1;
	private EntitySelecoes entitySelecoes2;
	private EntitySelecoes entitySelecoes3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		entitySelecoes1 = new EntitySelecoes();
		entitySelecoes1.setIdSelecao(UUID.randomUUID());
		entitySelecoes1.setNomeSelecao("Seleção Brasileira de Futebol");
		entitySelecoes1.setAssociacaoSelecao("Confederação Brasileira de Futebol (CBF)");
		entitySelecoes1.setConfederacaoSelecao("CONMEBOL (América do Sul)");
		entitySelecoes1.setTreinadorSelecao("Dorival Júnior");
		entitySelecoes1.setEscudoSelecao("escudo.png");
		
		entitySelecoes2 = new EntitySelecoes();
		entitySelecoes2.setIdSelecao(UUID.randomUUID());
		entitySelecoes2.setNomeSelecao("Seleção Brasileira de Futebol");
		entitySelecoes2.setAssociacaoSelecao("Confederação Brasileira de Futebol (CBF)");
		entitySelecoes2.setConfederacaoSelecao("CONMEBOL (América do Sul)");
		entitySelecoes2.setTreinadorSelecao("Dorival Júnior");
		entitySelecoes2.setEscudoSelecao("escudo.png");
		
		entitySelecoes3 = new EntitySelecoes();
		entitySelecoes3.setIdSelecao(UUID.randomUUID());
		entitySelecoes3.setNomeSelecao("Seleção Argentina de Futebol");
		entitySelecoes3.setAssociacaoSelecao("Asociación del Fútbol Argentino (AFA)");
		entitySelecoes3.setConfederacaoSelecao("CONMEBOL (América do Sul)");
		entitySelecoes3.setTreinadorSelecao("Lionel Scaloni");
		entitySelecoes3.setEscudoSelecao("escudo.png");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntitySelecoes#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(entitySelecoes1, entitySelecoes2);
        assertNotEquals(entitySelecoes1, entitySelecoes3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntitySelecoes#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(entitySelecoes1.hashCode(), entitySelecoes1.hashCode());
        assertNotEquals(entitySelecoes1.hashCode(), entitySelecoes3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntitySelecoes#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(entitySelecoes1.toString(), entitySelecoes2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntitySelecoes#compare(EntitySelecoes entitySelecoes1, EntitySelecoes entitySelecoes2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new EntitySelecoes().compare(entitySelecoes1, entitySelecoes3) < 0);
	}
	
}