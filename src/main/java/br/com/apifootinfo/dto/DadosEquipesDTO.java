package br.com.apifootinfo.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe DTO para o tráfego dos dados das equipes na API.
 * 
 * @author Felipe Nascimento
 * 
 */

public class DadosEquipesDTO implements Comparator<DadosEquipesDTO>, Serializable {
	private static final long serialVersionUID = -3460568397695396537L;

	@NotBlank
	private String nomeEquipe;
	
	@NotBlank
	private String estadioEquipe;
	
	@NotBlank
	private String ligaEquipe;
	
	@NotBlank
	private String dataFundacaoEquipe;
	
	@NotBlank
	private String siglaEquipe;

	@NotBlank
	private String paisEquipe;
	
	@NotBlank
	private String escudoEquipe;
	
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
		
		DadosEquipesDTO dadosEquipesDTO = (DadosEquipesDTO) object;
		
		return Objects.equals(nomeEquipe, dadosEquipesDTO.nomeEquipe)
			&& Objects.equals(estadioEquipe, dadosEquipesDTO.estadioEquipe)
			&& Objects.equals(ligaEquipe, dadosEquipesDTO.ligaEquipe)
			&& Objects.equals(dataFundacaoEquipe, dadosEquipesDTO.dataFundacaoEquipe)
			&& Objects.equals(siglaEquipe, dadosEquipesDTO.siglaEquipe)
			&& Objects.equals(paisEquipe, dadosEquipesDTO.paisEquipe)
			&& Objects.equals(escudoEquipe, dadosEquipesDTO.escudoEquipe);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
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
			.append("Nome da Equipe: ").append(nomeEquipe)
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
	public int compare(DadosEquipesDTO dadosEquipesDTO1, DadosEquipesDTO dadosEquipesDTO2) {
		return dadosEquipesDTO1.getNomeEquipe().compareTo(dadosEquipesDTO2.getNomeEquipe());
	}
	
}