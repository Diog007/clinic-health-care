package consul.med.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consul.med.api.paciente.DadosCadastroPaciente;
import consul.med.api.paciente.Paciente;
import consul.med.api.paciente.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	public void cadastrarPaciente (@RequestBody DadosCadastroPaciente dados) {
		repository.save(new Paciente(dados));
		
		
	}
}
