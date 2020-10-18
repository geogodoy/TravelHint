package web.travelHint.usuarioidioma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaCreateRequest;
import web.travelHint.usuarioidioma.payload.UsuarioIdiomaUpdateRequest;
import web.travelHint.usuarioidioma.service.UsuarioIdiomaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UsuarioIdiomaController {

    @Autowired
    UsuarioIdiomaService usuarioIdiomaService;

    public UsuarioIdiomaController(UsuarioIdiomaService usuarioIdiomaService){
        this.usuarioIdiomaService = usuarioIdiomaService;
    }


    @GetMapping("/usuario/idiomas")
    public List<UsuarioIdioma> listUsuarioIdiomas(){
        return usuarioIdiomaService.listUsuarioIdiomas();
    }

    @GetMapping("/usuario/idioma/{id}")
    public UsuarioIdioma findUsuarioIdioma(@PathVariable(value = "id") long id){
        return usuarioIdiomaService.findUsuarioIdioma(id);
    }

    @PostMapping("/usuario/idioma")
    public UsuarioIdioma createUsuarioIdioma(@Valid @RequestBody UsuarioIdiomaCreateRequest usuarioIdiomaCreateRequest){
        return usuarioIdiomaService.createUsuarioIdioma(usuarioIdiomaCreateRequest);

    }

    @DeleteMapping("/usuario/idioma/{id}")
    public void deleteUsuarioIdioma(@PathVariable(value = "id") long id){
        UsuarioIdioma usuarioIdioma = usuarioIdiomaService.findUsuarioIdioma(id);
        usuarioIdiomaService.deleteUsuarioIdioma(usuarioIdioma);
    }

    @PutMapping("/usuario/idioma/{id}")
    public UsuarioIdioma updateUsuarioIdioma(@PathVariable(value = "id") long id,
                                             @RequestBody UsuarioIdiomaUpdateRequest usuarioIdiomaUpdateRequest){
        UsuarioIdioma usuarioIdioma = usuarioIdiomaService.findUsuarioIdioma(id);

        return usuarioIdiomaService.updateUsuarioIdioma(usuarioIdioma, usuarioIdiomaUpdateRequest);
    }

}
