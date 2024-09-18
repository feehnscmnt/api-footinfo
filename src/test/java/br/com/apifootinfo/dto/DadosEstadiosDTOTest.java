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

class DadosEstadiosDTOTest implements Serializable {
	private static final long serialVersionUID = -4725992697015449397L;
	private DadosEstadiosDTO dadosEstadiosDTO1;
	private DadosEstadiosDTO dadosEstadiosDTO2;
	private DadosEstadiosDTO dadosEstadiosDTO3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		dadosEstadiosDTO1 = new DadosEstadiosDTO();
		dadosEstadiosDTO1.setNomeEstadio("Estadio Diego Armando Maradona");
		dadosEstadiosDTO1.setDataConstrucaoEstadio("1940-04-27");
		dadosEstadiosDTO1.setDataInaugEstadio("2003-12-26");
		dadosEstadiosDTO1.setCapacidadeEstadio("25500");
		dadosEstadiosDTO1.setRecordePublicoEstadio("Sem informação");
		dadosEstadiosDTO1.setLocalizacaoEstadio("Buenos Aires, Argentina");
		dadosEstadiosDTO1.setFotoEstadio("foto.png");
		
		dadosEstadiosDTO2 = new DadosEstadiosDTO();
		dadosEstadiosDTO2.setNomeEstadio("Estadio Diego Armando Maradona");
		dadosEstadiosDTO2.setDataConstrucaoEstadio("1940-04-27");
		dadosEstadiosDTO2.setDataInaugEstadio("2003-12-26");
		dadosEstadiosDTO2.setCapacidadeEstadio("25500");
		dadosEstadiosDTO2.setRecordePublicoEstadio("Sem informação");
		dadosEstadiosDTO2.setLocalizacaoEstadio("Buenos Aires, Argentina");
		dadosEstadiosDTO2.setFotoEstadio("foto.png");
		
		dadosEstadiosDTO3 = new DadosEstadiosDTO();
		dadosEstadiosDTO3.setNomeEstadio("Estadio Julio Humberto Grondona");
		dadosEstadiosDTO3.setDataConstrucaoEstadio("1962-10-11");
		dadosEstadiosDTO3.setDataInaugEstadio("1964-08-22");
		dadosEstadiosDTO3.setCapacidadeEstadio("16000");
		dadosEstadiosDTO3.setRecordePublicoEstadio("18300 (2024-02-04)");
		dadosEstadiosDTO3.setLocalizacaoEstadio("Buenos Aires, Argentina");
		dadosEstadiosDTO3.setFotoEstadio("foto.png");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEstadiosDTO#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(dadosEstadiosDTO1, dadosEstadiosDTO2);
        assertNotEquals(dadosEstadiosDTO1, dadosEstadiosDTO3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEstadiosDTO#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(dadosEstadiosDTO1.hashCode(), dadosEstadiosDTO2.hashCode());
        assertNotEquals(dadosEstadiosDTO1.hashCode(), dadosEstadiosDTO3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEstadiosDTO#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(dadosEstadiosDTO1.toString(), dadosEstadiosDTO2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEstadiosDTO#compare(DadosEstadiosDTO dadosEstadiosDTO1, DadosEstadiosDTO dadosEstadiosDTO2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new DadosEstadiosDTO().compare(dadosEstadiosDTO1, dadosEstadiosDTO3) < 0);
	}
	
}