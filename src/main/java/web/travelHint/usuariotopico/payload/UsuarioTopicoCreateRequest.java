package web.travelHint.usuariotopico.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioTopicoCreateRequest {

    @NotNull(message = "id do usuário deve ser informado")
    private long usuarioId;

    @NotBlank(message = "tópico deve ser informado")
    private String topicoId;

    @NotBlank(message = "papel deve ser informado")
    private String papelId;
}
