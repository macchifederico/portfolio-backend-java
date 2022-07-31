package fmportfolio.Controller;

import fmportfolio.Dto.dtoPersona;
import fmportfolio.Entity.Persona;
import fmportfolio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://loginfirebase-22c59.web.app")
@RestController
@RequestMapping("/api/personas/")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> personas = iPersonaService.getPersona();
         return new ResponseEntity(personas, HttpStatus.OK);
    }
    
      @GetMapping("detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        Persona persona = iPersonaService.findPersona(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('admin')")
    @PostMapping("crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    //@PreAuthorize("hasRole('admin')")
    @DeleteMapping("borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    //@PreAuthorize("hasRole('admin')")
    @PutMapping("editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
            @RequestBody dtoPersona dtoPersona) {

        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setImg(dtoPersona.getImg());
        persona.setOcupacion(dtoPersona.getOcupacion());

        iPersonaService.savePersona(persona);
        return persona;

    }

}
