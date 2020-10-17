package web.travelHint.usuario.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UsuarioUpdateRequest {

    @NotBlank(message = "nome deve ser informado")
    @Size(min = 3, max = 200, message = "nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @NotBlank(message = "sobrenome deve ser informado")
    @Size(min = 3, max = 200, message = "sobrenome deve ter entre {min} e {max} caracteres")
    private String sobrenome;

    @NotBlank(message = "senha deve ser informada")
    @Size(min = 8, max = 8, message = "senha deve ter {max} caracteres")
    private String senha;

    @NotNull(message = "data de nascimento deve ser informada")
    private Date dataNascimento;

    private String biografia;
    private String imagemUrl;
    private String genero;

}
