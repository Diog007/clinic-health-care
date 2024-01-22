package consul.med.api.domain.paciente;

import consul.med.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco) {
}
