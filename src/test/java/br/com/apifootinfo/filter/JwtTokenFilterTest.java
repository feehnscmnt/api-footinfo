package br.com.apifootinfo.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import br.com.apifootinfo.util.JwtUtils;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import javax.servlet.ServletException;
import org.junit.jupiter.api.Test;
import javax.servlet.FilterChain;
import java.io.Serializable;
import java.io.IOException;
import org.mockito.Mock;

/**
 * Classe test para implementação dos testes unitários do método
 * pela extração e validação do token JWT informado no cabeçalho da requisição.
 * 
 * @author Felipe Nascimento
 * 
 */

class JwtTokenFilterTest implements Serializable {
	private static final long serialVersionUID = 3711790004086448232L;
	private JwtTokenFilter jwtTokenFilter;
	
	@Mock
    private HttpServletResponse resp;
	
	@Mock
    private FilterChain filterChain;
	
	@Mock
    private HttpServletRequest req;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
		jwtTokenFilter = new JwtTokenFilter();
        MockitoAnnotations.openMocks(this);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link JwtTokenFilter#doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)}
	 * quando o Token JWT passado na requisição for válido.
	 */
	@Test
	void testDoFilterInternalTokenJwtValido() throws IOException, ServletException {
		var mock = mockStatic(JwtUtils.class);
		String token = "tokenJwtValidoAqui";
		String usuario = "usuarioApi";
		
		mock.when(() -> JwtUtils.validateTokenAndGetUsername(token)).thenReturn(usuario);
		when(req.getHeader("Authorization")).thenReturn(String.format("Bearer %s", token));
		
		jwtTokenFilter.doFilterInternal(req, resp, filterChain);
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
        assertNotNull(securityContext.getAuthentication());
        assertEquals(usuario, securityContext.getAuthentication().getName());
        verify(filterChain).doFilter(req, resp);
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link JwtTokenFilter#doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)}
	 * quando o Token JWT passado na requisição for inválido.
	 */
	@Test
	void testDoFilterInternalTokenJwtInvalido() throws IOException, ServletException {
		when(req.getHeader("Authorization")).thenReturn(null);
		
		jwtTokenFilter.doFilterInternal(req, resp, filterChain);
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
        assertNull(securityContext.getAuthentication());
        verify(filterChain).doFilter(req, resp);
	}
	
}