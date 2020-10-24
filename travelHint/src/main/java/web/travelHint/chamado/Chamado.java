package web.travelHint.chamado;


import lombok.Getter;
import lombok.Setter;
import web.travelHint.alcance.Alcances;
import web.travelHint.usuario.Usuario;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="CHAMADO")
public class Chamado {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamado")
    @SequenceGenerator(name = "chamado", sequenceName = "s_chamado", allocationSize = 1)
    private long id;

    @ManyToOne
    private Usuario usuario;

    private String topicoId;

    private Integer latitude;

    private Integer longitude;

    private Integer alcance;

    private Integer distancia;

    private String mensagem;

    private Date dataCriacao;

    private Boolean ativo;
}
