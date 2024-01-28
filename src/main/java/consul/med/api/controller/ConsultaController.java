package consul.med.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consul.med.api.domain.consulta.DadosAgendamentoConsulta;
import consul.med.api.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

	@PostMapping
	@Transactional
	public ResponseEntity agendarConsulta(@RequestBody @Valid DadosAgendamentoConsulta dados) {
		System.out.println(dados);
		return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
	}
}
