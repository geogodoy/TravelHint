package web.travelHint.chamadoidioma;


import lombok.Getter;
import lombok.Setter;
import web.travelHint.chamado.Chamado;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="CHAMADO_IDIOMA")
public class ChamadoIdioma {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamadoIdioma")
    @SequenceGenerator(name = "chamadoIdioma", sequenceName = "s_chamado_idioma", allocationSize = 1)
    private long id;

    @ManyToOne
    private Chamado chamado;

    private String idiomaId;
}
