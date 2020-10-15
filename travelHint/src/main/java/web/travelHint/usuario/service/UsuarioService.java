package web.travelHint.usuario.service;

import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.payload.UsuarioLogin;
import web.travelHint.usuario.payload.UsuarioRequest;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listUsuarios();

    Usuario findUsuario(long id);

    Usuario findUsuarioToken(long id);

    Usuario createUsuario(UsuarioRequest usuarioRequest);

    void deleteUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    Usuario authenticate(UsuarioLogin usuarioLogin, String toen);

    Usuario findByEmail(String email);
}
