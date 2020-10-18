package web.travelHint.usuariotopico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.idioma.Idiomas;
import web.travelHint.papel.Papeis;
import web.travelHint.proficiencia.Proficiencias;
import web.travelHint.topico.Topicos;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.service.UsuarioService;
import web.travelHint.usuarioidioma.UsuarioIdioma;
import web.travelHint.usuarioidioma.exception.UsuarioIdiomaAlreadyExistExcpetion;
import web.travelHint.usuarioidioma.exception.UsuarioIdiomaProficienciaAlreadyExistExcpetion;
import web.travelHint.usuariotopico.UsuarioTopico;
import web.travelHint.usuariotopico.UsuarioTopicoRepository;
import web.travelHint.usuariotopico.exception.UsuarioTopicoAlreadyExistExcpetion;
import web.travelHint.usuariotopico.exception.UsuarioTopicoNotFoundExcpetion;
import web.travelHint.usuariotopico.exception.UsuarioTopicoPapelAlreadyExistExcpetion;
import web.travelHint.usuariotopico.payload.UsuarioTopicoCreateRequest;

import java.util.List;

@Service
public class UsuarioTopicoServiceImpl implements UsuarioTopicoService {

    private static final String topicos[] = {String.valueOf(Topicos.COMIDA_E_BEBIDA),
            String.valueOf(Topicos.COMPRAS),
            String.valueOf(Topicos.AR_LIVRE),
            String.valueOf(Topicos.HISTORICOS),
            String.valueOf(Topicos.PARQUES_E_PRAIAS),
            String.valueOf(Topicos.EVENTOS),
            String.valueOf(Topicos.TRANSPORTE),
            String.valueOf(Topicos.AJUDA)};

    private static final String papeis[] = {String.valueOf(Papeis.VIAJANTE),
            String.valueOf(Papeis.RESIDENTE)};

    @Autowired
    UsuarioTopicoRepository usuarioTopicoRepository;
    UsuarioService usuarioService;

    public UsuarioTopicoServiceImpl(UsuarioTopicoRepository usuarioTopicoRepository,
                                    UsuarioService usuarioService){
        this.usuarioTopicoRepository = usuarioTopicoRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<UsuarioTopico> listUsuarioTopicos() {
        return usuarioTopicoRepository.findAll();
    }

    @Override
    public UsuarioTopico findUsuarioTopico(long id) {
        UsuarioTopico usuarioTopico = usuarioTopicoRepository.findById(id);

        if(usuarioTopico == null) {
            throw new UsuarioTopicoNotFoundExcpetion(id);
        }else{
            return usuarioTopico;
        }
    }

    @Override
    public UsuarioTopico createUsuarioTopico(UsuarioTopicoCreateRequest usuarioTopicoCreateRequest) {
       UsuarioTopico usuarioTopico = new UsuarioTopico();

        Usuario usuario = usuarioService.findUsuario(usuarioTopicoCreateRequest.getUsuarioId());

        verifyUsuarioTopicoExist(usuarioTopicoCreateRequest);
        verifyTopicoExist(usuarioTopicoCreateRequest);

        usuarioTopico.setUsuario(usuario);

        usuarioTopico.setTopicoId(setTopico(usuarioTopicoCreateRequest.getTopicoId()));
        usuarioTopico.setPapelId(setPapel(usuarioTopicoCreateRequest.getPapelId()));

        return usuarioTopicoRepository.save(usuarioTopico);
    }

    private String setPapel(String papelId) {
        for(String papel : papeis){
            if (papel.equals(papelId)){
                return papel;
            }
        }
        return null;
    }

    private String setTopico(String topicoId) {
        for(String topico : topicos){
            if (topico.equals(topicoId)){
                return topico;
            }
        }
        return null;
    }

    private void verifyTopicoExist(UsuarioTopicoCreateRequest usuarioTopicoCreateRequest) {
        UsuarioTopico usuarioTopico = usuarioTopicoRepository
                .findByTopicoId(usuarioTopicoCreateRequest.getTopicoId());

        if( usuarioTopico!= null){
            throw new UsuarioTopicoAlreadyExistExcpetion(usuarioTopicoCreateRequest.getTopicoId());
        }
    }

    private void verifyUsuarioTopicoExist(UsuarioTopicoCreateRequest usuarioTopicoCreateRequest) {
        UsuarioTopico usuarioTopicoExiste = usuarioTopicoRepository
                .findByTopicoIdAndPapelId(usuarioTopicoCreateRequest.getTopicoId(), usuarioTopicoCreateRequest.getPapelId());

        if( usuarioTopicoExiste!= null){
            throw new UsuarioTopicoPapelAlreadyExistExcpetion(usuarioTopicoCreateRequest.getTopicoId(), usuarioTopicoCreateRequest.getPapelId());
        }
    }

    @Override
    public void deleteUsuarioTopico(UsuarioTopico usuarioTopico) {
        usuarioTopicoRepository.delete(usuarioTopico);
    }
}
