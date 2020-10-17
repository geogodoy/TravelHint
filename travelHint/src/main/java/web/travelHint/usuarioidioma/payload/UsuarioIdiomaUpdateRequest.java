package web.travelHint.usuarioidioma.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioIdiomaUpdateRequest {

    @NotBlank(message = "idioma deve ser informado")
    private String idiomaId;

    @NotBlank(message = "proficiência deve ser informada")
    private String proficienciaId;
}
