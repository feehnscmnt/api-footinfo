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
 * Classe entity responsável por gerar o tabela de estádios no banco de dados.
 * 
 * @author Felipe Nascimento
 * 
 */

@Entity
@Table(name = Constants.STADIUMS_TABLE_NAME)
public class EntityEstadios implements Comparator<EntityEstadios>, Serializable {
	private static final long serialVersionUID = -586605760546965900L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idEstadio;
	
	@Column(nullable = false, length = 100)
	private String nomeEstadio;
	
	@Column(nullable = false, length = 11)
	private String dataConstrucaoEstadio;
	
	@Column(nullable = false, length = 11)
	private String dataInaugEstadio;
	
	@Column(nullable = false, length = 25)
	private String capacidadeEstadio;
	
	@Column(nullable = false, length = 20)
	private String recordePublicoEstadio;
	
	@Column(nullable = false, length = 100)
	private String localizacaoEstadio;
	
	@Column(nullable = false, length = 250)
	private String fotoEstadio;
	
	/**
	 * Retorna o atributo idEstadio.
	 * 
	 * @return o id do estádio do tipo {@link UUID}.
	 * 
	 */
	public UUID getIdEstadio() {
		return idEstadio;
	}
	
	/**
	 * Especifica o atributo idEstadio.
	 * .
	 * @param idEstadio {@link UUID} referente ao id do estádio que será setado.
	 * 
	 */
	public void setIdEstadio(UUID idEstadio) {
		this.idEstadio = idEstadio;
	}
	
	/**
	 * Retorna o atributo nomeEstadio.
	 * 
	 * @return o nome do estádio do tipo {@link String}.
	 * 
	 */
	public String getNomeEstadio() {
		return nomeEstadio;
	}
	
	/**
	 * Especifica o atributo nomeEstadio.
	 * .
	 * @param nomeEstadio {@link String} referente ao nome do estádio que será setado.
	 * 
	 */
	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}
	
	/**
	 * Retorna o atributo dataConstrucaoEstadio.
	 * 
	 * @return a data de construção do estádio do tipo {@link String}.
	 * 
	 */
	public String getDataConstrucaoEstadio() {
		return dataConstrucaoEstadio;
	}
	
	/**
	 * Especifica o atributo dataConstrucaoEstadio.
	 * .
	 * @param dataConstrucaoEstadio {@link String} referente à data de construção do estádio que será setada.
	 * 
	 */
	public void setDataConstrucaoEstadio(String dataConstrucaoEstadio) {
		this.dataConstrucaoEstadio = dataConstrucaoEstadio;
	}
	
	/**
	 * Retorna o atributo dataInaugEstadio.
	 * 
	 * @return a data de inauguração do estádio do tipo {@link String}.
	 * 
	 */
	public String getDataInaugEstadio() {
		return dataInaugEstadio;
	}
	
	/**
	 * Especifica o atributo dataConstrucaoEstadio.
	 * .
	 * @param dataInaugEstadio {@link String} referente à data de inauguração do estádio que será setada.
	 * 
	 */
	public void setDataInaugEstadio(String dataInaugEstadio) {
		this.dataInaugEstadio = dataInaugEstadio;
	}
	
	/**
	 * Retorna o atributo capacidadeEstadio.
	 * 
	 * @return a capacidade de público do estádio do tipo {@link String}.
	 * 
	 */
	public String getCapacidadeEstadio() {
		return capacidadeEstadio;
	}
	
	/**
	 * Especifica o atributo capacidadeEstadio.
	 * .
	 * @param capacidadeEstadio {@link String} referente à capacidade de público do estádio que será setada.
	 * 
	 */
	public void setCapacidadeEstadio(String capacidadeEstadio) {
		this.capacidadeEstadio = capacidadeEstadio;
	}
	
	/**
	 * Retorna o atributo recordePublicoEstadio.
	 * 
	 * @return o recorde de público do estádio do tipo {@link String}.
	 * 
	 */
	public String getRecordePublicoEstadio() {
		return recordePublicoEstadio;
	}
	
	/**
	 * Especifica o atributo recordePublicoEstadio.
	 * .
	 * @param recordePublicoEstadio {@link String} referente ao recorde de público do estádio que será setado.
	 * 
	 */
	public void setRecordePublicoEstadio(String recordePublicoEstadio) {
		this.recordePublicoEstadio = recordePublicoEstadio;
	}
	
	/**
	 * Retorna o atributo localizacaoEstadio.
	 * 
	 * @return a localização do estádio do tipo {@link String}.
	 * 
	 */
	public String getLocalizacaoEstadio() {
		return localizacaoEstadio;
	}
	
	/**
	 * Especifica o atributo localizacaoEstadio.
	 * .
	 * @param localizacaoEstadio {@link String} referente à localização do estádio que será setada.
	 * 
	 */
	public void setLocalizacaoEstadio(String localizacaoEstadio) {
		this.localizacaoEstadio = localizacaoEstadio;
	}
	
	/**
	 * Retorna o atributo fotoEstadio.
	 * 
	 * @return a foto do estádio do tipo {@link String}.
	 * 
	 */
	public String getFotoEstadio() {
		return fotoEstadio;
	}
	
	/**
	 * Especifica o atributo fotoEstadio.
	 * .
	 * @param fotoEstadio {@link String} referente à foto do estádio que será setada.
	 * 
	 */
	public void setFotoEstadio(String fotoEstadio) {
		this.fotoEstadio = fotoEstadio;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		EntityEstadios entityEstadios = (EntityEstadios) object;
		
		return Objects.equals(idEstadio, entityEstadios.idEstadio)
			&& Objects.equals(nomeEstadio, entityEstadios.nomeEstadio)
			&& Objects.equals(dataConstrucaoEstadio, entityEstadios.dataConstrucaoEstadio)
			&& Objects.equals(dataInaugEstadio, entityEstadios.dataInaugEstadio)
			&& Objects.equals(capacidadeEstadio, entityEstadios.capacidadeEstadio)
			&& Objects.equals(recordePublicoEstadio, entityEstadios.recordePublicoEstadio)
			&& Objects.equals(localizacaoEstadio, entityEstadios.localizacaoEstadio)
			&& Objects.equals(fotoEstadio, entityEstadios.fotoEstadio);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			idEstadio,
			nomeEstadio,
			dataConstrucaoEstadio,
			dataInaugEstadio,
			capacidadeEstadio,
			recordePublicoEstadio,
			localizacaoEstadio,
			fotoEstadio
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Id da Estádio: ").append(idEstadio)
			.append(", Nome da Estádio: ").append(nomeEstadio)
			.append(", Data de Construção do Estádio: ").append(dataConstrucaoEstadio)
			.append(", Data de Inauguração do Estádio: ").append(dataInaugEstadio)
			.append(", Capacidade do Estádio: ").append(capacidadeEstadio)
			.append(", Recorde de Público do Estádio: ").append(recordePublicoEstadio)
			.append(", Localização do Estádio: ").append(localizacaoEstadio)
			.append(", Foto do Estádio: ").append(fotoEstadio));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(EntityEstadios entityEstadios1, EntityEstadios entityEstadios2) {
		return entityEstadios1.getNomeEstadio().compareTo(entityEstadios2.getNomeEstadio());
	}
	
}