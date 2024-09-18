package br.com.apifootinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.apifootinfo.entity.EntitySelecoes;
import java.util.UUID;

/**
 * Interface repository para implementação do método de validação do cadastro de seleções.
 * 
 * @author Felipe Nascimento
 * 
 */

@Repository
public interface RepositorySelecoes extends JpaRepository<EntitySelecoes, UUID> {
	
	/**
	 * Método responsável por verificar se a seleção a ser cadastrada já consta no banco de dados.
	 * 
	 * @param nomeSelecao - {@link String} - nome da seleção a ser verificada
	 * 
	 * @return true se a seleção já estiver cadastrada / false se a seleção não estiver cadastrada
	 * 
	 */
	public boolean existsByNomeSelecao(String nomeSelecao);
	
}