package web.travelHint.usuarioidioma.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioIdiomaUpdateRequest {

    @NotBlank(message = "proficiência deve ser informada")
    private String proficienciaId;
}
