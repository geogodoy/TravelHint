package web.travelHint.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.UsuarioRepository;
import web.travelHint.usuario.exception.UsuarioEmailAlreadyExistExcpetion;
import web.travelHint.usuario.payload.UsuarioRequest;

@Service
public class UsuarioValidationServiceImpl implements UsuarioValidationService{

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioValidationServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void checkUsuarioEmail(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioRequest.getEmail());
        if(usuario != null){
            throw new UsuarioEmailAlreadyExistExcpetion(usuario.getEmail());
        }
    }
}
