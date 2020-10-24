package web.travelHint.chamadoidioma;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.travelHint.chamado.Chamado;
import web.travelHint.chamado.payload.ChamadoCreateRequest;
import web.travelHint.chamado.service.ChamadoService;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaCreateRequest;
import web.travelHint.chamadoidioma.payload.ChamadoIdiomaUpdateRequest;
import web.travelHint.chamadoidioma.service.ChamadoIdiomaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ChamadoIdiomaController {

    @Autowired
    ChamadoIdiomaService chamadoIdiomaService;

    public ChamadoIdiomaController(ChamadoIdiomaService chamadoIdiomaService){
        this.chamadoIdiomaService = chamadoIdiomaService;
    }

    @GetMapping("/chamado/idiomas")
    public List<ChamadoIdioma> listChamadoIdiomas(){
        return chamadoIdiomaService.listChamadoIdiomas();
    }

    @GetMapping("/chamado/idioma/{id}")
    public ChamadoIdioma findChamadoIdioma(@PathVariable(value = "id") long id){
        return chamadoIdiomaService.findChamadoIdioma(id);
    }

    @PostMapping("/chamado/idioma")
    public ChamadoIdioma createChamadoIdioma(@Valid @RequestBody ChamadoIdiomaCreateRequest chamadoIdiomaCreateRequest){
        return chamadoIdiomaService.createChamadoIdioma(chamadoIdiomaCreateRequest);
    }

    @PutMapping("/chamado/idioma/{id}")
    public ChamadoIdioma updateChamadoIdioma(@PathVariable(value = "id") long id,
                                             @Valid @RequestBody ChamadoIdiomaUpdateRequest chamadoIdiomaUpdateRequest){
        ChamadoIdioma chamadoIdioma = chamadoIdiomaService.findChamadoIdioma(id);
        return chamadoIdiomaService.updateChamadoIdioma(chamadoIdioma,chamadoIdiomaUpdateRequest);
    }
}
