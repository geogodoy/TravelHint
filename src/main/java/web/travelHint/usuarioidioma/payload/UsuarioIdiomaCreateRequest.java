package web.travelHint.usuarioidioma.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UsuarioIdiomaCreateRequest {

    @NotNull(message = "id do usuário deve ser informado")
    private long usuarioId;

    @NotBlank(message = "idioma deve ser informado")
    private String idiomaId;

    @NotBlank(message = "proficiência deve ser informada")
    private String proficienciaId;
}
