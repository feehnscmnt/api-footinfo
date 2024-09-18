package br.com.apifootinfo.dto;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.Serializable;

/**
 * Classe test para implementação dos testes unitários dos métodos equals, hashCode, toString e compare.
 * 
 * @author Felipe Nascimento
 * 
 */

class DadosSelecoesDTOTest implements Serializable {
	private static final long serialVersionUID = 4027457319860092070L;
	private DadosSelecoesDTO dadosSelecoesDTO1;
	private DadosSelecoesDTO dadosSelecoesDTO2;
	private DadosSelecoesDTO dadosSelecoesDTO3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		dadosSelecoesDTO1 = new DadosSelecoesDTO();
		dadosSelecoesDTO1.setNomeSelecao("Seleção Brasileira de Futebol");
		dadosSelecoesDTO1.setAssociacaoSelecao("Confederação Brasileira de Futebol (CBF)");
		dadosSelecoesDTO1.setConfederacaoSelecao("CONMEBOL (América do Sul)");
		dadosSelecoesDTO1.setTreinadorSelecao("Dorival Júnior");
		dadosSelecoesDTO1.setEscudoSelecao("escudo.png");
		
		dadosSelecoesDTO2 = new DadosSelecoesDTO();
		dadosSelecoesDTO2.setNomeSelecao("Seleção Brasileira de Futebol");
		dadosSelecoesDTO2.setAssociacaoSelecao("Confederação Brasileira de Futebol (CBF)");
		dadosSelecoesDTO2.setConfederacaoSelecao("CONMEBOL (América do Sul)");
		dadosSelecoesDTO2.setTreinadorSelecao("Dorival Júnior");
		dadosSelecoesDTO2.setEscudoSelecao("escudo.png");
		
		dadosSelecoesDTO3 = new DadosSelecoesDTO();
		dadosSelecoesDTO3.setNomeSelecao("Seleção Argentina de Futebol");
		dadosSelecoesDTO3.setAssociacaoSelecao("Asociación del Fútbol Argentino (AFA)");
		dadosSelecoesDTO3.setConfederacaoSelecao("CONMEBOL (América do Sul)");
		dadosSelecoesDTO3.setTreinadorSelecao("Lionel Scaloni");
		dadosSelecoesDTO3.setEscudoSelecao("escudo.png");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosSelecoesDTO#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(dadosSelecoesDTO1, dadosSelecoesDTO2);
        assertNotEquals(dadosSelecoesDTO1, dadosSelecoesDTO3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosSelecoesDTO#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(dadosSelecoesDTO1.hashCode(), dadosSelecoesDTO2.hashCode());
        assertNotEquals(dadosSelecoesDTO1.hashCode(), dadosSelecoesDTO3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosSelecoesDTO#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(dadosSelecoesDTO1.toString(), dadosSelecoesDTO2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosSelecoesDTO#compare(DadosSelecoesDTO dadosSelecoesDTO1, DadosSelecoesDTO dadosSelecoesDTO2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new DadosSelecoesDTO().compare(dadosSelecoesDTO1, dadosSelecoesDTO3) < 0);
	}
	
}