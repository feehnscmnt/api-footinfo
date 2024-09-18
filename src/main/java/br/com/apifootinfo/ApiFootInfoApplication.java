package br.com.apifootinfo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import br.com.apifootinfo.util.Constants;
import java.io.Serializable;

/**
 * Classe responsável pela inicialização da API-FootInfo.
 * 
 * @author Felipe Nascimento
 * 
 */

@SpringBootApplication
@EntityScan(Constants.PACKAGE_ENTITIES)
@EnableJpaRepositories(Constants.PACKAGE_REPOSITORIES)
@ComponentScan({ Constants.PACKAGE_COMPONENTS_IMPL, Constants.PACKAGE_CONTROLLERS, Constants.PACKAGE_SECURITY })
public class ApiFootInfoApplication implements Serializable {
	private static final long serialVersionUID = 5491401693655443456L;

	public static void main(String[] args) {
		SpringApplication.run(ApiFootInfoApplication.class, args);
	}

}