package web.travelHint.residencia.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ResidenciaUpdateRequest {

    @NotNull(message = "id do usuário deve ser informado")
    private long usuarioId;

    private Date dataFinal;


}
