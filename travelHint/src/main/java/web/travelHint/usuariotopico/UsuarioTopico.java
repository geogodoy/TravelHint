package web.travelHint.usuariotopico;

import lombok.Getter;
import lombok.Setter;
import web.travelHint.usuario.Usuario;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="USUARIO_TOPICO")
public class UsuarioTopico {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioTopico")
    @SequenceGenerator(name = "usuarioTopico", sequenceName = "s_usuario_topico", allocationSize = 1)
    private long id;

    @ManyToOne
    private Usuario usuario;

    private String topicoId;

    private String papelId;
}
