package consul.med.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consul.med.api.paciente.DadosCadastroPaciente;
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
	public void cadastrarPaciente (@RequestBody @Valid DadosCadastroPaciente dados) {
		repository.save(new Paciente(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPaciente> listaPaciente(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao ){
		return repository.findAll(paginacao).map(DadosListagemPaciente :: new);
	}
}
