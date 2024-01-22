package consul.med.api.medico;

import consul.med.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco) {
}
