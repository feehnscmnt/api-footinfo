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

class EntityAtletasTest implements Serializable {
	private static final long serialVersionUID = -5961686658705778167L;
	private EntityAtletas entityAtletas1;
	private EntityAtletas entityAtletas2;
	private EntityAtletas entityAtletas3;
	
	/**
	 * Método responsável pela inicialização dos atributos.
	 */
	@BeforeEach
	void setUp() {
		entityAtletas1 = new EntityAtletas();
		entityAtletas1.setIdAtleta(UUID.randomUUID());
		entityAtletas1.setNomeAtleta("João");
        entityAtletas1.setDataNascimentoAtleta("2000-01-01");
        entityAtletas1.setNacionalidadeAtleta("Brasileiro");
        entityAtletas1.setEquipeAtualAtleta("Equipe A");
        entityAtletas1.setPosicaoAtleta("Atacante");
        entityAtletas1.setAlturaAtleta("1.80m");
        entityAtletas1.setCategoriaAtleta("Profissional");
        entityAtletas1.setFotoAtleta("foto1.jpg");
        
        entityAtletas2 = new EntityAtletas();
		entityAtletas2.setIdAtleta(UUID.randomUUID());
		entityAtletas2.setNomeAtleta("João");
        entityAtletas2.setDataNascimentoAtleta("2000-01-01");
        entityAtletas2.setNacionalidadeAtleta("Brasileiro");
        entityAtletas2.setEquipeAtualAtleta("Equipe A");
        entityAtletas2.setPosicaoAtleta("Atacante");
        entityAtletas2.setAlturaAtleta("1.80m");
        entityAtletas2.setCategoriaAtleta("Profissional");
        entityAtletas2.setFotoAtleta("foto1.jpg");
        
        entityAtletas3 = new EntityAtletas();
        entityAtletas3.setIdAtleta(UUID.randomUUID());
        entityAtletas3.setNomeAtleta("Maria");
        entityAtletas3.setDataNascimentoAtleta("1995-05-15");
        entityAtletas3.setNacionalidadeAtleta("Argentino");
        entityAtletas3.setEquipeAtualAtleta("Equipe B");
        entityAtletas3.setPosicaoAtleta("Meio-campo");
        entityAtletas3.setAlturaAtleta("1.70m");
        entityAtletas3.setCategoriaAtleta("Amador");
        entityAtletas3.setFotoAtleta("foto2.jpg");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityAtletas#equals(Object object)}.
	 */
	@Test
    void testEquals() {
        assertEquals(entityAtletas1, entityAtletas2);
        assertNotEquals(entityAtletas1, entityAtletas3);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityAtletas#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertEquals(entityAtletas1.hashCode(), entityAtletas2.hashCode());
        assertNotEquals(entityAtletas1.hashCode(), entityAtletas3.hashCode());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityAtletas#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals(entityAtletas1.toString(), entityAtletas2.toString());
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link EntityAtletas#compare(EntityAtletas entityAtletas1, EntityAtletas entityAtletas2)}.
	 */
	@Test
    void testCompare() {
        assertTrue(new EntityAtletas().compare(entityAtletas1, entityAtletas3) < 0);
	}
	
}