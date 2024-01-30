package consul.med.api.domain.consulta.validacoes;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;
import consul.med.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{
	
	private PacienteRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
		if(!pacienteEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
		}
	}
}
