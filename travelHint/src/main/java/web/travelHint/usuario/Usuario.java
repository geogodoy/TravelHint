package web.travelHint.usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import web.travelHint.residencia.Residencia;
import web.travelHint.usuarioidioma.UsuarioIdioma;
import web.travelHint.usuariotopico.UsuarioTopico;

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

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioIdioma> usuariosIdiomas;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioTopico> usuariosTopicos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Residencia> residencias;

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
