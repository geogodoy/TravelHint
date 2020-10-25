package web.travelHint.chamadoidioma.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ChamadoIdiomaUpdateRequest {

    @NotBlank(message = "o idioma deve ser informado")
    private String  idiomaId ;
}
