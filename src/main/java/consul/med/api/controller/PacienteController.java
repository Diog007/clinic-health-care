package consul.med.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import consul.med.api.paciente.DadosAtualizacaoPaciente;
import consul.med.api.paciente.DadosCadastroPaciente;
import consul.med.api.paciente.DadosDetalhamentoPaciente;
import consul.med.api.paciente.DadosListagemPaciente;
import consul.med.api.paciente.Paciente;
import consul.med.api.paciente.PacienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrarPaciente (@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
		var medico = new Paciente(dados);
		repository.save(medico);
		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(medico));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemPaciente>> listaPaciente(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao ){
		var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente :: new);
		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizarPaciente (@RequestBody @Valid DadosAtualizacaoPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluirPaciente(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		paciente.excluir();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalharPaciente(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}	
}
