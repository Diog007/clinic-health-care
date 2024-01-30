package consul.med.api.domain.consulta.validacoes;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.ConsultaRepository;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{
	
	private ConsultaRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);
		var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
		if(pacientePossuiOutraConsultaNoDia) {
			throw new ValidacaoException("Paciente já possui uma consúlta agendada nesse dia");
		}
	}

}
