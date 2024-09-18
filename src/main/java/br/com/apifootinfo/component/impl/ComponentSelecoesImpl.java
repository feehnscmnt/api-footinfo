package br.com.apifootinfo.component.impl;

import br.com.apifootinfo.repository.RepositorySelecoes;
import br.com.apifootinfo.component.ComponentSelecoes;
import org.springframework.stereotype.Component;
import br.com.apifootinfo.entity.EntitySelecoes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Classe service para implementação dos métodos de validação,
 * cadastro e consulta de seleções.
 * 
 * @author Felipe Nascimento
 * 
 */

@Component
public class ComponentSelecoesImpl implements ComponentSelecoes, Serializable {
	private static final long serialVersionUID = -536570784124908314L;
	private transient RepositorySelecoes repositorySelecoes;
	
	/**
	 * Construtor da classe parametrizado para injeção dos repositories.
	 * 
	 * @param repositorySelecoes - {@link RepositorySelecoes} - repositório de seleções
	 * 
	 */
	public ComponentSelecoesImpl(RepositorySelecoes repositorySelecoes) {
		this.repositorySelecoes = repositorySelecoes;
	}
	
	/**
	 * Método responsável por salvar as seleções no banco de dados.
	 * 
	 * @param entitySelecoes - {@link EntitySelecoes} - dados da seleção
	 * 
	 * @return dados da seleção em json em caso de sucesso
	 * 
	 */
	@Override
	@Transactional
    public EntitySelecoes save(EntitySelecoes entitySelecoes) {
        return repositorySelecoes.save(entitySelecoes);
    }
	
	/**
	 * Método responsável por verificar se a seleção a ser cadastrada já consta no banco de dados.
	 * 
	 * @param nomeSelecao - {@link String} - nome da seleção a ser verificada
	 * 
	 * @return true se a seleção já estiver cadastrada / false se a seleção não estiver cadastrada
	 * 
	 */
	@Override
	public boolean existsByNomeSelecao(String nomeSelecao) {
        return repositorySelecoes.existsByNomeSelecao(nomeSelecao);
    }
	
	/**
	 * Método responsável pela busca de todas as seleções no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações das seleções
	 * 
	 */
	@Override
	public Page<EntitySelecoes> findAll(Pageable pageable) {
        return repositorySelecoes.findAll(pageable);
    }
	
}