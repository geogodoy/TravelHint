package web.travelHint.chamadoidioma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.travelHint.chamado.Chamado;
import web.travelHint.chamado.service.ChamadoService;
import web.travelHint.chamadoidioma.ChamadoIdioma;
import web.travelHint.chamadoidioma.ChamadoIdiomaRepository;
import web.travelHint.chamadoidioma.exception.ChamadoIdiomaAlreadyExistExcpetion;
import web.travelHint.chamadoidioma.exception.ChamadoIdiomaNotFoundExcpetion;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaCreateRequest;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaUpdateRequest;
import web.travelHint.idioma.Idiomas;
import web.travelHint.usuario.Usuario;
import web.travelHint.usuario.service.UsuarioService;

import java.util.List;

@Service
public class ChamadoIdiomaServiceImpl implements ChamadoIdiomaService{

    private static final String idiomas[] = {String.valueOf(Idiomas.INGLES),
            String.valueOf(Idiomas.ESPANHOL),
            String.valueOf(Idiomas.ITALIANO),
            String.valueOf(Idiomas.FRANCES),
            String.valueOf(Idiomas.PORTUGUES),
            String.valueOf(Idiomas.COREANO),
            String.valueOf(Idiomas.CHINES),
            String.valueOf(Idiomas.JAPONES),
            String.valueOf(Idiomas.ALEMAO)};

    @Autowired
    ChamadoIdiomaRepository chamadoIdiomaRepository;
    ChamadoService chamadoService;

    public ChamadoIdiomaServiceImpl(ChamadoIdiomaRepository chamadoIdiomaRepository,
                                    ChamadoService chamadoService){
        this.chamadoIdiomaRepository = chamadoIdiomaRepository;
        this.chamadoService = chamadoService;
    }

    @Override
    public List<ChamadoIdioma> listChamadoIdiomas() {
        return chamadoIdiomaRepository.findAll();
    }

    @Override
    public ChamadoIdioma findChamadoIdioma(long id) {
        ChamadoIdioma chamadoIdioma = chamadoIdiomaRepository.findById(id);

        if(chamadoIdioma == null) {
            throw new ChamadoIdiomaNotFoundExcpetion(id);
        }else{
            return chamadoIdioma;
        }
    }

    @Override
    public ChamadoIdioma createChamadoIdioma(ChamadoIdiomaCreateRequest chamadoIdiomaCreateRequest) {
        ChamadoIdioma chamadoIdioma = new ChamadoIdioma();
        Chamado chamado = chamadoService.findChamado(chamadoIdiomaCreateRequest.getChamadoId());

        verifyIdiomaExist(chamadoIdiomaCreateRequest);

        chamadoIdioma.setChamado(chamado);

        chamadoIdioma.setIdiomaId(setIdioma(chamadoIdiomaCreateRequest.getIdiomaId()));

        return chamadoIdiomaRepository.save(chamadoIdioma);
    }

    private String setIdioma(String idiomaId) {
        for(String idioma : idiomas){
            if (idioma.equals(idiomaId)){
                return idioma;
            }
        }
        return null;
    }

    private void verifyIdiomaExist(ChamadoIdiomaCreateRequest chamadoIdiomaCreateRequest) {
        ChamadoIdioma chamadoIdiomaExiste = chamadoIdiomaRepository
                .findByIdiomaId(chamadoIdiomaCreateRequest.getIdiomaId());

        if( chamadoIdiomaExiste!= null){
            throw new ChamadoIdiomaAlreadyExistExcpetion(chamadoIdiomaCreateRequest.getIdiomaId());
        }
    }

    @Override
    public ChamadoIdioma updateChamadoIdioma(ChamadoIdioma chamadoIdioma, ChamadoIdiomaUpdateRequest chamadoIdiomaUpdateRequest) {
        chamadoIdioma.setIdiomaId(setIdioma(chamadoIdiomaUpdateRequest.getIdiomaId()));

        return chamadoIdiomaRepository.save(chamadoIdioma);
    }
}
