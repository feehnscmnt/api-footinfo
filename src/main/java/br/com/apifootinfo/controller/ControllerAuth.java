package br.com.apifootinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.apifootinfo.model.ResponseMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import br.com.apifootinfo.util.Constants;
import br.com.apifootinfo.util.JwtUtils;
import java.io.Serializable;

/**
 * Classe controller responsável pela autenticação da API-FootInfo.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_VERSION_API)
public class ControllerAuth implements Serializable {
	private static final long serialVersionUID = -8383373481822061254L;

	/**
	 * Método responsável pela autenticação de usuários na API-FootInfo.
	 * 
	 * @param usuario - {@link String} - usuário que será autenticado
	 * 
	 * @return token JWT para uso dos demais endpoints
	 * 
	 */
	@GetMapping(Constants.ENDPOINT_AUTH)
	public ResponseEntity<Object> auth(@RequestParam String usuario) {
		
		if (!usuario.equals(Constants.getApiUserBase64())) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new ResponseMessages(HttpStatus.UNAUTHORIZED.value(), "As credenciais de autenticação da API-FootInfo estão inválidas."));
	        
		}
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(new ResponseMessages(HttpStatus.CREATED.value(), JwtUtils.generateToken(usuario)));
		
	}
	
}