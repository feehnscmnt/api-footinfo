package br.com.apifootinfo.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe DTO para o tráfego dos dados dos(as) atletas na FootInfo-API.
 * 
 * @author Felipe Nascimento
 * 
 */

public class DadosAtletasDTO implements Comparator<DadosAtletasDTO>, Serializable {
	private static final long serialVersionUID = -5126576104803365604L;
	
	@NotBlank
	private String nomeAtleta;
	
	@NotBlank
	private String dataNascimentoAtleta;
	
	@NotBlank
	private String nacionalidadeAtleta;
	
	@NotBlank
	private String equipeAtualAtleta;
	
	@NotBlank
	private String posicaoAtleta;
	
	@NotBlank
	private String alturaAtleta;
	
	@NotBlank
	private String categoriaAtleta;
	
	@NotBlank
	private String fotoAtleta;
	
	/**
	 * Retorna o atributo nomeAtleta.
	 * 
	 * @return o nome do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getNomeAtleta() {
		return nomeAtleta;
	}
	
	/**
	 * Especifica o atributo nomeAtleta.
	 * .
	 * @param nomeAtleta {@link String} referente ao nome do(a) atleta que será setado.
	 * 
	 */
	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}
	
	/**
	 * Retorna o atributo dataNascimentoAtleta.
	 * 
	 * @return a data de nascimento do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getDataNascimentoAtleta() {
		return dataNascimentoAtleta;
	}
	
	/**
	 * Especifica o atributo dataNascimentoAtleta.
	 * .
	 * @param dataNascimentoAtleta {@link String} referente à data de nascimento do(a) atleta que será setada.
	 * 
	 */
	public void setDataNascimentoAtleta(String dataNascimentoAtleta) {
		this.dataNascimentoAtleta = dataNascimentoAtleta;
	}
	
	/**
	 * Retorna o atributo nacionalidadeAtleta.
	 * 
	 * @return a nacionalidade do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getNacionalidadeAtleta() {
		return nacionalidadeAtleta;
	}
	
	/**
	 * Especifica o atributo nacionalidadeAtleta.
	 * .
	 * @param nacionalidadeAtleta {@link String} referente à nacionalidade do(a) atleta que será setada.
	 * 
	 */
	public void setNacionalidadeAtleta(String nacionalidadeAtleta) {
		this.nacionalidadeAtleta = nacionalidadeAtleta;
	}
	
	/**
	 * Retorna o atributo equipeAtualAtleta.
	 * 
	 * @return a equipe atual do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getEquipeAtualAtleta() {
		return equipeAtualAtleta;
	}
	
	/**
	 * Especifica o atributo equipeAtualAtleta.
	 * .
	 * @param equipeAtualAtleta {@link String} referente à equipe atual do(a) atleta que será setada.
	 * 
	 */
	public void setEquipeAtualAtleta(String equipeAtualAtleta) {
		this.equipeAtualAtleta = equipeAtualAtleta;
	}
	
	/**
	 * Retorna o atributo posicaoAtleta.
	 * 
	 * @return a posição do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getPosicaoAtleta() {
		return posicaoAtleta;
	}
	
	/**
	 * Especifica o atributo posicaoAtleta.
	 * .
	 * @param posicaoAtleta {@link String} referente à posição do(a) atleta que será setada.
	 * 
	 */
	public void setPosicaoAtleta(String posicaoAtleta) {
		this.posicaoAtleta = posicaoAtleta;
	}
	
	/**
	 * Retorna o atributo alturaAtleta.
	 * 
	 * @return a altura do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getAlturaAtleta() {
		return alturaAtleta;
	}
	
	/**
	 * Especifica o atributo alturaAtleta.
	 * .
	 * @param alturaAtleta {@link String} referente à altura do(a) atleta que será setada.
	 * 
	 */
	public void setAlturaAtleta(String alturaAtleta) {
		this.alturaAtleta = alturaAtleta;
	}
	
	/**
	 * Retorna o atributo categoriaAtleta.
	 * 
	 * @return a categoria do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getCategoriaAtleta() {
		return categoriaAtleta;
	}
	
	/**
	 * Especifica o atributo categoriaAtleta.
	 * .
	 * @param categoriaAtleta {@link String} referente à categoria do(a) atleta que será setada.
	 * 
	 */
	public void setCategoriaAtleta(String categoriaAtleta) {
		this.categoriaAtleta = categoriaAtleta;
	}
	
	/**
	 * Retorna o atributo fotoAtleta.
	 * 
	 * @return a foto do(a) atleta do tipo {@link String}.
	 * 
	 */
	public String getFotoAtleta() {
		return fotoAtleta;
	}
	
	/**
	 * Especifica o atributo fotoAtleta.
	 * .
	 * @param fotoAtleta {@link String} referente à foto do(a) atleta que será setada.
	 * 
	 */
	public void setFotoAtleta(String fotoAtleta) {
		this.fotoAtleta = fotoAtleta;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		DadosAtletasDTO dadosAtletasDTO = (DadosAtletasDTO) object;
		
		return Objects.equals(nomeAtleta, dadosAtletasDTO.nomeAtleta)
			&& Objects.equals(dataNascimentoAtleta, dadosAtletasDTO.dataNascimentoAtleta)
			&& Objects.equals(nacionalidadeAtleta, dadosAtletasDTO.nacionalidadeAtleta)
			&& Objects.equals(equipeAtualAtleta, dadosAtletasDTO.equipeAtualAtleta)
			&& Objects.equals(posicaoAtleta, dadosAtletasDTO.posicaoAtleta)
			&& Objects.equals(alturaAtleta, dadosAtletasDTO.alturaAtleta)
			&& Objects.equals(categoriaAtleta, dadosAtletasDTO.categoriaAtleta)
			&& Objects.equals(fotoAtleta, dadosAtletasDTO.fotoAtleta);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			nomeAtleta,
			dataNascimentoAtleta,
			nacionalidadeAtleta,
			equipeAtualAtleta,
			posicaoAtleta,
			alturaAtleta,
			categoriaAtleta,
			fotoAtleta
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Nome do(a) Atleta: ").append(nomeAtleta)
			.append(", Data de Nascimento do(a) Atleta: ").append(dataNascimentoAtleta)
			.append(", Nacionalidade do(a) Atleta: ").append(nacionalidadeAtleta)
			.append(", Equipe Atual do(a) Atleta: ").append(equipeAtualAtleta)
			.append(", Posição do(a) Atleta: ").append(posicaoAtleta)
			.append(", Altura do(a) Atleta: ").append(alturaAtleta)
			.append(", Categoria do(a) Atleta: ").append(categoriaAtleta)
			.append(", Foto do(a) Atleta: ").append(fotoAtleta));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(DadosAtletasDTO dadosAtletasDTO1, DadosAtletasDTO dadosAtletasDTO2) {
		return dadosAtletasDTO1.getNomeAtleta().compareTo(dadosAtletasDTO2.getNomeAtleta());
	}
	
}