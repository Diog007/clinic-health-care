package consul.med.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta = dados.data();
		
		var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
		var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
		if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
			throw new ValidacaoException("Consulta fora do horário de fucionamento da clínica");
		} 
	}
}
