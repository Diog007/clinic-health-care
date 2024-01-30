package consul.med.api.domain.consulta.validacoes;

import consul.med.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
	
	void validar(DadosAgendamentoConsulta dados);

}
