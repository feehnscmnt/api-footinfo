package br.com.apifootinfo.util;

import java.io.Serializable;
import java.util.Base64;

/**
 * Classe que contém as variáveis constantes de utilização.
 * 
 * @author Felipe Nascimento
 * 
 */

public class Constants implements Serializable {
	private static final long serialVersionUID = -7234776569050147875L;
	
	/**
	 * Pacote de classes anotadas com {@link @Component}.
	 */
	public static final String PACKAGE_COMPONENTS_IMPL = "br.com.apifootinfo.component.impl";
	
	/**
	 * Pacote de classes anotadas com {@link @Repository}.
	 */
	public static final String PACKAGE_REPOSITORIES = "br.com.apifootinfo.repository";
	
	/**
	 * Pacote de classes anotadas com {@link @RestController} e {@link @RequestMapping}.
	 */
	public static final String PACKAGE_CONTROLLERS = "br.com.apifootinfo.controller";
	
	/**
	 * Pacote da classe de segurnça da API-FootInfo anotada com {@link @Configuration}.
	 */
	public static final String PACKAGE_SECURITY = "br.com.apifootinfo.security";
	
	/**
	 * Pacote de classes anotadas com {@link @Entity}.
	 */
	public static final String PACKAGE_ENTITIES = "br.com.apifootinfo.entity";
	
	/**
	 * Endpoint para listagem de seleções.
	 */
	public static final String ENDPOINT_SELECTIONS_LIST_ALL = "/listar-todas";
	
	/**
	 * Endpoint para listagem de estádios.
	 */
	public static final String ENDPOINT_STADIUMS_LIST_ALL = "/listar-todos";
	
	/**
	 * Endpoint para listagem de atletas.
	 */
	public static final String ENDPOINT_ATHLETES_LIST_ALL = "/listar-todos";
	
	/**
	 * Endpoint para cadastro de seleções.
	 */
	public static final String ENDPOINT_SELECTIONS_REGISTER = "/cadastrar";
	
	/**
	 * Mapeamento de solicitação para seleções.
	 */
	public static final String REQUEST_MAPPING_SELECTIONS = "/v1/selecoes";
	
	/**
	 * Key Secret da API-FootInfo.
	 */
	public static final String API_KEY_SECRET = "api-footinfo-key-secret";
	
	/**
	 * Endpoint para listagem de equipes.
	 */
	public static final String ENDPOINT_TEAMS_LIST_ALL = "/listar-todas";
	
	/**
	 * Usuário de memória da API-FootInfo em Base64.
	 */
	public static final String BASE64_API_USERNAME = "QVBJLUZvb3RJbmZv";
	
	/**
	 * Senha do usuário de memória da API-FootInfo em Base64.
	 */
	public static final String BASE64_API_PASSWORD = "Rm9vdEluZm8tQVBJ";
	
	/**
	 * Tempo de expiração do Token JWT configurado para 5 minutos.
	 */
	public static final long TOKEN_API_EXPIRATION_TIME = 5 * 60 * 1000L;
	
	/**
	 * Endpoint para cadastro de atletas.
	 */
	public static final String ENDPOINT_ATHLETES_REGISTER = "/cadastrar";
	
	/**
	 * Mapeamento de solicitação para estádios.
	 */
	public static final String REQUEST_MAPPING_STADIUMS = "/v1/estadios";
	
	/**
	 * Endpoint para cadastro de estádios.
	 */
	public static final String ENDPOINT_STADIUMS_REGISTER = "/cadastrar";
	
	/**
	 * Mapeamento de solicitação para atletas.
	 */
	public static final String REQUEST_MAPPING_ATHLETES = "/v1/atletas";
	
	/**
	 * Endpoint para cadastro de equipes.
	 */
	public static final String ENDPOINT_TEAMS_REGISTER = "/cadastrar";
	
	/**
	 * Nome da tabela de seleções no banco de dados.
	 */
	public static final String SELECTIONS_TABLE_NAME = "TBL_SELECOES";
	
	/**
	 * Mapeamento de solicitação para equipes.
	 */
	public static final String REQUEST_MAPPING_TEAMS = "/v1/equipes";
	
	/**
	 * Usuário da API-FootInfo em Base64.
	 */
	private static final String API_USER_BASE64 = "QVBJLUZvb3RJbmZv";
	
	/**
	 * Nome da tabela de estádios no banco de dados.
	 */
	public static final String STADIUMS_TABLE_NAME = "TBL_ESTADIOS";
	
	/**
	 * Mapeamento de solicitação da versão da API-FootInfo.
	 */
	public static final String REQUEST_MAPPING_VERSION_API = "/v1";
	
	/**
	 * Nome da tabela de atletas no banco de dados.
	 */
	public static final String ATHLETES_TABLE_NAME = "TBL_ATLETAS";
	
	/**
	 * Nome da tabela de equipes no banco de dados.
	 */
	public static final String TEAMS_TABLE_NAME = "TBL_EQUIPES";
	
	/**
	 * ROLE da API-FootInfo em Base64.
	 */
	public static final String BASE64_API_ROLE = "VVNFUg==";
	
	/**
	 * Algoritmo SHA-256.
	 */
	public static final String ALGORITHM_SHA256 = "SHA-256";
	
	/**
	 * Endpoint auth.
	 */
	public static final String ENDPOINT_AUTH = "/auth";
	
	/**
	 * Algoritmo AES.
	 */
	public static final String ALGORITHM_AES = "AES";
	
	/**
	 * Getter do atributo API_USER_BASE64.
	 * 
	 * @return decode Base64 do usuário da API-FootInfo
	 * 
	 */
	public static String getApiUserBase64() {
		return new String(Base64.getDecoder().decode(API_USER_BASE64));
	}
	
}