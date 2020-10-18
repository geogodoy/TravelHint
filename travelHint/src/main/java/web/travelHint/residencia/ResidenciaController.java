package web.travelHint.residencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.travelHint.residencia.payload.ResidenciaCreateRequest;
import web.travelHint.residencia.payload.ResidenciaUpdateRequest;
import web.travelHint.residencia.service.ResidenciaService;
import web.travelHint.usuarioidioma.UsuarioIdioma;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaCreateRequest;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaUpdateRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ResidenciaController {

    @Autowired
    ResidenciaService residenciaService;

    public ResidenciaController(ResidenciaService residenciaService){
        this.residenciaService = residenciaService;
    }

    @GetMapping("/residencias")
    public List<Residencia> listResidencias(){
        return residenciaService.listResidencias();
    }

    @GetMapping("/residencia/{id}")
    public Residencia findUResidencia(@PathVariable(value = "id") long id){
        return residenciaService.findResidencia(id);
    }

    @PostMapping("/residencia")
    public Residencia createResidencia(@Valid @RequestBody ResidenciaCreateRequest residenciaCreateRequest){
        return residenciaService.createResidencia(residenciaCreateRequest);

    }

    @DeleteMapping("/residencia/{id}")
    public void deleteResidencia(@PathVariable(value = "id") long id){
        Residencia residencia = residenciaService.findResidencia(id);
        residenciaService.deleteResidencia(residencia);
    }

    @PutMapping("/residencia/{id}")
    public Residencia updateResidencia(@PathVariable(value = "id") long id,
                                       @RequestBody ResidenciaUpdateRequest residenciaUpdateRequest){
        Residencia residencia = residenciaService.findResidencia(id);

        return residenciaService.updateResidencia(residencia,residenciaUpdateRequest);
    }
}
