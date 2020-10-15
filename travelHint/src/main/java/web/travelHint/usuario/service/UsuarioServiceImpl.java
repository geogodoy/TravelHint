package web.travelHint.usuario.service;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.token.TokenService;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.UsuarioFactory;
import web.travelHint.usuario.UsuarioRepository;
import web.travelHint.usuario.exception.*;
import web.travelHint.usuario.payload.UsuarioLogin;
import web.travelHint.usuario.payload.UsuarioRequest;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    UsuarioFactory usuarioFactory;
    TokenService tokenService;
    UsuarioValidationService usuarioValidationService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UsuarioFactory usuarioFactory,
                              TokenService tokenService,
                              UsuarioValidationService usuarioValidationService){
        this.usuarioRepository = usuarioRepository;
        this.usuarioFactory = usuarioFactory;
        this.tokenService = tokenService;
        this.usuarioValidationService = usuarioValidationService;
    }

    @Override
    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuario(long id){
        Usuario usuario = usuarioRepository.findById(id);

        if(usuario == null) {
            throw new UsuarioNotFoundExcpetion(id);
        }else{
            return usuario;
        }
    }

    @Override
    public Usuario findUsuarioToken(long id) {
        Usuario usuario = new Usuario();

        usuario.setToken(tokenService.generateToken(usuario));

        usuarioRepository.save(usuario);

        return usuario;
    }


    @Override
    public Usuario createUsuario(UsuarioRequest usuarioRequest) {
        usuarioValidationService.checkUsuarioEmail(usuarioRequest);

        Usuario usuario = usuarioFactory.create(usuarioRequest);

        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario authenticate(UsuarioLogin usuarioLogin, String token) {
        String email = usuarioLogin.getEmail();
        Usuario usuario = findByEmail(email);
        if(usuario == null){
            throw new UsuarioEmailNotFoundExcpetion(usuarioLogin.getEmail());
        }

        if(usuarioLogin.getSenha().equals(usuario.getSenha()) && !token.isEmpty() && validate(token)) {
            return usuario;
        }else {
            throw new InvalidLoginException();
        }
    }

    private boolean validate(String token) {
        try{
            String tokenTratado = token.replace("Bearer", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());

            //verifia se o token está expirado
            if(claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            System.out.println(claims.getExpiration());
            return  true;
        }catch (ExpiredTokenException et) {
            et.printStackTrace();
            throw et;
        }catch (Exception e){
            e.printStackTrace();
            throw new InvalidTokenException();
        }
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
