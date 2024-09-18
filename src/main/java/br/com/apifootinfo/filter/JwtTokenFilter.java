package br.com.apifootinfo.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import br.com.apifootinfo.util.JwtUtils;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import java.io.Serializable;
import java.io.IOException;

/**
 * Classe responsável pelo filtro de segurança da API-FootInfo.
 * 
 * @author Felipe Nascimento
 * 
 */

public class JwtTokenFilter extends OncePerRequestFilter implements Serializable {
	private static final long serialVersionUID = 6127823280264977630L;
	
	/**
	 * Método responsável pela extração e validação do token JWT informado no cabeçalho da requisição.
	 * 
	 * @param req - {@link HttpServletRequest} - usado para acessar e manipular a requisição HTTP
	 * @param resp - {@link HttpServletResponse} - usado para configurar e manipular a resposta HTTP
	 * @param filterChain - {@link FilterChain} - Usado para passar a requisição e a resposta para o próximo filtro na cadeia e garantir que o processamento continue até o fim
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
		String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
        	
            filterChain.doFilter(req, resp);
            return;
            
        }
        
        String username = JwtUtils.validateTokenAndGetUsername(header.replace("Bearer ", ""));

        if (username != null) {
        	
            SecurityContextHolder.getContext().setAuthentication(
            	new UsernamePasswordAuthenticationToken(username, null, null));
            
        }

        filterChain.doFilter(req, resp);
	}
	
}