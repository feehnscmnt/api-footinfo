package br.com.apifootinfo.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.security.web.SecurityFilterChain;
import br.com.apifootinfo.filter.JwtTokenFilter;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.Serializable;
import org.mockito.Mock;

/**
 * Classe test para implementação dos testes unitários dos métodos responsáveis
 * pelas configurações de segurança dos endpoints da API-FootInfo.
 * 
 * @author Felipe Nascimento
 * 
 */

class SecurityConfigTest implements Serializable {
	private static final long serialVersionUID = -1192770191617867221L;
	
	@Mock
    private AuthenticationManagerBuilder authenticationManagerBuilder;
	
	@Mock
    private JwtTokenFilter jwtTokenFilter;
	
	@InjectMocks
    private SecurityConfig securityConfig;
	
	/**
	 * Método responsável pela inicialização dos mocks.
	 */
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	/**
	 * Método responsável pelo teste unitário do método {@link SecurityConfig#securityFilterChain(HttpSecurity httpSecurity, JwtTokenFilter jwtTokenFilter)}.
	 */
	@Test
	void testSecurityFilterChain() throws Exception {
		HttpSecurity httpSecurity = mock(HttpSecurity.class);
		
		when(httpSecurity.sessionManagement(any())).thenReturn(httpSecurity);
        when(httpSecurity.authorizeHttpRequests(any())).thenReturn(httpSecurity);
        when(httpSecurity.addFilterBefore(any(), any())).thenReturn(httpSecurity);
        when(httpSecurity.build()).thenReturn((DefaultSecurityFilterChain) mock(SecurityFilterChain.class));
        
        SecurityFilterChain securityFilterChain = securityConfig.securityFilterChain(httpSecurity, jwtTokenFilter);
        
        verify(httpSecurity).sessionManagement(any());
        verify(httpSecurity).authorizeHttpRequests(any());
        verify(httpSecurity).addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        verify(httpSecurity).build();
        assertNotNull(securityFilterChain);
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link SecurityConfig#configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)}.
	 */
	@Test
	void testConfigureGlobal() throws Exception {
		securityConfig.configureGlobal(authenticationManagerBuilder);
		verify(authenticationManagerBuilder).inMemoryAuthentication();
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link SecurityConfig#jwtTokenFilter()}.
	 */
	@Test
	void testJwtTokenFilter() {
		assertNotNull(securityConfig.jwtTokenFilter());
	}
	
}