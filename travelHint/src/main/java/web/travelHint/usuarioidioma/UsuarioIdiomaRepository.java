package web.travelHint.usuarioidioma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuarioIdiomaRepository extends JpaRepository<UsuarioIdioma, Long>, JpaSpecificationExecutor<UsuarioIdioma> {

    UsuarioIdioma findById(long id);

    UsuarioIdioma findByUsuarioId(long usuarioId);

    UsuarioIdioma findByIdiomaIdAndProficienciaIdAndUsuarioId(String idiomaId, String proficienciaId, long usuarioId);

    UsuarioIdioma findByIdiomaIdAndUsuarioId(String idiomaId, long usuarioId);
}
