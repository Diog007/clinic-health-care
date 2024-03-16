package consul.med.api.service;

import consul.med.api.domain.endereco.DadosEndereco;
import consul.med.api.domain.endereco.Endereco;
import consul.med.api.domain.medico.Especialidade;
import consul.med.api.domain.medico.Medico;
import consul.med.api.domain.medico.MedicoRepository;
import consul.med.api.domain.paciente.Paciente;
import consul.med.api.domain.paciente.PacienteRepository;
import consul.med.api.domain.usuario.Usuario;
import consul.med.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String login = "test@test.com";
        String senha = "123";
        String senhaCriptografada = passwordEncoder.encode(senha);

        Usuario usuario = new Usuario(null, login, senhaCriptografada);
        usuarioRepository.save(usuario);

        DadosEndereco endMed1 = new DadosEndereco("Avenida Paulista", "Bela Vista", "01311300", "São Paulo", "SP", "Complemento 1", "15");
        Endereco enderecoMed1 = new Endereco(endMed1);

        DadosEndereco endMed2 = new DadosEndereco("Rua Augusta", "Consolação", "01304900", "São Paulo", "SP", "Complemento 2", "545");
        Endereco enderecoMed2 = new Endereco(endMed2);

        DadosEndereco endMed3 = new DadosEndereco("Rua Oscar Freire", "Jardins", "01426000", "São Paulo", "SP", "Complemento 3", "85");
        Endereco enderecoMed3 = new Endereco(endMed3);

        DadosEndereco endMed4 = new DadosEndereco("Avenida Brigadeiro Faria Lima", "Itaim Bibi", "01452000", "São Paulo", "SP", "Complemento 4", "17");
        Endereco enderecoMed4 = new Endereco(endMed4);

        DadosEndereco endMed5 = new DadosEndereco("Rua Haddock Lobo", "Cerqueira César", "01414000", "São Paulo", "SP", "Complemento 5", "1005");
        Endereco enderecoMed5 = new Endereco(endMed5);

        DadosEndereco endPac1 = new DadosEndereco("Rua da Consolação", "Consolação", "01301000", "São Paulo", "SP", "Complemento 6", "4854");
        Endereco enderecoPac1 = new Endereco(endPac1);

        DadosEndereco endPac2 = new DadosEndereco("Rua Maria Antônia", "Vila Buarque", "01222000", "São Paulo", "SP", "Complemento 7", "963");
        Endereco enderecoPac2 = new Endereco(endPac2);

        DadosEndereco endPac3 = new DadosEndereco("Rua Treze de Maio", "Bela Vista", "01327000", "São Paulo", "SP", "Complemento 8", "65");
        Endereco enderecoPac3 = new Endereco(endPac3);

        DadosEndereco endPac4 = new DadosEndereco("Rua dos Pinheiros", "Pinheiros", "05422000", "São Paulo", "SP", "Complemento 9", "369");
        Endereco enderecoPac4 = new Endereco(endPac4);

        DadosEndereco endPac5 = new DadosEndereco("Rua Harmonia", "Vila Madalena", "05435000", "São Paulo", "SP", "Complemento 10", "708");
        Endereco enderecoPac5 = new Endereco(endPac5);

        Medico med1 = new Medico(null, "Carolina Sousa", "carolina.sousa.medi.pro", "96884/SP", "11988084444", Especialidade.CARDIOLOGIA, enderecoMed1, true);
        Medico med2 = new Medico(null, "José Antonio", "jose.antonio.medi.pro", "58745/SP", "11999685522", Especialidade.CARDIOLOGIA, enderecoMed2, true);
        Medico med3 = new Medico(null, "Sofia Pereira", "sofia.pereira.medi.pro", "85415/SP", "11986682233", Especialidade.GINECOLOGIA, enderecoMed3, true);
        Medico med4 = new Medico(null, "Isabel Tavares", "isabel.tavares.medi.pro", "58455/SP", "11988884444", Especialidade.ORTOPEDIA, enderecoMed4, true);
        Medico med5 = new Medico(null, "Miguel Ferreira", "miguel.ferreira.medi.pro", "45874/SP", "119899884444", Especialidade.ORTOPEDIA, enderecoMed5, true);
        List<Medico> medicos = Arrays.asList(med1, med2, med3, med4, med5);
        List<Medico> saveMedicos = medicoRepository.saveAll(medicos);

        Paciente pac1 = new Paciente(null, "Tiago Martins", "tiago.martins@mail.com", "11900112233", "40653707010", enderecoPac1, true);
        Paciente pac2 = new Paciente(null, "Lucca Yuri Caio Novaes", "lucas.caio@mail.com", "17985312839", "84665105839", enderecoPac2, true);
        Paciente pac3 = new Paciente(null, "Victor Calebe Duarte", "victor.calebe@mail.com", "19998385253", "11934040886", enderecoPac3, true);
        Paciente pac4 = new Paciente(null, "Martin Edson Rodrigo Assunção", "martin.edson@mail.com", "1128273386", "31514579839", enderecoPac4, true);
        Paciente pac5 = new Paciente(null, "Ryan Carlos Paulo Melo", "ryan.carlos.melo@mail.com", "11982037015", "90441588808", enderecoPac5, true);
        List<Paciente> pacientes = Arrays.asList(pac1, pac2, pac3, pac4, pac5);
        List<Paciente> salvarPacientes = pacienteRepository.saveAll(pacientes);

    }
}
