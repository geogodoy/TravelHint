package web.travelHint.token;

import io.jsonwebtoken.Claims;
import web.travelHint.usuario.Usuario;

public interface TokenService {

    String generateToken(Usuario usuario);

    Claims decodeToken(String tokenTratado);
}
