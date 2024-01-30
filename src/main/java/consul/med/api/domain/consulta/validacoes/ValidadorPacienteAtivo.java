package consul.med.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;
import consul.med.api.domain.paciente.PacienteRepository;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{
	
	@Autowired
	private PacienteRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
		if(!pacienteEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
		}
	}
}
