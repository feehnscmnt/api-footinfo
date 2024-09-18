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

class DadosEquipesDTOTest implements Serializable {
	private static final long serialVersionUID = -5073898907599754619L;
	private DadosEquipesDTO dadosEquipesDTO1;
	private DadosEquipesDTO dadosEquipesDTO2;
	private DadosEquipesDTO dadosEquipesDTO3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		dadosEquipesDTO1 = new DadosEquipesDTO();
		dadosEquipesDTO1.setNomeEquipe("Sport Club Corinthians Paulista");
		dadosEquipesDTO1.setEstadioEquipe("Neo Química Arena");
		dadosEquipesDTO1.setLigaEquipe("Campeonato Brasileiro Série A");
		dadosEquipesDTO1.setDataFundacaoEquipe("1910-09-01");
		dadosEquipesDTO1.setSiglaEquipe("SCCP");
		dadosEquipesDTO1.setPaisEquipe("Brasil");
		dadosEquipesDTO1.setEscudoEquipe("escudo.png");
		
		dadosEquipesDTO2 = new DadosEquipesDTO();
		dadosEquipesDTO2.setNomeEquipe("Sport Club Corinthians Paulista");
		dadosEquipesDTO2.setEstadioEquipe("Neo Química Arena");
		dadosEquipesDTO2.setLigaEquipe("Campeonato Brasileiro Série A");
		dadosEquipesDTO2.setDataFundacaoEquipe("1910-09-01");
		dadosEquipesDTO2.setSiglaEquipe("SCCP");
		dadosEquipesDTO2.setPaisEquipe("Brasil");
		dadosEquipesDTO2.setEscudoEquipe("escudo.png");
		
		dadosEquipesDTO3 = new DadosEquipesDTO();
		dadosEquipesDTO3.setNomeEquipe("Sociedade Esportiva Palmeiras");
		dadosEquipesDTO3.setEstadioEquipe("Allianz Parque");
		dadosEquipesDTO3.setLigaEquipe("Campeonato Brasileiro Série A");
		dadosEquipesDTO3.setDataFundacaoEquipe("1914-08-26");
		dadosEquipesDTO3.setSiglaEquipe("SEP");
		dadosEquipesDTO3.setPaisEquipe("Brasil");
		dadosEquipesDTO3.setEscudoEquipe("escudo.png");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEquipesDTO#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(dadosEquipesDTO1, dadosEquipesDTO2);
        assertNotEquals(dadosEquipesDTO1, dadosEquipesDTO3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEquipesDTO#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(dadosEquipesDTO1.hashCode(), dadosEquipesDTO2.hashCode());
        assertNotEquals(dadosEquipesDTO1.hashCode(), dadosEquipesDTO3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEquipesDTO#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(dadosEquipesDTO1.toString(), dadosEquipesDTO2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link DadosEquipesDTO#compare(DadosEquipesDTO dadosEquipesDTO1, DadosEquipesDTO dadosEquipesDTO2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new DadosEquipesDTO().compare(dadosEquipesDTO1, dadosEquipesDTO3) < 0);
	}
	
}