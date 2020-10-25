package web.travelHint.usuariotopico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import web.travelHint.usuarioidioma.UsuarioIdioma;

public interface UsuarioTopicoRepository extends JpaRepository<UsuarioTopico, Long>, JpaSpecificationExecutor<UsuarioTopico> {

    UsuarioTopico findById(long id);

    UsuarioTopico findByTopicoIdAndPapelIdAndUsuarioId(String topicoId, String papelId, long usuarioId);

}
