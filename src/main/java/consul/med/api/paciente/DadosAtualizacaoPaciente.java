package consul.med.api.paciente;

import consul.med.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco) {
}
