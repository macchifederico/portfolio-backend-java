package fmportfolio.Controller;

import fmportfolio.Dto.dtoExperiencia;
import fmportfolio.Entity.Experiencia;
import fmportfolio.Services.ImpExperienciaService;
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
import org.springframework.web.bind.annotation.RestController;

//import org.slf4j.Logger;

@RestController
@RequestMapping("/api/experiencia/")
@CrossOrigin(origins = "https://loginfirebase-22c59.web.app")
public class ExperienciaController {
    
    @Autowired
    ImpExperienciaService impExperienciaService;
            
    @GetMapping("lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> experiencias = impExperienciaService.list();
         return new ResponseEntity(experiencias, HttpStatus.OK);
    }
     
    @GetMapping("detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impExperienciaService.existsByIdExperiencia(id))
            return new ResponseEntity("La experiencia no existe", HttpStatus.BAD_REQUEST);
        Experiencia experiencia = impExperienciaService.getUnaExperiencia(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('admin')")
    @PostMapping("crear")
    public ResponseEntity<?> createExperiencia(@RequestBody dtoExperiencia dtoExp) {
        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(),dtoExp.getEmpresaE(), dtoExp.getDescripcionE());
        impExperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity("Experiencia laboral creada con exito", HttpStatus.OK);
    }
    
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable int id){
        if (!impExperienciaService.existsByIdExperiencia(id))
            return new ResponseEntity("El ID no existe", HttpStatus.BAD_REQUEST);
        impExperienciaService.deleteExperiencia(id);
     
        return new ResponseEntity("Experiencia eliminada", HttpStatus.OK);
    }
    

    //@PreAuthorize("hasRole('admin')")
    @PutMapping("editar/{id}")
    public Experiencia editarExperiencia(@PathVariable int id,
            @RequestBody dtoExperiencia dtoExp){
        
        Experiencia experiencia = impExperienciaService.findExperiencia(id);
        experiencia.setEmpresaE(dtoExp.getEmpresaE());
        experiencia.setNombreE(dtoExp.getNombreE());
        experiencia.setDescripcionE(dtoExp.getDescripcionE());
        
        impExperienciaService.saveExperiencia(experiencia);
        return experiencia;
    }
    
}
