package br.com.apifootinfo.component;

import br.com.apifootinfo.component.impl.ComponentAtletasImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.apifootinfo.repository.RepositoryAtletas;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityAtletas;
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
 * de validação, cadastro e consulta de atletas.
 * 
 * @author Felipe Nascimento
 * 
 */

class ComponentAtletasImplTest implements Serializable {
	private static final long serialVersionUID = 5977308682849461440L;
	
	@InjectMocks
    private ComponentAtletasImpl componentAtletas;
	
	@Mock
    private RepositoryAtletas repositoryAtletas;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link ComponentAtletasImpl#save()}.
	 */
	@Test
    void testSave() {
		EntityAtletas entityAtletas = new EntityAtletas();
        when(repositoryAtletas.save(entityAtletas)).thenReturn(entityAtletas);
        assertEquals(entityAtletas, componentAtletas.save(entityAtletas));
        verify(repositoryAtletas).save(entityAtletas);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentAtletasImpl#existsByNomeAtleta(String nomeAtleta)}.
	 */
	@Test
    void testExistsByNomeAtleta() {
		String nomeAtleta = "nomeAtleta";
        when(repositoryAtletas.existsByNomeAtleta(nomeAtleta)).thenReturn(true);
        assertTrue(componentAtletas.existsByNomeAtleta(nomeAtleta));
        verify(repositoryAtletas).existsByNomeAtleta(nomeAtleta);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentAtletasImpl#findAll(Pageable pageable)}.
	 */
	@Test
    void testFindAll() {
        Pageable pageable = Pageable.unpaged();
        
        EntityAtletas atleta1 = new EntityAtletas();
        EntityAtletas atleta2 = new EntityAtletas();
        Page<EntityAtletas> page = new PageImpl<>(List.of(atleta1, atleta2));
        
        when(repositoryAtletas.findAll(pageable)).thenReturn(page);
        assertEquals(page, componentAtletas.findAll(pageable));
        verify(repositoryAtletas).findAll(pageable);
	}
	
}