package web.travelHint.chamadoidioma.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ChamadoIdiomaCreateRequest {

    @NotNull(message = "id do chamado deve ser informado")
    private long chamadoId;

    @NotBlank(message = "o idioma deve ser informado")
    private String  idiomaId ;
}
