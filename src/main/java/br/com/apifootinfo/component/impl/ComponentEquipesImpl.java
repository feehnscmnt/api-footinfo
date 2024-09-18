package br.com.apifootinfo.component.impl;

import br.com.apifootinfo.repository.RepositoryEquipes;
import br.com.apifootinfo.component.ComponentEquipes;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import br.com.apifootinfo.entity.EntityEquipes;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Classe service para implementação dos métodos de validação,
 * cadastro e consulta de equipes.
 * 
 * @author Felipe Nascimento
 * 
 */

@Component
public class ComponentEquipesImpl implements ComponentEquipes, Serializable {
	private static final long serialVersionUID = -4208873912036178362L;
	private transient RepositoryEquipes repositoryEquipes;
	
	/**
	 * Construtor da classe parametrizado para injeção dos repositories.
	 * 
	 * @param repositoryEquipes - {@link RepositoryEquipes} - repositório de equipes
	 * 
	 */
	public ComponentEquipesImpl(RepositoryEquipes repositoryEquipes) {
		this.repositoryEquipes = repositoryEquipes;
	}
	
	/**
	 * Método responsável por salvar as equipes no banco de dados.
	 * 
	 * @param entityEquipe - {@link EntityEquipes} - dados da equipe
	 * 
	 * @return dados da equipe em json em caso de sucesso
	 * 
	 */
	@Override
	@Transactional
    public EntityEquipes save(EntityEquipes entityEquipe) {
        return repositoryEquipes.save(entityEquipe);
    }
	
	/**
	 * Método responsável por verificar se a equipe a ser cadastrada já consta no banco de dados.
	 * 
	 * @param nomeEquipe - {@link String} - nome da equipe a ser verificada
	 * 
	 * @return true se a equipe já estiver cadastrada / false se a equipe não estiver cadastrada
	 * 
	 */
	@Override
	public boolean existsByNomeEquipe(String nomeEquipe) {
        return repositoryEquipes.existsByNomeEquipe(nomeEquipe);
    }
	
	/**
	 * Método responsável pela busca de todas as equipes no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações das equipes
	 * 
	 */
	@Override
	public Page<EntityEquipes> findAll(Pageable pageable) {
        return repositoryEquipes.findAll(pageable);
    }
	
}