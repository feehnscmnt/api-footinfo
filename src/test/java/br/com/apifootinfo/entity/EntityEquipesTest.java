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

class EntityEquipesTest implements Serializable {
	private static final long serialVersionUID = -7841664392133841863L;
	private EntityEquipes entityEquipes1;
	private EntityEquipes entityEquipes2;
	private EntityEquipes entityEquipes3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		entityEquipes1 = new EntityEquipes();
		entityEquipes1.setIdEquipe(UUID.randomUUID());
		entityEquipes1.setNomeEquipe("Sport Club Corinthians Paulista");
		entityEquipes1.setEstadioEquipe("Neo Química Arena");
		entityEquipes1.setLigaEquipe("Campeonato Brasileiro Série A");
		entityEquipes1.setDataFundacaoEquipe("1910-09-01");
		entityEquipes1.setSiglaEquipe("SCCP");
		entityEquipes1.setPaisEquipe("Brasil");
		entityEquipes1.setEscudoEquipe("escudo.png");
		
		entityEquipes2 = new EntityEquipes();
		entityEquipes2.setIdEquipe(UUID.randomUUID());
		entityEquipes2.setNomeEquipe("Sport Club Corinthians Paulista");
		entityEquipes2.setEstadioEquipe("Neo Química Arena");
		entityEquipes2.setLigaEquipe("Campeonato Brasileiro Série A");
		entityEquipes2.setDataFundacaoEquipe("1910-09-01");
		entityEquipes2.setSiglaEquipe("SCCP");
		entityEquipes2.setPaisEquipe("Brasil");
		entityEquipes2.setEscudoEquipe("escudo.png");
		
		entityEquipes3 = new EntityEquipes();
		entityEquipes3.setIdEquipe(UUID.randomUUID());
		entityEquipes3.setNomeEquipe("Sociedade Esportiva Palmeiras");
		entityEquipes3.setEstadioEquipe("Allianz Parque");
		entityEquipes3.setLigaEquipe("Campeonato Brasileiro Série A");
		entityEquipes3.setDataFundacaoEquipe("1914-08-26");
		entityEquipes3.setSiglaEquipe("SEP");
		entityEquipes3.setPaisEquipe("Brasil");
		entityEquipes3.setEscudoEquipe("escudo.png");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEquipes#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(entityEquipes1, entityEquipes2);
        assertNotEquals(entityEquipes1, entityEquipes3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEquipes#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(entityEquipes1.hashCode(), entityEquipes2.hashCode());
        assertNotEquals(entityEquipes1.hashCode(), entityEquipes3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEquipes#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(entityEquipes1.toString(), entityEquipes2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEquipes#compare(EntityEquipes entityEquipes1, EntityEquipes entityEquipes2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new EntityEquipes().compare(entityEquipes1, entityEquipes3) < 0);
	}
	
}