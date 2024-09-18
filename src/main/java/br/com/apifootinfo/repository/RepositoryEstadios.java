package br.com.apifootinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.apifootinfo.entity.EntityEstadios;
import java.util.UUID;

/**
 * Interface repository para implementação do método de validação do cadastro de estádios
 * 
 * @author Felipe Nascimento
 * 
 */

@Repository
public interface RepositoryEstadios extends JpaRepository<EntityEstadios, UUID> {
	
	/**
	 * Método responsável por verificar se o estádio a ser cadastrado já consta no banco de dados.
	 * 
	 * @param nomeEstadio - {@link String} - nome do estádio a ser verificado
	 * 
	 * @return true se o estádio já estiver cadastrado / false se o estádio não estiver cadastrado
	 * 
	 */
	public boolean existsByNomeEstadio(String nomeEstadio);
	
}