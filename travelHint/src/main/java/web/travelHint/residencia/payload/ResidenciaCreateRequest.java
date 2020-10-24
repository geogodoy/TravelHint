package web.travelHint.residencia.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ResidenciaCreateRequest {

    @NotNull(message = "id do usuário deve ser informado")
    private long usuarioId;

    @NotBlank(message = "código postal deve ser informado")
    private String codigoPostal;

    @NotBlank(message = "cidade deve ser informada")
    private String cidade;

    @NotBlank(message = "país deve ser informado")
    private String pais;

    @NotNull(message = "data inicial deve ser informada")
    private Date dataInicial;

    private Date dataFinal;

    private String observacao;

}
