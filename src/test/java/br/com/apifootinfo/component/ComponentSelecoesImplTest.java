package br.com.apifootinfo.component;

import br.com.apifootinfo.component.impl.ComponentSelecoesImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import br.com.apifootinfo.repository.RepositorySelecoes;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntitySelecoes;
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
 * de validação, cadastro e consulta de seleções.
 * 
 * @author Felipe Nascimento
 * 
 */

class ComponentSelecoesImplTest implements Serializable {
	private static final long serialVersionUID = 6453752199595280555L;
	
	@InjectMocks
	private ComponentSelecoesImpl componentSelecoes;
	
	@Mock
	private RepositorySelecoes repositorySelecoes;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link ComponentSelecoesImpl#save()}.
	 */
	@Test
    void testSave() {
		EntitySelecoes entitySelecoes = new EntitySelecoes();
		when(repositorySelecoes.save(entitySelecoes)).thenReturn(entitySelecoes);
        assertEquals(entitySelecoes, componentSelecoes.save(entitySelecoes));
        verify(repositorySelecoes).save(entitySelecoes);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentSelecoesImpl#existsByNomeSelecao(String nomeSelecao)}.
	 */
	@Test
	void testExistsByNomeSelecao() {
		String nomeSelecao = "nomeSelecao";
        when(repositorySelecoes.existsByNomeSelecao(nomeSelecao)).thenReturn(true);
        assertTrue(componentSelecoes.existsByNomeSelecao(nomeSelecao));
        verify(repositorySelecoes).existsByNomeSelecao(nomeSelecao);
	}
	
	/**
	 * Método responsável pelo teste unitário do metodo {@link ComponentSelecoesImpl#findAll(Pageable pageable)}.
	 */
	@Test
    void testFindAll() {
		Pageable pageable = Pageable.unpaged();
		
		EntitySelecoes selecao1 = new EntitySelecoes();
		EntitySelecoes selecao2 = new EntitySelecoes();
		Page<EntitySelecoes> page = new PageImpl<>(List.of(selecao1, selecao2));
		
		when(repositorySelecoes.findAll(pageable)).thenReturn(page);
        assertEquals(page, componentSelecoes.findAll(pageable));
        verify(repositorySelecoes).findAll(pageable);
	}
	
}