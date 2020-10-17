package web.travelHint.usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @SequenceGenerator(name = "usuario", sequenceName = "s_usuario", allocationSize = 1)
    private long id;

    private String token;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private Boolean emailConfirmado;

    private Boolean cadastroFinalizado;

    private Date dataNascimento;

    private String biografia;

    private String imagemUrl;

    private String genero;

}
