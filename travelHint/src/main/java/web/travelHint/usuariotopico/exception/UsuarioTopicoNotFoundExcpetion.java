package web.travelHint.usuariotopico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioTopicoNotFoundExcpetion extends RuntimeException {

    public UsuarioTopicoNotFoundExcpetion(long usuarioTopicoId) {
        super(String.format("O usuário tópico '%d' não foi encontrado", usuarioTopicoId));
    }

}
