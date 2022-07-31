package fmportfolio.Controller;

import fmportfolio.Dto.dtoEducacion;
import fmportfolio.Entity.Educacion;
import fmportfolio.Services.ImpEducacionService;
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

//@CrossOrigin(origins = "https://loginfirebase-22c59.web.app")
@RestController
@RequestMapping("/api/educacion/")
@CrossOrigin(origins = "https://loginfirebase-22c59.web.app")
public class EducacionController {
    
    @Autowired
    ImpEducacionService impEducacionService;
    
    @GetMapping("lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> educacion = impEducacionService.list();
         return new ResponseEntity(educacion, HttpStatus.OK);
    }
     
    @GetMapping("detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsByIdEducacion(id))
            return new ResponseEntity("La educacion no existe", HttpStatus.BAD_REQUEST);
        Educacion educacion = impEducacionService.getUnaEducacion(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('admin')")
    @PostMapping("crear")
    public ResponseEntity<?> createExperiencia(@RequestBody dtoEducacion dtoEdu) {
        Educacion educacion = new Educacion(dtoEdu.getTitulo(), dtoEdu.getInstitucion(), dtoEdu.getFechaInicio(), dtoEdu.getFechaFin());
        impEducacionService.saveEducacion(educacion);
        return new ResponseEntity("Educacion creada con exito", HttpStatus.OK);
    }
    
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable int id){
        if (!impEducacionService.existsByIdEducacion(id))
            return new ResponseEntity("El ID no existe", HttpStatus.BAD_REQUEST);
        impEducacionService.deleteEducacion(id);
     
        return new ResponseEntity("Educacion eliminada", HttpStatus.OK);
    }
    

    //@PreAuthorize("hasRole('admin')")
    @PutMapping("editar/{id}")
    public Educacion editarEducacion(@PathVariable int id, @RequestBody dtoEducacion dtoEdu){
        
        Educacion educacion = impEducacionService.findEducacion(id);
        educacion.setTitulo(dtoEdu.getTitulo());
        educacion.setTitulo(dtoEdu.getTitulo());
        educacion.setFechaInicio(dtoEdu.getFechaInicio());
        educacion.setFechaFin(dtoEdu.getFechaFin());
        
        impEducacionService.saveEducacion(educacion);
        return educacion;
    }
    
}
