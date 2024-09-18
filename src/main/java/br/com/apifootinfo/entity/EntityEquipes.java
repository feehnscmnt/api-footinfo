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
 * Classe entity responsável por gerar o tabela de equipes no banco de dados.
 * 
 * @author Felipe Nascimento
 * 
 */

@Entity
@Table(name = Constants.TEAMS_TABLE_NAME)
public class EntityEquipes implements Comparator<EntityEquipes>, Serializable {
	private static final long serialVersionUID = -6952918558108688622L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idEquipe;
	
	@Column(nullable = false, length = 150)
	private String nomeEquipe;
	
	@Column(nullable = false, length = 100)
	private String estadioEquipe;
	
	@Column(nullable = false, length = 100)
	private String ligaEquipe;
	
	@Column(nullable = false, length = 11)
	private String dataFundacaoEquipe;
	
	@Column(nullable = false, length = 15)
	private String siglaEquipe;
	
	@Column(nullable = false, length = 100)
	private String paisEquipe;
	
	@Column(nullable = false, length = 250)
	private String escudoEquipe;
	
	/**
	 * Retorna o atributo idEquipe.
	 * 
	 * @return o id da equipe do tipo {@link UUID}.
	 * 
	 */
	public UUID getIdEquipe() {
		return idEquipe;
	}
	
	/**
	 * Especifica o atributo idEquipe.
	 * .
	 * @param idEquipe {@link UUID} referente ao id da equipe que será setado.
	 * 
	 */
	public void setIdEquipe(UUID idEquipe) {
		this.idEquipe = idEquipe;
	}
	
	/**
	 * Retorna o atributo nomeEquipe.
	 * 
	 * @return o nome da equipe do tipo {@link String}.
	 * 
	 */
	public String getNomeEquipe() {
		return nomeEquipe;
	}
	
	/**
	 * Especifica o atributo nomeEquipe.
	 * .
	 * @param nomeEquipe {@link String} referente ao nome da equipe que será setado.
	 * 
	 */
	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}
	
	/**
	 * Retorna o atributo estadioEquipe.
	 * 
	 * @return o nome do estadio da equipe do tipo {@link String}.
	 * 
	 */
	public String getEstadioEquipe() {
		return estadioEquipe;
	}
	
	/**
	 * Especifica o atributo estadioEquipe.
	 * .
	 * @param estadioEquipe {@link String} referente ao nome do estádio da equipe que será setado.
	 * 
	 */
	public void setEstadioEquipe(String estadioEquipe) {
		this.estadioEquipe = estadioEquipe;
	}
	
	/**
	 * Retorna o atributo ligaEquipe.
	 * 
	 * @return o nome da liga da equipe do tipo {@link String}.
	 * 
	 */
	public String getLigaEquipe() {
		return ligaEquipe;
	}
	
	/**
	 * Especifica o atributo ligaEquipe.
	 * .
	 * @param ligaEquipe {@link String} referente ao nome da liga da equipe que será setado.
	 * 
	 */
	public void setLigaEquipe(String ligaEquipe) {
		this.ligaEquipe = ligaEquipe;
	}
	
	/**
	 * Retorna o atributo dataFundacaoEquipe.
	 * 
	 * @return a data de fundação da equipe do tipo {@link String}.
	 * 
	 */
	public String getDataFundacaoEquipe() {
		return dataFundacaoEquipe;
	}
	
	/**
	 * Especifica o atributo dataFundacaoEquipe.
	 * .
	 * @param dataFundacaoEquipe {@link String} referente à data de fundação da equipe que será setada.
	 * 
	 */
	public void setDataFundacaoEquipe(String dataFundacaoEquipe) {
		this.dataFundacaoEquipe = dataFundacaoEquipe;
	}
	
	/**
	 * Retorna o atributo siglaEquipe.
	 * 
	 * @return a sigla da equipe do tipo {@link String}.
	 * 
	 */
	public String getSiglaEquipe() {
		return siglaEquipe;
	}
	
	/**
	 * Especifica o atributo siglaEquipe.
	 * .
	 * @param siglaEquipe {@link String} referente à sigla da equipe que será setada.
	 * 
	 */
	public void setSiglaEquipe(String siglaEquipe) {
		this.siglaEquipe = siglaEquipe;
	}
	
	/**
	 * Retorna o atributo paisEquipe.
	 * 
	 * @return o país da equipe do tipo {@link String}.
	 * 
	 */
	public String getPaisEquipe() {
		return paisEquipe;
	}
	
	/**
	 * Especifica o atributo paisEquipe.
	 * .
	 * @param paisEquipe {@link String} referente ao país da equipe que será setado.
	 * 
	 */
	public void setPaisEquipe(String paisEquipe) {
		this.paisEquipe = paisEquipe;
	}
	
	/**
	 * Retorna o atributo escudoEquipe.
	 * 
	 * @return a imagem do escudo da equipe do tipo {@link String}.
	 * 
	 */
	public String getEscudoEquipe() {
		return escudoEquipe;
	}
	
	/**
	 * Especifica o atributo escudoEquipe.
	 * .
	 * @param escudoEquipe {@link String} referente à imagem do escudo da equipe que será setada.
	 * 
	 */
	public void setEscudoEquipe(String escudoEquipe) {
		this.escudoEquipe = escudoEquipe;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		EntityEquipes entityEquipes = (EntityEquipes) object;
		
		return Objects.equals(idEquipe, entityEquipes.idEquipe)
			&& Objects.equals(nomeEquipe, entityEquipes.nomeEquipe)
			&& Objects.equals(estadioEquipe, entityEquipes.estadioEquipe)
			&& Objects.equals(ligaEquipe, entityEquipes.ligaEquipe)
			&& Objects.equals(dataFundacaoEquipe, entityEquipes.dataFundacaoEquipe)
			&& Objects.equals(siglaEquipe, entityEquipes.siglaEquipe)
			&& Objects.equals(paisEquipe, entityEquipes.paisEquipe)
			&& Objects.equals(escudoEquipe, entityEquipes.escudoEquipe);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			idEquipe,
			nomeEquipe,
			estadioEquipe,
			ligaEquipe,
			dataFundacaoEquipe,
			siglaEquipe,
			paisEquipe,
			escudoEquipe
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Id da Equipe: ").append(idEquipe)
			.append(", Nome da Equipe: ").append(nomeEquipe)
			.append(", Estádio da Equipe: ").append(estadioEquipe)
			.append(", Liga da Equipe: ").append(ligaEquipe)
			.append(", Data de Fundação da Equipe: ").append(dataFundacaoEquipe)
			.append(", Sigla da Equipe: ").append(siglaEquipe)
			.append(", País da Equipe: ").append(paisEquipe)
			.append(", Escudo da Equipe: ").append(escudoEquipe));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(EntityEquipes entityEquipes1, EntityEquipes entityEquipes2) {
		return entityEquipes1.getNomeEquipe().compareTo(entityEquipes2.getNomeEquipe());
	}
	
}