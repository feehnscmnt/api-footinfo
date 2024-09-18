package br.com.apifootinfo.component;

import br.com.apifootinfo.entity.EntityEstadios;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

/**
 * Interface de implementação da classe de serviço responsável
 * pela implementação dos métodos de validação,
 * cadastro e consulta de estádios.
 * 
 * @author Felipe Nascimento
 * 
 */

public interface ComponentEstadios {
	
	/**
	 * Método responsável por salvar os estádios no banco de dados.
	 * 
	 * @param entityEstadio - {@link EntityEstadios} - dados do estádio
	 * 
	 * @return dados do estádio em json em caso de sucesso
	 * 
	 */
	public EntityEstadios save(EntityEstadios entityEstadio);
	
	/**
	 * Método responsável por verificar se o estádio a ser cadastrado já consta no banco de dados.
	 * 
	 * @param nomeEstadio - {@link String} - nome do estadio a ser verificado
	 * 
	 * @return true se o estádio já estiver cadastrado / false se o estádio não estiver cadastrado
	 * 
	 */
	public boolean existsByNomeEstadio(String nomeEstadio);
	
	/**
	 * Método responsável pela busca de todos os estádios no banco de dados.
	 * 
	 * @param pageable - {@link Pageable} - paginação da busca
	 * 
	 * @return informações dos estádios
	 * 
	 */
	public Page<EntityEstadios> findAll(Pageable pageable);
	
}