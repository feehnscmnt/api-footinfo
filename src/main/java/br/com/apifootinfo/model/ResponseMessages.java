package br.com.apifootinfo.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Classe model para tratamento das mensagens dos responses da API.
 * 
 * @author Felipe Nascimento
 *
 */

public class ResponseMessages implements Comparator<ResponseMessages>, Serializable {
	private static final long serialVersionUID = 5778320627659000257L;
	private int codigo;
	private String mensagem;
	
	/**
	 * Construtor da classe parametrizado.
	 * 
	 * @param codigo - int - código da mensagem
	 * @param mensagem - {@link String} - mensagem que será enviada ao usuário
	 * 
	 */
	public ResponseMessages(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	/**
	 * Retorna o atributo codigo.
	 * 
	 * @return o código da mensagem do tipo int.
	 * 
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Especifica o atributo codigo.
	 * .
	 * @param codigo int referente ao código da mensagem que será setado.
	 * 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna o atributo mensagem.
	 * 
	 * @return a mensagem da requisição do tipo {@link String}.
	 * 
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Especifica o atributo mensagem.
	 * .
	 * @param mensagem {@link String} referente à mensagem da requisição que será setada.
	 * 
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	/**
	 * Método comparador booleano.
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		
		if (object == null || getClass() != object.getClass()) return false;
		
		ResponseMessages responseMessages = (ResponseMessages) object;
		
		return Objects.equals(codigo, responseMessages.codigo)
			&& Objects.equals(mensagem, responseMessages.mensagem);
	}
	
	/**
	 * Método organizador dos atributos.
	 */
	@Override
    public int hashCode() {
		return Objects.hash(
			codigo,
			mensagem
		);
	}
	
	/**
	 * Método de representação textual da classe.
	 */
	@Override
	public String toString() {
		return String.valueOf(new StringBuilder()
			.append("Mensagem da Requisição: ").append(mensagem)
			.append(", Código da Requisição: ").append(codigo));
	}
	
	/**
	 * Método comparador inteiro.
	 */
	@Override
	public int compare(ResponseMessages responseMessages1, ResponseMessages responseMessages2) {
		return responseMessages1.getMensagem().compareTo(responseMessages2.getMensagem());
	}
	
}