package consul.med.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.ConsultaRepository;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorDeMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{
	
	@Autowired
	private ConsultaRepository repository;

	public void validar(DadosAgendamentoConsulta dados) {
		var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
		if(medicoPossuiOutraConsultaNoMesmoHorario) {
			throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
		}
	}
}
