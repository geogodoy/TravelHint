package web.travelHint.residencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResidenciaRepository extends JpaRepository<Residencia, Long>, JpaSpecificationExecutor<Residencia> {

    Residencia findById(long id);

    Residencia findByUsuarioIdAndAtual(long usuarioId, Boolean atual);

    Residencia findByIdAndAtual(long id, Boolean atual);
}
