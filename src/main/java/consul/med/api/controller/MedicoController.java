package consul.med.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consul.med.api.medico.DadosCadastroMedico;
import consul.med.api.medico.Medico;
import consul.med.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;
	
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroMedico dados) {
		repository.save(new Medico(dados));
	}
	
}
