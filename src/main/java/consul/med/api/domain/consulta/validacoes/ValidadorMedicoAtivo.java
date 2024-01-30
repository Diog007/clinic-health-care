package consul.med.api.domain.consulta.validacoes;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.DadosAgendamentoConsulta;
import consul.med.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {
	
	private MedicoRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		if(dados.idMedico() == null) {
			return;
		}
		
		var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
		if(!medicoEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
		}
	}
}
