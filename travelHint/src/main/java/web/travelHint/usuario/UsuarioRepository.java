package web.travelHint.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    Usuario findById(long id);

    Usuario findByEmail(String email);

   @Query(value = "select  u.id "
            + "from Usuario u "
            +  "join u.usuariosIdiomas ui "
            +  "join u.usuariosTopicos ut "
            +  "join u.residencias r "
            + "where ui.idiomaId IN (SELECT ci.idiomaId from ChamadoIdioma ci join ci.chamado c "
            +                                       "where c.usuario.id = :usuario ) "
            + "and ut.topicoId  = :topicoId "
            + "and ut.papelId = 'RESIDENTE' and r.cidade = :cidade and  r.atual = 'true' "
            + "and u.id <> :usuario "
            + "group by u.id")
    long[] findUsuario(String topicoId, long usuario, String cidade);
}
