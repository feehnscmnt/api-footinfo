package br.com.apifootinfo.component;

import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityEquipes;
import org.springframework.data.domain.Page;

/**
 * Interface de implementação da classe de serviço responsável
 * pela implementação dos métodos de validação,
 * cadastro e consulta de equipes.
 * 
 * @author Felipe Nascimento
 * 
 */

public interface ComponentEquipes {
		
	/**
	 * Método responsável por salvar as equipes no banco de dados.
	 * 
	 * @param entityEquipe - {@link EntityEquipes} - dados da equipe
	 * 
	 * @return dados da equipe em json em caso de sucesso
	 * 
	 */
    public EntityEquipes save(EntityEquipes entityEquipe);
	
	/**
	 * Método responsável por verificar se a equipe a ser cadastrada já consta no banco de dados.
	 * 
	 * @param nomeEquipe - {@link String} - nome da equipe a ser verificada
	 * 
	 * @return true se a equipe já estiver cadastrada / false se a equipe não estiver cadastrada
	 * 
	 */
	public boolean existsByNomeEquipe(String nomeEquipe);
	
	/**
	 * Método responsável pela busca de todas as equipes no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações das equipes
	 * 
	 */
	public Page<EntityEquipes> findAll(Pageable pageable);
	
}