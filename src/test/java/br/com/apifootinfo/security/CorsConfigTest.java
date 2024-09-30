package br.com.apifootinfo.security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.Serializable;
import org.mockito.Mock;

/**
 * Classe test para implementação dos testes unitários do método responsável
 * pelas configurações de permissão do CORS.
 * 
 * @author Felipe Nascimento
 * 
 */

class CorsConfigTest implements Serializable {
	private static final long serialVersionUID = -5230147726086626534L;

	@Mock
	private CorsRegistry corsRegistry;
	
	@InjectMocks
	private CorsConfig corsConfig;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link CorsConfig#addCorsMappings(CorsRegistry corsRegistry)}.
	 */
	@Test
	void testAddCorsMappings() {
		corsConfig.addCorsMappings(corsRegistry);
        verify(corsRegistry).addMapping("/v1/**").allowedOrigins("*").allowedMethods("GET", "POST");
	}
	
}