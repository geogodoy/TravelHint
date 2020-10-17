package web.travelHint.usuario.service;

import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.payload.UsuarioLogin;
import web.travelHint.usuario.payload.UsuarioCreateRequest;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listUsuarios();

    Usuario findUsuario(long id);

    Usuario findUsuarioToken(long id);

    Usuario createUsuario(UsuarioCreateRequest usuarioCreateRequest);

    void deleteUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario, UsuarioCreateRequest usuarioCreateRequest);

    Usuario authenticate(UsuarioLogin usuarioLogin, String toen);

    Usuario findByEmail(String email);
}
