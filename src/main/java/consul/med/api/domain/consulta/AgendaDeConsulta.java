package consul.med.api.domain.consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import consul.med.api.domain.ValidacaoException;
import consul.med.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
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
	
	@Autowired
	private List<ValidadorAgendamentoDeConsulta> validadores;

	public void agendar(DadosAgendamentoConsulta dados) {
		if (!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidacaoException("Id do paciente informado nao existe!");
		}
		if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidacaoException("Id do medico informado nao existe!");
		}
		
		validadores.forEach(v -> v.validar(dados));
		
		var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
		var medico = escolherMedico(dados);
		var consulta = new Consulta(null, medico, paciente, dados.data(), null, null);
		consultaRepository.save(consulta);
	}

	private Medico escolherMedico(DadosAgendamentoConsulta dados) {
		if (dados.idMedico() != null) {
			return medicoRepository.getReferenceById(dados.idMedico());
		}
		if (dados.especialidade() == null) {
			throw new ValidacaoException("Especialidade é obrigatoria quando o medico não for escolhida!");
		}
		return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
	}

	public Consulta cancelar(DadosCancelamentoConsulta dados) {
		if (!consultaRepository.existsById(dados.idConsulta())) {
			throw new ValidacaoException("Id da consulta informado não existe!");
		}
		var consulta = consultaRepository.getReferenceById(dados.idConsulta());
		LocalDateTime dataCancelamento = LocalDateTime.now();
		
		if(dataCancelamento.plusDays(1).isAfter(consulta.getData())) {
			throw new ValidacaoException("A consulta só pode ser cancelada com no minimo 24h de antecedencia");
		}
		consulta.setCancelada(true);
		consulta.setMotivoCancelamento(dados.motivo());
		return consulta;
		
	}

}
