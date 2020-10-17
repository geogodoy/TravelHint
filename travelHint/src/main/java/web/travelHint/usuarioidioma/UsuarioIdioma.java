package web.travelHint.usuarioidioma;

import lombok.Getter;
import lombok.Setter;
import web.travelHint.usuario.Usuario;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="USUARIO_IDIOMA")
public class UsuarioIdioma {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioIdioma")
    @SequenceGenerator(name = "usuarioIdioma", sequenceName = "s_usuario_idioma", allocationSize = 1)
    private long id;

    @ManyToOne
    private Usuario usuario;

    private String idiomaId;

    private String proficienciaId;
}
