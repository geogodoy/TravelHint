package web.travelHint.chamado.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ChamadoCreateRequest {

    @NotNull(message = "id do viajante deve ser informado")
    private long viajanteId;

    @NotBlank(message = "o tópico deve ser informado")
    private String  topicoId ;

    private double coordX;

    private double coordY;

    @NotBlank(message = "alcance deve ser informada")
    private Integer alcance;

    @NotBlank(message = "distância deve ser informada")
    private Integer distancia;

    private String  mensagem ;

}
