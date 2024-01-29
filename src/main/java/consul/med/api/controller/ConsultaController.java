package consul.med.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consul.med.api.domain.consulta.AgendaDeConsulta;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;
import consul.med.api.domain.consulta.DadosCancelamentoConsulta;
import consul.med.api.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

	@Autowired
	private AgendaDeConsulta agenda;

	@PostMapping
	@Transactional
	public ResponseEntity agendarConsulta(@RequestBody @Valid DadosAgendamentoConsulta dados) {
		agenda.agendar(dados);
		return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
	}

	@DeleteMapping
	@Transactional
	public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados) {
		agenda.cancelar(dados);
		return ResponseEntity.noContent().build();
	}
}
