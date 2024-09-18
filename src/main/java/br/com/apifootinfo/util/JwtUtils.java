package br.com.apifootinfo.util;

import java.security.NoSuchAlgorithmException;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import io.jsonwebtoken.JwtException;
import java.security.MessageDigest;
import io.jsonwebtoken.Jwts;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

/**
 * Classe responsável pelo tratamento do token JWT.
 * 
 * @author Felipe Nascimento
 * 
 */

public class JwtUtils implements Serializable {
	private static final long serialVersionUID = -531843526886721468L;
    
    /**
     * Método responsável pela geração do Token JWT.
     * 
     * @param usuario - usuário da API-FootInfo
     * 
     * @return Token JWT gerado
     * 
     */
    public static String generateToken(String usuario) {
        return Jwts.builder().setSubject(usuario).setExpiration(new Date(System.currentTimeMillis()
        	+ Constants.TOKEN_API_EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS256, generateSecretKey()).compact();
    }
    
    /**
     * Método responsável pela validação do Token JWT.
     * 
     * @param token - Token JWT
     * 
     * @return Token JWT validado
     * 
     */
    public static String validateTokenAndGetUsername(String token) {
        try {
        	return Jwts.parser()
                .setSigningKey(generateSecretKey())
                .parseClaimsJws(token)
                .getBody().getSubject();
        } catch(JwtException | IllegalArgumentException e) {
            return null;
        }
    }
    
    /**
     * Método responsável pela geração do secret key.
     * 
     * @return secret key
     * 
     */
    public static String generateSecretKey() {
    	try {
    		byte[] key = MessageDigest.getInstance(Constants.ALGORITHM_SHA256).digest(Constants.API_KEY_SECRET.getBytes(StandardCharsets.UTF_8));
        	return Base64.getEncoder().encodeToString(new SecretKeySpec(key, 0, key.length, Constants.ALGORITHM_AES).getEncoded());
    	} catch(NoSuchAlgorithmException e) {
    		return null;
    	}
    }
    
}