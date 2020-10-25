package web.travelHint.usuario.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UsuarioLogin {

    @NotBlank(message = "e-mail deve ser informado")
    @Email(message = "e-mail deve possuir um formato válido")
    @Size(min = 5, max = 100, message = "e-mail deve ter entre {min} e {max} caracteres")
    private String email;

    @NotBlank(message = "senha deve ser informada")
    @Size(min = 8, max = 8, message = "senha deve ter {max} caracteres")
    private String senha;

}
