package consul.med.api.medico;

import consul.med.api.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    private Long id;
    private String nome;
    private String email;
    private String crm;

    private Especialidade especialidade;

    private Endereco endereco;
}
