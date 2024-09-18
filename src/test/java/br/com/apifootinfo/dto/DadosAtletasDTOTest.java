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

class DadosAtletasDTOTest implements Serializable {
	private static final long serialVersionUID = -1612737793567921132L;
	private DadosAtletasDTO dadosAtletasDTO1;
	private DadosAtletasDTO dadosAtletasDTO2;
	private DadosAtletasDTO dadosAtletasDTO3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		dadosAtletasDTO1 = new DadosAtletasDTO();
        dadosAtletasDTO1.setNomeAtleta("João");
        dadosAtletasDTO1.setDataNascimentoAtleta("2000-01-01");
        dadosAtletasDTO1.setNacionalidadeAtleta("Brasileiro");
        dadosAtletasDTO1.setEquipeAtualAtleta("Equipe A");
        dadosAtletasDTO1.setPosicaoAtleta("Atacante");
        dadosAtletasDTO1.setAlturaAtleta("1.80m");
        dadosAtletasDTO1.setCategoriaAtleta("Profissional");
        dadosAtletasDTO1.setFotoAtleta("foto1.jpg");

        dadosAtletasDTO2 = new DadosAtletasDTO();
        dadosAtletasDTO2.setNomeAtleta("João");
        dadosAtletasDTO2.setDataNascimentoAtleta("2000-01-01");
        dadosAtletasDTO2.setNacionalidadeAtleta("Brasileiro");
        dadosAtletasDTO2.setEquipeAtualAtleta("Equipe A");
        dadosAtletasDTO2.setPosicaoAtleta("Atacante");
        dadosAtletasDTO2.setAlturaAtleta("1.80m");
        dadosAtletasDTO2.setCategoriaAtleta("Profissional");
        dadosAtletasDTO2.setFotoAtleta("foto1.jpg");

        dadosAtletasDTO3 = new DadosAtletasDTO();
        dadosAtletasDTO3.setNomeAtleta("Maria");
        dadosAtletasDTO3.setDataNascimentoAtleta("1995-05-15");
        dadosAtletasDTO3.setNacionalidadeAtleta("Argentino");
        dadosAtletasDTO3.setEquipeAtualAtleta("Equipe B");
        dadosAtletasDTO3.setPosicaoAtleta("Meio-campo");
        dadosAtletasDTO3.setAlturaAtleta("1.70m");
        dadosAtletasDTO3.setCategoriaAtleta("Amador");
        dadosAtletasDTO3.setFotoAtleta("foto2.jpg");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosAtletasDTO#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(dadosAtletasDTO1, dadosAtletasDTO2);
        assertNotEquals(dadosAtletasDTO1, dadosAtletasDTO3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosAtletasDTO#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(dadosAtletasDTO1.hashCode(), dadosAtletasDTO2.hashCode());
        assertNotEquals(dadosAtletasDTO1.hashCode(), dadosAtletasDTO3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosAtletasDTO#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(dadosAtletasDTO1.toString(), dadosAtletasDTO2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosAtletasDTO#compare(DadosAtletasDTO dadosAtletasDTO1, DadosAtletasDTO dadosAtletasDTO2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new DadosAtletasDTO().compare(dadosAtletasDTO1, dadosAtletasDTO3) < 0);
	}
	
}