package web.travelHint.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.travelHint.token.TokenService;
import web.travelHint.usuario.payload.UsuarioRequest;

@Component
public class UsuarioFactory {

    @Autowired
    TokenService tokenService;

    public UsuarioFactory(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public Usuario create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setToken(tokenService.generateToken(usuario));
        usuario.setSobrenome(usuarioRequest.getSobrenome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setDataNascimento(usuarioRequest.getDataNascimento());
        usuario.setBiografia(usuarioRequest.getBiografia());
        usuario.setImagemUrl(usuarioRequest.getImagemUrl());
        usuario.setGenero(usuarioRequest.getGenero());

        return usuario;
    }
}
