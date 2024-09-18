package br.com.apifootinfo.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe DTO para o tráfego dos dados das seleções na API.
 * 
 * @author Felipe Nascimento
 * 
 */

public class DadosSelecoesDTO implements Comparator<DadosSelecoesDTO>, Serializable {
	private static final long serialVersionUID = 7759915784796984270L;

	@NotBlank
	private String nomeSelecao;
	
	@NotBlank
	private String associacaoSelecao;
	
	@NotBlank
	private String confederacaoSelecao;
	
	@NotBlank
	private String treinadorSelecao;
	
	@NotBlank
	private String escudoSelecao;
	
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
		
		DadosSelecoesDTO dadosSelecoesDTO = (DadosSelecoesDTO) object;
		
		return Objects.equals(nomeSelecao, dadosSelecoesDTO.nomeSelecao)
			&& Objects.equals(associacaoSelecao, dadosSelecoesDTO.associacaoSelecao)
			&& Objects.equals(confederacaoSelecao, dadosSelecoesDTO.confederacaoSelecao)
			&& Objects.equals(treinadorSelecao, dadosSelecoesDTO.treinadorSelecao)
			&& Objects.equals(escudoSelecao, dadosSelecoesDTO.escudoSelecao);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
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
			.append("Nome da Seleção: ").append(nomeSelecao)
			.append(", Associação da Seleção: ").append(associacaoSelecao)
			.append(", Confederação da Seleção: ").append(confederacaoSelecao)
			.append(", Treinador da Seleção: ").append(treinadorSelecao)
			.append(", Escudo da Seleção: ").append(escudoSelecao));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(DadosSelecoesDTO dadosSelecoesDTO1, DadosSelecoesDTO dadosSelecoesDTO2) {
		return dadosSelecoesDTO1.getNomeSelecao().compareTo(dadosSelecoesDTO2.getNomeSelecao());
	}
	
}