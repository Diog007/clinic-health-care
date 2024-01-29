package consul.med.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.medico.Medico;
import consul.med.api.domain.medico.MedicoRepository;
import consul.med.api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsulta {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	public void agendar(DadosAgendamentoConsulta dados) {
		if (!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidacaoException("Id do paciente informado nao existe!");
		}
		
		if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidacaoException("Id do medico informado nao existe!");
		}
		
		
		var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
		var medico = escolherMedico(dados);
		var consulta = new Consulta(null, medico, paciente, dados.data());
		consultaRepository.save(consulta);
	}
	
	private Medico escolherMedico(DadosAgendamentoConsulta dados) {
		if(dados.idMedico() != null) {
			return medicoRepository.getReferenceById(dados.idMedico());
		}
		
		if(dados.especialidade() == null) {
			throw new ValidacaoException("Especialidade é obrigatoria quando o medico não for escolhida!");
		}
		
		return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
		
	}
	
}
