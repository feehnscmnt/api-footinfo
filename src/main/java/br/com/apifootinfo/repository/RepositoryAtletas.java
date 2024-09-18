package br.com.apifootinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.apifootinfo.entity.EntityAtletas;
import java.util.UUID;

/**
 * Interface repository para implementação do método de validação do cadastro de atletas.
 * 
 * @author Felipe Nascimento
 * 
 */

@Repository
public interface RepositoryAtletas extends JpaRepository<EntityAtletas, UUID> {
	
	/**
	 * Método responsável por verificar se o(a) atleta a ser cadastrado(a) já consta no banco de dados.
	 * 
	 * @param nomeAtleta - {@link String} - nome do(a) atleta a ser verificado
	 * 
	 * @return true se o(a) atleta já estiver cadastrado(a) / false se o(a) atleta não estiver cadastrado(a)
	 * 
	 */
	public boolean existsByNomeAtleta(String nomeAtleta);
	
}