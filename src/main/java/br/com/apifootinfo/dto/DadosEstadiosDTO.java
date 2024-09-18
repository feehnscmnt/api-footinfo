package br.com.apifootinfo.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe DTO para o tráfego dos dados dos estádios na API.
 * 
 * @author Felipe Nascimento
 * 
 */

public class DadosEstadiosDTO implements Comparator<DadosEstadiosDTO>, Serializable {
	private static final long serialVersionUID = 3670606435641476774L;
	
	@NotBlank
	private String nomeEstadio;
	
	@NotBlank
	private String dataConstrucaoEstadio;
	
	@NotBlank
	private String dataInaugEstadio;
	
	@NotBlank
	private String capacidadeEstadio;
	
	@NotBlank
	private String recordePublicoEstadio;
	
	@NotBlank
	private String localizacaoEstadio;
	
	@NotBlank
	private String fotoEstadio;
	
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
		
		DadosEstadiosDTO dadosEstadiosDTO = (DadosEstadiosDTO) object;
		
		return Objects.equals(nomeEstadio, dadosEstadiosDTO.nomeEstadio)
			&& Objects.equals(dataConstrucaoEstadio, dadosEstadiosDTO.dataConstrucaoEstadio)
			&& Objects.equals(dataInaugEstadio, dadosEstadiosDTO.dataInaugEstadio)
			&& Objects.equals(capacidadeEstadio, dadosEstadiosDTO.capacidadeEstadio)
			&& Objects.equals(recordePublicoEstadio, dadosEstadiosDTO.recordePublicoEstadio)
			&& Objects.equals(localizacaoEstadio, dadosEstadiosDTO.localizacaoEstadio)
			&& Objects.equals(fotoEstadio, dadosEstadiosDTO.fotoEstadio);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
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
			.append("Nome da Estádio: ").append(nomeEstadio)
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
	public int compare(DadosEstadiosDTO dadosEstadiosDTO1, DadosEstadiosDTO dadosEstadiosDTO2) {
		return dadosEstadiosDTO1.getNomeEstadio().compareTo(dadosEstadiosDTO2.getNomeEstadio());
	}
	
}