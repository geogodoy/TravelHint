package web.travelHint.residencia;

import lombok.Getter;
import lombok.Setter;
import web.travelHint.usuario.Usuario;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="RESIDENCIA")
public class Residencia {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "residencia")
    @SequenceGenerator(name = "residencia", sequenceName = "s_residencia", allocationSize = 1)
    private long id;

    @ManyToOne
    private Usuario usuario;

    private String codigoPostal;

    private String cidade;

    private String pais;

    private Date dataInicial;

    private Date dataFinal;

    private Boolean atual;

    private String observacao;
}
