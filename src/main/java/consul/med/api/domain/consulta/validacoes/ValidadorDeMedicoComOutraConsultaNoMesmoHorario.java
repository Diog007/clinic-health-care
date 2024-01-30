package consul.med.api.domain.consulta.validacoes;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.ConsultaRepository;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorDeMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{
	
	private ConsultaRepository repository;

	public void validar(DadosAgendamentoConsulta dados) {
		var medicoPossuiOutraConsultaNoMesmoHorario = repository.existByMedicoIdAndData(dados.idMedico(), dados.data());
		if(medicoPossuiOutraConsultaNoMesmoHorario) {
			throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
		}
	}
}
