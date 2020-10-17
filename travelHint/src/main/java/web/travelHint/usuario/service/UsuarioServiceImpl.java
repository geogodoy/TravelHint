package web.travelHint.usuario.service;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.genero.Generos;
import web.travelHint.proficiencia.Proficiencias;
import web.travelHint.token.TokenService;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.UsuarioRepository;
import web.travelHint.usuario.exception.*;
import web.travelHint.usuario.payload.UsuarioLogin;
import web.travelHint.usuario.payload.UsuarioCreateRequest;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final String generos[] = {String.valueOf(Generos.FEMININO),
            String.valueOf(Generos.MASCULINO),
            String.valueOf(Generos.OUTRO)};

    @Autowired
    UsuarioRepository usuarioRepository;
    TokenService tokenService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              TokenService tokenService){
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
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
    public Usuario createUsuario(UsuarioCreateRequest usuarioCreateRequest) {

        if(usuarioRepository.findByEmail(usuarioCreateRequest.getEmail()) != null){
            throw new UsuarioEmailAlreadyExistExcpetion(usuarioCreateRequest.getEmail());
        }

        Usuario usuario = new Usuario();

        usuario.setNome(usuarioCreateRequest.getNome());
        usuario.setToken(tokenService.generateToken(usuario));
        usuario.setSobrenome(usuarioCreateRequest.getSobrenome());
        usuario.setEmail(usuarioCreateRequest.getEmail());
        usuario.setSenha(usuarioCreateRequest.getSenha());
        usuario.setDataNascimento(usuarioCreateRequest.getDataNascimento());
        usuario.setBiografia(usuarioCreateRequest.getBiografia());
        usuario.setImagemUrl(usuarioCreateRequest.getImagemUrl());
        usuario.setGenero(setGenero(usuarioCreateRequest.getGenero()));

        return usuarioRepository.save(usuario);
    }

    private String setGenero(String generoId) {
        for(String genero : generos){
            if (genero.equals(generoId)){
                return genero;
            }
        }
        return null;
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario, UsuarioCreateRequest usuarioCreateRequest) {

        usuario.setNome(usuarioCreateRequest.getNome());
        usuario.setSobrenome(usuarioCreateRequest.getSobrenome());
        usuario.setSenha(usuarioCreateRequest.getSenha());
        usuario.setDataNascimento(usuarioCreateRequest.getDataNascimento());
        usuario.setBiografia(usuarioCreateRequest.getBiografia());
        usuario.setImagemUrl(usuarioCreateRequest.getImagemUrl());
        usuario.setGenero(usuarioCreateRequest.getGenero());

        usuarioRepository.save(usuario);

        return usuario;
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
