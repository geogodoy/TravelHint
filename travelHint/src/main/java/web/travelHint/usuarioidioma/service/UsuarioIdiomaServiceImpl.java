package web.travelHint.usuarioidioma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.idioma.Idiomas;
import web.travelHint.proficiencia.Proficiencias;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.exception.UsuarioNotFoundExcpetion;
import web.travelHint.usuario.service.UsuarioService;
import web.travelHint.usuarioidioma.UsuarioIdioma;
import web.travelHint.usuarioidioma.UsuarioIdiomaRepository;
import web.travelHint.usuarioidioma.exception.UsuarioIdiomaAlreadyExistExcpetion;
import web.travelHint.usuarioidioma.exception.UsuarioIdiomaProficienciaAlreadyExistExcpetion;
import web.travelHint.usuarioidioma.exception.UsuarioIdiomaNotFoundExcpetion;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaCreateRequest;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaUpdateRequest;

import java.util.List;

@Service
public class UsuarioIdiomaServiceImpl implements UsuarioIdiomaService {

    private static final String idiomas[] = {String.valueOf(Idiomas.INGLES),
            String.valueOf(Idiomas.ESPANHOL),
            String.valueOf(Idiomas.ITALIANO),
            String.valueOf(Idiomas.FRANCES),
            String.valueOf(Idiomas.PORTUGUES),
            String.valueOf(Idiomas.COREANO),
            String.valueOf(Idiomas.MANDARIM),
            String.valueOf(Idiomas.JAPONES),
            String.valueOf(Idiomas.ALEMAO)};

    private static final String proficiencias[] = {String.valueOf(Proficiencias.BASICO),
            String.valueOf(Proficiencias.INTERMEDIARIO),
            String.valueOf(Proficiencias.AVANCADO),
            String.valueOf(Proficiencias.FLUENTE)};

    @Autowired
    UsuarioIdiomaRepository usuarioIdiomaRepository;
    UsuarioService usuarioService;

    public UsuarioIdiomaServiceImpl(UsuarioIdiomaRepository usuarioIdiomaRepository,
                                    UsuarioService usuarioService){
        this.usuarioIdiomaRepository = usuarioIdiomaRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<UsuarioIdioma> listUsuarioIdiomas() {
        return usuarioIdiomaRepository.findAll();
    }

    @Override
    public UsuarioIdioma findUsuarioIdioma(long id) {
        UsuarioIdioma usuarioIdioma = usuarioIdiomaRepository.findById(id);

        if(usuarioIdioma == null) {
            throw new UsuarioIdiomaNotFoundExcpetion(id);
        }else{
            return usuarioIdioma;
        }
    }

    @Override
    public UsuarioIdioma findUsuarioIdiomaByUsuario(long usuarioId) {
        UsuarioIdioma usuarioIdioma = usuarioIdiomaRepository.findByUsuarioId(usuarioId);

        if(usuarioIdioma == null) {
            throw new UsuarioNotFoundExcpetion(usuarioId);
        }else{
            return usuarioIdioma;
        }
    }

    @Override
    public UsuarioIdioma createUsuarioIdioma(UsuarioIdiomaCreateRequest usuarioIdiomaCreateRequest) {
        UsuarioIdioma usuarioIdioma = new UsuarioIdioma();
        Usuario usuario = usuarioService.findUsuario(usuarioIdiomaCreateRequest.getUsuarioId());

        verifyUsuarioIdiomaExist(usuarioIdiomaCreateRequest);
        verifyIdiomaExist(usuarioIdiomaCreateRequest);

        usuarioIdioma.setUsuario(usuario);

        usuarioIdioma.setIdiomaId(setIdioma(usuarioIdiomaCreateRequest.getIdiomaId()));
        usuarioIdioma.setProficienciaId(setProficiencia(usuarioIdiomaCreateRequest.getProficienciaId()));

        return usuarioIdiomaRepository.save(usuarioIdioma);
    }

    private void verifyIdiomaExist(UsuarioIdiomaCreateRequest usuarioIdiomaCreateRequest) {
        UsuarioIdioma usuarioIdiomaExiste = usuarioIdiomaRepository
                .findByIdiomaId(usuarioIdiomaCreateRequest.getIdiomaId());

        if( usuarioIdiomaExiste!= null){
            throw new UsuarioIdiomaAlreadyExistExcpetion(usuarioIdiomaCreateRequest.getIdiomaId());
        }
    }

    private void verifyUsuarioIdiomaExist(UsuarioIdiomaCreateRequest usuarioIdiomaCreateRequest) {
        UsuarioIdioma usuarioIdiomaExiste = usuarioIdiomaRepository
                .findByIdiomaIdAndProficienciaId(usuarioIdiomaCreateRequest.getIdiomaId(), usuarioIdiomaCreateRequest.getProficienciaId());

        if( usuarioIdiomaExiste!= null){
            throw new UsuarioIdiomaProficienciaAlreadyExistExcpetion(usuarioIdiomaCreateRequest.getIdiomaId(), usuarioIdiomaCreateRequest.getProficienciaId());
        }
    }

    private String setProficiencia(String proficienciaId) {
        for(String proficiencia : proficiencias){
            if (proficiencia.equals(proficienciaId)){
                return proficiencia;
            }
        }
        return null;
    }

    private String setIdioma(String idiomaId) {
        for(String idioma : idiomas){
            if (idioma.equals(idiomaId)){
                return idioma;
            }
        }
        return null;
    }

    @Override
    public void deleteUsuarioIdioma(UsuarioIdioma usuarioIdioma) {
        usuarioIdiomaRepository.delete(usuarioIdioma);
    }

    @Override
    public UsuarioIdioma updateUsuarioIdioma(UsuarioIdioma usuarioIdioma,
                                             UsuarioIdiomaUpdateRequest usuarioIdiomaUpdateRequest) {
        usuarioIdioma.setProficienciaId(setProficiencia(usuarioIdiomaUpdateRequest.getProficienciaId()));

        return usuarioIdiomaRepository.save(usuarioIdioma);
    }
}
