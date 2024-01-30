package consul.med.api.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorHorarioAntecedencia {
	
	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta = dados.data();
		var agora = LocalDateTime.now();
		var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
		
		if(diferencaEmMinutos < 30) {
			throw new ValidacaoException("Consulta deve ser agendada com atecedência mínima de 30 minutos");
		}
	}
}
