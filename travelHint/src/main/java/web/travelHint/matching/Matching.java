package web.travelHint.matching;

import lombok.Getter;
import lombok.Setter;
import web.travelHint.chamado.Chamado;
import web.travelHint.usuario.Usuario;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="MATCHING")
public class Matching {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamadoIdioma")
    @SequenceGenerator(name = "chamadoIdioma", sequenceName = "s_chamado_idioma", allocationSize = 1)
    private long id;

    @ManyToOne
    private Chamado chamado;

    @ManyToOne
    private Usuario residente;

    @ManyToOne
    private Usuario viajante;
}
