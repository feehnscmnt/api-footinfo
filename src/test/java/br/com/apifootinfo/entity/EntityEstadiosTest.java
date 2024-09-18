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

class EntityEstadiosTest implements Serializable {
	private static final long serialVersionUID = 6783871256577836771L;
	private EntityEstadios entityEstadios1;
	private EntityEstadios entityEstadios2;
	private EntityEstadios entityEstadios3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		entityEstadios1 = new EntityEstadios();
		entityEstadios1.setIdEstadio(UUID.randomUUID());
		entityEstadios1.setNomeEstadio("Estadio Diego Armando Maradona");
		entityEstadios1.setDataConstrucaoEstadio("1940-04-27");
		entityEstadios1.setDataInaugEstadio("2003-12-26");
		entityEstadios1.setCapacidadeEstadio("25500");
		entityEstadios1.setRecordePublicoEstadio("Sem informação");
		entityEstadios1.setLocalizacaoEstadio("Buenos Aires, Argentina");
		entityEstadios1.setFotoEstadio("foto.png");
		
		entityEstadios2 = new EntityEstadios();
		entityEstadios2.setIdEstadio(UUID.randomUUID());
		entityEstadios2.setNomeEstadio("Estadio Diego Armando Maradona");
		entityEstadios2.setDataConstrucaoEstadio("1940-04-27");
		entityEstadios2.setDataInaugEstadio("2003-12-26");
		entityEstadios2.setCapacidadeEstadio("25500");
		entityEstadios2.setRecordePublicoEstadio("Sem informação");
		entityEstadios2.setLocalizacaoEstadio("Buenos Aires, Argentina");
		entityEstadios2.setFotoEstadio("foto.png");
		
		entityEstadios3 = new EntityEstadios();
		entityEstadios3.setIdEstadio(UUID.randomUUID());
		entityEstadios3.setNomeEstadio("Estadio Julio Humberto Grondona");
		entityEstadios3.setDataConstrucaoEstadio("1962-10-11");
		entityEstadios3.setDataInaugEstadio("1964-08-22");
		entityEstadios3.setCapacidadeEstadio("16000");
		entityEstadios3.setRecordePublicoEstadio("18300 (2024-02-04)");
		entityEstadios3.setLocalizacaoEstadio("Buenos Aires, Argentina");
		entityEstadios3.setFotoEstadio("foto.png");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEstadios#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(entityEstadios1, entityEstadios2);
        assertNotEquals(entityEstadios1, entityEstadios3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEstadios#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(entityEstadios1.hashCode(), entityEstadios2.hashCode());
        assertNotEquals(entityEstadios1.hashCode(), entityEstadios3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEstadios#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(entityEstadios1.toString(), entityEstadios2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityEstadios#compare(EntityEstadios entityEstadios1, EntityEstadios entityEstadios2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new EntityEstadios().compare(entityEstadios1, entityEstadios3) < 0);
	}
	
}