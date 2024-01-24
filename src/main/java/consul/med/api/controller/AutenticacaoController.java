package consul.med.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consul.med.api.domain.usuario.DadosAutenticacao;
import consul.med.api.domain.usuario.Usuario;
import consul.med.api.infra.security.DadosTokenJWT;
import consul.med.api.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}

}
