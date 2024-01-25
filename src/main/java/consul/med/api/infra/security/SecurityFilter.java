package consul.med.api.infra.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		var tokenJWT = recuperarToken(request);
		
		System.out.println(tokenJWT);
		
		filterChain.doFilter(request, response);
		
	}
	

	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader == null) {
			throw new RuntimeException("token JWT nao enviado no cabeçlho Authorization");
		}
		return authorizationHeader.replace("Bearer ", "");
	}

}
