package consul.med.api.domain.medico;

import consul.med.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco) {
}
