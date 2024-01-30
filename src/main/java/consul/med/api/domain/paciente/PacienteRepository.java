package consul.med.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.validation.constraints.NotNull;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			select p.ativo
			from Paciente p
			where
			p.id = :id
			""")
	boolean findAtivoById(Long id);
}
