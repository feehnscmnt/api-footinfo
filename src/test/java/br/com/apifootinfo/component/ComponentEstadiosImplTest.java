package br.com.apifootinfo.component;

import br.com.apifootinfo.component.impl.ComponentEstadiosImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.apifootinfo.repository.RepositoryEstadios;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityEstadios;
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
 * de validação, cadastro e consulta de estádios.
 * 
 * @author Felipe Nascimento
 * 
 */

class ComponentEstadiosImplTest implements Serializable {
	private static final long serialVersionUID = -1379578416123194644L;
	
	@InjectMocks
	private ComponentEstadiosImpl componentEstadios;
	
	@Mock
	private RepositoryEstadios repositoryEstadios;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link ComponentEstadiosImpl#save()}.
	 */
	@Test
    void testSave() {
		EntityEstadios entityEstadios = new EntityEstadios();
		when(repositoryEstadios.save(entityEstadios)).thenReturn(entityEstadios);
        assertEquals(entityEstadios, componentEstadios.save(entityEstadios));
        verify(repositoryEstadios).save(entityEstadios);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentEstadiosImpl#existsByNomeEstadio(String nomeEstadio)}.
	 */
	@Test
	void testExistsByNomeEstadio() {
		String nomeEstadio = "nomeEstadio";
        when(repositoryEstadios.existsByNomeEstadio(nomeEstadio)).thenReturn(true);
        assertTrue(componentEstadios.existsByNomeEstadio(nomeEstadio));
        verify(repositoryEstadios).existsByNomeEstadio(nomeEstadio);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentEstadiosImpl#findAll(Pageable pageable)}.
	 */
	@Test
    void testFindAll() {
		Pageable pageable = Pageable.unpaged();
		
		EntityEstadios estadio1 = new EntityEstadios();
		EntityEstadios estadio2 = new EntityEstadios();
		Page<EntityEstadios> page = new PageImpl<>(List.of(estadio1, estadio2));
		
		when(repositoryEstadios.findAll(pageable)).thenReturn(page);
        assertEquals(page, componentEstadios.findAll(pageable));
        verify(repositoryEstadios).findAll(pageable);
	}
	
}