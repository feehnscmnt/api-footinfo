package br.com.apifootinfo.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.security.NoSuchAlgorithmException;
import static org.mockito.Mockito.doReturn;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import org.junit.jupiter.api.Test;
import io.jsonwebtoken.Jwts;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

/**
 * Classe test para implementação dos testes unitários dos métodos responsáveis pelo tratamento do token JWT.
 * 
 * @author Felipe Nascimento
 * 
 */

class JwtUtilsTest implements Serializable {
	private static final long serialVersionUID = 1216136930014496730L;
	
	/**
	 * Método responsável pelo teste unitário do método {@link JwtUtils#generateToken(String usuario)}.
	 */
	@Test
	void testGenerateToken() {
        doReturn(Constants.API_KEY_SECRET).when(JwtUtils.generateSecretKey());
        
        String token = JwtUtils.generateToken(Constants.getApiUserBase64());
        
        assertNotNull(token, "O token JWT não deve ser nulo.");
        assertTrue(token.startsWith("ey"), "O token JWT deve começar com 'ey'.");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link JwtUtils#validateTokenAndGetUsername(String token)}
	 * para quando o Token JWT for válido.
	 */
	@Test
    void testValidateTokenAndGetUsernameTokenValido() {
		doReturn(Constants.API_KEY_SECRET).when(JwtUtils.generateSecretKey());
		
		String result = JwtUtils.validateTokenAndGetUsername(Jwts.builder().setSubject(Constants.getApiUserBase64())
                .setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_API_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, JwtUtils.generateSecretKey()).compact());
		
		assertEquals(Constants.getApiUserBase64(), result, "O nome de usuário deve corresponder ao nome de usuário do token.");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link JwtUtils#validateTokenAndGetUsername(String token)}
	 * para quando o Token JWT for inválido.
	 */
	@Test
    void testValidateTokenAndGetUsernameTokenInalido() {
		doReturn(Constants.API_KEY_SECRET).when(JwtUtils.generateSecretKey());
		
		assertNull(JwtUtils.validateTokenAndGetUsername("tokenInvalido"), "O nome de usuário deve ser nulo para um token inválido.");
	}
	
	/**
	 * Método responsável pelo teste unitário do método {@link JwtUtils#generateSecretKey()}.
	 */
	@Test
    void testGenerateSecretKey() throws NoSuchAlgorithmException {
		byte[] key = MessageDigest.getInstance(Constants.ALGORITHM_SHA256).digest(Constants.API_KEY_SECRET.getBytes(StandardCharsets.UTF_8));
		String expectedKey = Base64.getEncoder().encodeToString(new SecretKeySpec(key, 0, key.length, Constants.ALGORITHM_AES).getEncoded());
		
		assertEquals(expectedKey, JwtUtils.generateSecretKey(), "A chave secreta gerada deve corresponder à chave esperada.");
	}
	
}