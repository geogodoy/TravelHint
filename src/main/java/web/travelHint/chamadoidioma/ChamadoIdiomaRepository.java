package web.travelHint.chamadoidioma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import web.travelHint.chamado.Chamado;
import web.travelHint.usuarioidioma.UsuarioIdioma;

public interface ChamadoIdiomaRepository extends JpaRepository<ChamadoIdioma, Long>, JpaSpecificationExecutor<ChamadoIdioma> {

    ChamadoIdioma findById(long id);

    ChamadoIdioma findByIdiomaId(String idiomaId);

}
