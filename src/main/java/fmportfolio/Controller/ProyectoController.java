package fmportfolio.Controller;

import fmportfolio.Dto.dtoProyecto;
import fmportfolio.Entity.Proyecto;
import fmportfolio.Services.ImpProyectoService;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/proyecto/")
public class ProyectoController {
    
    @Autowired
    ImpProyectoService impProyectoService;
    
    @GetMapping("lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> proyectos = impProyectoService.list();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Proyecto> getUnProyecto(@PathVariable int id){
        Proyecto proyecto = impProyectoService.getUnProyecto(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("crear")
    public ResponseEntity<?> crearProyecto(@RequestBody dtoProyecto dtoPro){
        Proyecto proyecto = new Proyecto(dtoPro.getNombreProyecto(), dtoPro.getDescrProyecto(), dtoPro.getUrlProyecto());
        impProyectoService.saveProyecto(proyecto);
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PutMapping("editar/{id}")
    public ResponseEntity<?> editarProyecto(@PathVariable int id, @RequestBody dtoProyecto dtoPro){
        Proyecto proyecto = impProyectoService.getUnProyectoById(id);
        
        proyecto.setNombreProyecto(dtoPro.getNombreProyecto());
        proyecto.setDescrProyecto(dtoPro.getDescrProyecto());
        proyecto.setUrlProyecto(dtoPro.getUrlProyecto());
        
        impProyectoService.saveProyecto(proyecto);
        
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable("id") int  id){
        impProyectoService.deleteProyecto(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
