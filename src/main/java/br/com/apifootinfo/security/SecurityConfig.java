package br.com.apifootinfo.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import br.com.apifootinfo.filter.JwtTokenFilter;
import org.springframework.http.HttpMethod;
import br.com.apifootinfo.util.Constants;
import org.mindrot.jbcrypt.BCrypt;
import java.io.Serializable;
import java.util.Base64;

/**
 * Classe responsável pelas configurações de segurança dos endpoints da API-FootInfo.
 * 
 * @author Felipe Nascimento
 * 
 */

@Configuration
public class SecurityConfig implements Serializable {
	private String apiUsername = new String(Base64.getDecoder().decode(Constants.BASE64_API_USERNAME));
	private String apiPassword = new String(Base64.getDecoder().decode(Constants.BASE64_API_PASSWORD));
	private String apiRole = new String(Base64.getDecoder().decode(Constants.BASE64_API_ROLE));
	private static final long serialVersionUID = 7108217250842338994L;
	
	/**
	 * Método responsável pela configuração HTTP da API-FootInfo.
	 * 
	 * @param httpSecurity - {@link HttpSecurity} - defini a aplicação como stateless (sem gerenciamento de sessão), autoriza acesso a determinados endpoints e adiciona filtros personalizados 
	 * @param jwtTokenFilter - {@link JwtTokenFilter} - intercepta as requisições HTTP para validar e processar o token JWT
	 * 
	 * @return configuração da cadeia de filtros de segurança que será usada pelo Spring Security para gerenciar e proteger as requisições HTTP na aplicação
	 * 
	 * @throws Exception
	 * 
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtTokenFilter jwtTokenFilter) throws Exception {
		httpSecurity
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(auth -> auth
				
			.antMatchers(HttpMethod.GET, String.format("%s%s", Constants.REQUEST_MAPPING_VERSION_API, Constants.ENDPOINT_AUTH)).permitAll()
			
			.anyRequest().authenticated().and()
			.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class));
	
	    return httpSecurity.build();
	}
	
	/**
	 * Método responsável pela configuração de autenticação em memória com um usuário e senha codificados.
	 * 
	 * @param authenticationManagerBuilder - {@link AuthenticationManagerBuilder} - configura e constrói o componente central na autenticação de usuários
	 * 
	 * @throws Exception
	 * 
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication()
	        .withUser(apiUsername)
	        .password(BCrypt.hashpw(apiPassword, BCrypt.gensalt()))
	        .roles(apiRole);
	}
	
	/**
	 * Método responsável pela criação de um bean do tipo {@link JwtTokenFilter} que será utilizado para validar o token JWT nas requisições HTTP.
	 * 
	 * @return o bean do tipo {@link JwtTokenFilter}
	 * 
	 */
	@Bean
	JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
}