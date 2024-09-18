package br.com.apifootinfo.component;

import br.com.apifootinfo.entity.EntitySelecoes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

/**
 * Interface de implementação da classe de serviço responsável
 * pela implementação dos métodos de validação,
 * cadastro e consulta de seleções.
 * 
 * @author Felipe Nascimento
 * 
 */

public interface ComponentSelecoes {
		
	/**
	 * Método responsável por salvar as seleções no banco de dados.
	 * 
	 * @param entitySelecoes - {@link EntitySelecoes} - dados da seleção
	 * 
	 * @return dados da seleção em json em caso de sucesso
	 * 
	 */
    public EntitySelecoes save(EntitySelecoes entitySelecoes);
	
	/**
	 * Método responsável por verificar se a seleção a ser cadastrada já consta no banco de dados.
	 * 
	 * @param nomeSelecao - {@link String} - nome da seleção a ser verificada
	 * 
	 * @return true se a seleção já estiver cadastrada / false se a seleção não estiver cadastrada
	 * 
	 */
	public boolean existsByNomeSelecao(String nomeSelecao);
	
	/**
	 * Método responsável pela busca de todas as seleções no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações das seleções
	 * 
	 */
	public Page<EntitySelecoes> findAll(Pageable pageable);
	
}