package br.com.apifootinfo.component;

import br.com.apifootinfo.component.impl.ComponentEquipesImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.apifootinfo.repository.RepositoryEquipes;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityEquipes;
import org.springframework.data.domain.Page;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.Serializable;
import org.mockito.Mock;
import java.util.List;

/**
 * Classe test para implementação dos testes unitários dos métodos
 * de validação, cadastro e consulta de equipes.
 * 
 * @author Felipe Nascimento
 * 
 */

class ComponentEquipesImplTest implements Serializable {
	private static final long serialVersionUID = 627183251900431139L;
	
	@InjectMocks
	private ComponentEquipesImpl componentEquipes;
	
	@Mock
	private RepositoryEquipes repositoryEquipes;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link ComponentEquipesImpl#save()}.
	 */
	@Test
    void testSave() {
		EntityEquipes entityEquipes = new EntityEquipes();
		when(repositoryEquipes.save(entityEquipes)).thenReturn(entityEquipes);
        assertEquals(entityEquipes, componentEquipes.save(entityEquipes));
        verify(repositoryEquipes).save(entityEquipes);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentEquipesImpl#existsByNomeEquipe(String nomeEquipe)}.
	 */
	@Test
    void testExistsByNomeEquipe() {
		String nomeEquipe = "nomeEquipe";
        when(repositoryEquipes.existsByNomeEquipe(nomeEquipe)).thenReturn(true);
        assertTrue(componentEquipes.existsByNomeEquipe(nomeEquipe));
        verify(repositoryEquipes).existsByNomeEquipe(nomeEquipe);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentEquipesImpl#findAll(Pageable pageable)}.
	 */
	@Test
    void testFindAll() {
		Pageable pageable = Pageable.unpaged();
		
		EntityEquipes equipe1 = new EntityEquipes();
		EntityEquipes equipe2 = new EntityEquipes();
		Page<EntityEquipes> page = new PageImpl<>(List.of(equipe1, equipe2));
		
		when(repositoryEquipes.findAll(pageable)).thenReturn(page);
        assertEquals(page, componentEquipes.findAll(pageable));
        verify(repositoryEquipes).findAll(pageable);
	}
	
}