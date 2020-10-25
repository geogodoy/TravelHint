package web.travelHint.matching.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MatchingRequest {

    private long chamadoId;
    private long  residenteId ;
    private long  viajanteId ;
    private String  topicoId ;
    private String  cidade ;
}
