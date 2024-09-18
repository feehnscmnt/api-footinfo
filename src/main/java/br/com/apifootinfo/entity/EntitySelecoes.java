package br.com.apifootinfo.entity;

import br.com.apifootinfo.util.Constants;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe entity responsável por gerar o tabela de seleções no banco de dados.
 * 
 * @author Felipe Nascimento
 * 
 */

@Entity
@Table(name = Constants.SELECTIONS_TABLE_NAME)
public class EntitySelecoes implements Comparator<EntitySelecoes>, Serializable {
	private static final long serialVersionUID = -2681335791434325323L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idSelecao;
	
	@Column(nullable = false, length = 100)
	private String nomeSelecao;
	
	@Column(nullable = false, length = 100)
	private String associacaoSelecao;
	
	@Column(nullable = false, length = 100)
	private String confederacaoSelecao;
	
	@Column(nullable = false, length = 100)
	private String treinadorSelecao;
	
	@Column(nullable = false, length = 250)
	private String escudoSelecao;
	
	/**
	 * Retorna o atributo idSelecao.
	 * 
	 * @return o id da seleção do tipo {@link UUID}.
	 * 
	 */
	public UUID getIdSelecao() {
		return idSelecao;
	}
	
	/**
	 * Especifica o atributo idSelecao.
	 * .
	 * @param idSelecao {@link UUID} referente ao id da seleção que será setado.
	 * 
	 */
	public void setIdSelecao(UUID idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	/**
	 * Retorna o atributo nomeSelecao.
	 * 
	 * @return o nome da seleção do tipo {@link String}.
	 * 
	 */
	public String getNomeSelecao() {
		return nomeSelecao;
	}
	
	/**
	 * Especifica o atributo nomeSelecao.
	 * .
	 * @param nomeSelecao {@link String} referente ao nome da seleção que será setado.
	 * 
	 */
	public void setNomeSelecao(String nomeSelecao) {
		this.nomeSelecao = nomeSelecao;
	}
	
	/**
	 * Retorna o atributo associacaoSelecao.
	 * 
	 * @return a associação da seleção do tipo {@link String}.
	 * 
	 */
	public String getAssociacaoSelecao() {
		return associacaoSelecao;
	}
	
	/**
	 * Especifica o atributo associacaoSelecao.
	 * .
	 * @param associacaoSelecao {@link String} referente à associação da seleção que será setada.
	 * 
	 */
	public void setAssociacaoSelecao(String associacaoSelecao) {
		this.associacaoSelecao = associacaoSelecao;
	}
	
	/**
	 * Retorna o atributo confederacaoSelecao.
	 * 
	 * @return a confederação da seleção do tipo {@link String}.
	 * 
	 */
	public String getConfederacaoSelecao() {
		return confederacaoSelecao;
	}
	
	/**
	 * Especifica o atributo confederacaoSelecao.
	 * .
	 * @param confederacaoSelecao {@link String} referente à confederação da seleção que será setada.
	 * 
	 */
	public void setConfederacaoSelecao(String confederacaoSelecao) {
		this.confederacaoSelecao = confederacaoSelecao;
	}
	
	/**
	 * Retorna o atributo treinadorSelecao.
	 * 
	 * @return o treinador da seleção do tipo {@link String}.
	 * 
	 */
	public String getTreinadorSelecao() {
		return treinadorSelecao;
	}
	
	/**
	 * Especifica o atributo treinadorSelecao.
	 * .
	 * @param treinadorSelecao {@link String} referente ao treinador da seleção que será setado.
	 * 
	 */
	public void setTreinadorSelecao(String treinadorSelecao) {
		this.treinadorSelecao = treinadorSelecao;
	}
	
	/**
	 * Retorna o atributo escudoSelecao.
	 * 
	 * @return a imagem do escudo da seleção do tipo {@link String}.
	 * 
	 */
	public String getEscudoSelecao() {
		return escudoSelecao;
	}
	
	/**
	 * Especifica o atributo escudoSelecao.
	 * .
	 * @param escudoSelecao {@link String} referente à imagem do escudo da seleção que será setada.
	 * 
	 */
	public void setEscudoSelecao(String escudoSelecao) {
		this.escudoSelecao = escudoSelecao;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		EntitySelecoes entitySelecoes = (EntitySelecoes) object;
		
		return Objects.equals(idSelecao, entitySelecoes.idSelecao)
			&& Objects.equals(nomeSelecao, entitySelecoes.nomeSelecao)
			&& Objects.equals(associacaoSelecao, entitySelecoes.associacaoSelecao)
			&& Objects.equals(confederacaoSelecao, entitySelecoes.confederacaoSelecao)
			&& Objects.equals(treinadorSelecao, entitySelecoes.treinadorSelecao)
			&& Objects.equals(escudoSelecao, entitySelecoes.escudoSelecao);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			idSelecao,
			nomeSelecao,
			associacaoSelecao,
			confederacaoSelecao,
			treinadorSelecao,
			escudoSelecao
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Id da Seleção: ").append(idSelecao)
			.append(", Nome da Seleção: ").append(nomeSelecao)
			.append(", Associação da Seleção: ").append(associacaoSelecao)
			.append(", Confederação da Seleção: ").append(confederacaoSelecao)
			.append(", Treinador da Seleção: ").append(treinadorSelecao)
			.append(", Escudo da Seleção: ").append(escudoSelecao));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(EntitySelecoes entitySelecoes1, EntitySelecoes entitySelecoes2) {
		return entitySelecoes1.getNomeSelecao().compareTo(entitySelecoes2.getNomeSelecao());
	}
	
}