package web.travelHint.residencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResidenciaNotDeleteExcpetion extends RuntimeException {

    public ResidenciaNotDeleteExcpetion(long residenciaId, long usuarioId) {
        super(String.format("A residência '%d' não pode ser deletada pois é a atual para o usuário '%d'.", residenciaId, usuarioId));
    }

}
