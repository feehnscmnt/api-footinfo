package br.com.apifootinfo;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Classe responsável pela inicialização da API-FootInfo em um contêiner de Servlet.
 * 
 * @author Felipe Nascimento
 * 
 */

public class ServletInitializer extends SpringBootServletInitializer {
	
	/**
	 * Método responsável por garantir a inicialização da API-FootInfo com as configuração
	 * definidas na classe {@link ApiFootInfoApplication}.
	 * 
	 * @param application - {@link SpringApplicationBuilder} - classe que configura a aplicação Spring Boot
	 * 
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiFootInfoApplication.class);
	}

}