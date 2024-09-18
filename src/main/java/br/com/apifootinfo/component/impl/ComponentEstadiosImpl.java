package br.com.apifootinfo.component.impl;

import br.com.apifootinfo.repository.RepositoryEstadios;
import br.com.apifootinfo.component.ComponentEstadios;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import br.com.apifootinfo.entity.EntityEstadios;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Classe service para implementação dos métodos de validação,
 * cadastro e consulta de estádios.
 * 
 * @author Felipe Nascimento
 * 
 */

@Component
public class ComponentEstadiosImpl implements ComponentEstadios, Serializable {
	private static final long serialVersionUID = -5418503250833449186L;
	private transient RepositoryEstadios repositoryEstadios;
	
	/**
	 * Construtor da classe parametrizado para injeção dos repositories.
	 * 
	 * @param repositoryEstadios - {@link RepositoryEstadios} - repositório de estádios
	 * 
	 */
	public ComponentEstadiosImpl(RepositoryEstadios repositoryEstadios) {
		this.repositoryEstadios = repositoryEstadios;
	}
	
	/**
	 * Método responsável por salvar os estádios no banco de dados.
	 * 
	 * @param entityEstadios - {@link EntityEstadios} - dados do estádio
	 * 
	 * @return dados do estádio em json em caso de sucesso
	 * 
	 */
	@Override
	@Transactional
	public EntityEstadios save(EntityEstadios entityEstadios) {
		return repositoryEstadios.save(entityEstadios);
	}
	
	/**
	 * Método responsável por verificar se o estádio a ser cadastrado já consta no banco de dados.
	 * 
	 * @param nomeEstadio - {@link String} - nome do estádio a ser verificado
	 * 
	 * @return true se o estádio já estiver cadastrado / false se o estádio não estiver cadastrado
	 * 
	 */
	@Override
	public boolean existsByNomeEstadio(String nomeEstadio) {
        return repositoryEstadios.existsByNomeEstadio(nomeEstadio);
    }
	
	/**
	 * Método responsável pela busca de todos os estádios no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações dos estádios
	 * 
	 */
	@Override
	public Page<EntityEstadios> findAll(Pageable pageable) {
		return repositoryEstadios.findAll(pageable);
	}
	
}