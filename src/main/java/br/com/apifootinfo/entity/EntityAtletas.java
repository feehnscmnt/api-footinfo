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
 * Classe entity responsável por gerar o tabela de atletas no banco de dados.
 * 
 * @author Felipe Nascimento
 * 
 */

@Entity
@Table(name = Constants.ATHLETES_TABLE_NAME)
public class EntityAtletas implements Comparator<EntityAtletas>, Serializable {
	private static final long serialVersionUID = -6925755412126511312L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idAtleta;
	
	@Column(nullable = false, length = 100)
	private String nomeAtleta;
	
	@Column(nullable = false, length = 11)
	private String dataNascimentoAtleta;
	
	@Column(nullable = false, length = 25)
	private String nacionalidadeAtleta;
	
	@Column(nullable = false, length = 100)
	private String equipeAtualAtleta;
	
	@Column(nullable = false, length = 25)
	private String posicaoAtleta;
	
	@Column(nullable = false, length = 4)
	private String alturaAtleta;
	
	@Column(nullable = false, length = 11)
	private String categoriaAtleta;
	
	@Column(nullable = false, length = 250)
	private String fotoAtleta;
	
	/**
	 * Retorna o atributo idAtleta.
	 * 
	 * @return o id do(a) atleta do tipo {@link UUID}.
	 * 
	 */
	public UUID getIdAtleta() {
		return idAtleta;
	}
	
	/**
	 * Especifica o atributo idAtleta.
	 * .
	 * @param idAtleta {@link UUID} referente ao id do(a) atleta que será setado.
	 * 
	 */
	public void setIdAtleta(UUID idAtleta) {
		this.idAtleta = idAtleta;
	}
	
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
		
		EntityAtletas entityAtletas = (EntityAtletas) object;
		
		return Objects.equals(idAtleta, entityAtletas.idAtleta)
			&& Objects.equals(nomeAtleta, entityAtletas.nomeAtleta)
			&& Objects.equals(dataNascimentoAtleta, entityAtletas.dataNascimentoAtleta)
			&& Objects.equals(nacionalidadeAtleta, entityAtletas.nacionalidadeAtleta)
			&& Objects.equals(equipeAtualAtleta, entityAtletas.equipeAtualAtleta)
			&& Objects.equals(posicaoAtleta, entityAtletas.posicaoAtleta)
			&& Objects.equals(alturaAtleta, entityAtletas.alturaAtleta)
			&& Objects.equals(categoriaAtleta, entityAtletas.categoriaAtleta)
			&& Objects.equals(fotoAtleta, entityAtletas.fotoAtleta);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			idAtleta,
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
			.append("Id do(a) Atleta: ").append(idAtleta)
			.append(", Nome do(a) Atleta: ").append(nomeAtleta)
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
	public int compare(EntityAtletas entityAtleta1, EntityAtletas entityAtletas2) {
		return entityAtleta1.getNomeAtleta().compareTo(entityAtletas2.getNomeAtleta());
	}
	
}