package br.com.apifootinfo.component.impl;

import br.com.apifootinfo.repository.RepositoryAtletas;
import br.com.apifootinfo.component.ComponentAtletas;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import br.com.apifootinfo.entity.EntityAtletas;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Classe service para implementação dos métodos de validação,
 * cadastro e consulta de atletas.
 * 
 * @author Felipe Nascimento
 * 
 */

@Component
public class ComponentAtletasImpl implements ComponentAtletas, Serializable {
	private static final long serialVersionUID = -9161412138213593090L;
	private transient RepositoryAtletas repositoryAtletas;
	
	/**
	 * Construtor da classe parametrizado para injeção dos repositories.
	 * 
	 * @param repositoryAtletas - {@link RepositoryAtletas} - repositório de atletas
	 * 
	 */
	public ComponentAtletasImpl(RepositoryAtletas repositoryAtletas) {
		this.repositoryAtletas = repositoryAtletas;
	}
	
	/**
	 * Método responsável por salvar os(as) atletas no banco de dados.
	 * 
	 * @param entityAtletas - {@link EntityAtletas} - dados do(a) atleta
	 * 
	 * @return dados do(a) atleta em json em caso de sucesso
	 * 
	 */
	@Override
	@Transactional
    public EntityAtletas save(EntityAtletas entityAtletas) {
        return repositoryAtletas.save(entityAtletas);
    }
	
	/**
	 * Método responsável por verificar se o(a) atleta a ser cadastrado(a) já consta no banco de dados.
	 * 
	 * @param nomeAtleta - {@link String} - nome do(a) atleta a ser verificado(a)
	 * 
	 * @return true se o(a) atleta já estiver cadastrado(a) / false se o(a) atleta não estiver cadastrado(a)
	 * 
	 */
	@Override
	public boolean existsByNomeAtleta(String nomeAtleta) {
        return repositoryAtletas.existsByNomeAtleta(nomeAtleta);
    }
	
	/**
	 * Método responsável pela busca de todos(as) os(as) atletas no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações dos(as) atletas
	 * 
	 */
	@Override
	public Page<EntityAtletas> findAll(Pageable pageable) {
        return repositoryAtletas.findAll(pageable);
    }
	
}