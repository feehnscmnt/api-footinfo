package br.com.apifootinfo.component;

import org.springframework.data.domain.Pageable;
import br.com.apifootinfo.entity.EntityAtletas;
import org.springframework.data.domain.Page;

/**
 * Interface de implementação da classe de serviço responsável
 * pela implementação dos métodos de validação,
 * cadastro e consulta de atletas.
 * 
 * @author Felipe Nascimento
 * 
 */

public interface ComponentAtletas {
	
	/**
	 * Método responsável por salvar os(as) atletas no banco de dados.
	 * 
	 * @param entityAtletas - {@link EntityAtletas} - dados do(a) atleta
	 * 
	 * @return dados do(a) atleta em json em caso de sucesso
	 * 
	 */
    public EntityAtletas save(EntityAtletas entityAtletas);
	
	/**
	 * Método responsável por verificar se o(a) atleta a ser cadastrado(a) já consta no banco de dados.
	 * 
	 * @param nomeAtleta - {@link String} - nome do(a) atleta a ser verificado(a)
	 * 
	 * @return true se o(a) atleta já estiver cadastrado(a) / false se o(a) atleta não estiver cadastrado(a)
	 * 
	 */
	public boolean existsByNomeAtleta(String nomeAtleta);
	
	/**
	 * Método responsável pela busca de todos(as) os(as) atletas no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações dos(as) atletas
	 * 
	 */
	public Page<EntityAtletas> findAll(Pageable pageable);
	
}