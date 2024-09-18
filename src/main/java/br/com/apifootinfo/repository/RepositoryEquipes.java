package br.com.apifootinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.apifootinfo.entity.EntityEquipes;
import java.util.UUID;

/**
 * Interface repository para implementação do método de validação do cadastro de equipes.
 * 
 * @author Felipe Nascimento
 * 
 */

@Repository
public interface RepositoryEquipes extends JpaRepository<EntityEquipes, UUID> {
	
	/**
	 * Método responsável por verificar se a equipe a ser cadastrada já consta no banco de dados.
	 * 
	 * @param nomeEquipe - {@link String} - nome da equipe a ser verificada
	 * 
	 * @return true se a equipe já estiver cadastrada / false se a equipe não estiver cadastrada
	 * 
	 */
	public boolean existsByNomeEquipe(String nomeEquipe);
	
}