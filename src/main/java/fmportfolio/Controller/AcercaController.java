package fmportfolio.Controller;

import fmportfolio.Dto.dtoAcerca;
import fmportfolio.Entity.Acerca;
import fmportfolio.Services.ImpAcercaService;
import java.util.List;
import java.util.Optional;
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
@CrossOrigin(origins = "https://loginfirebase-22c59.web.app")
@RequestMapping("/api/acercade/")
public class AcercaController {
    
    @Autowired
    ImpAcercaService impAcercaService;
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Acerca> getById(@PathVariable int id){
        Acerca acerca = impAcercaService.getUnAcercade(id).get();
        return new ResponseEntity(acerca, HttpStatus.OK);
    }
    
    @GetMapping("lista")
    public ResponseEntity<List<Acerca>> list(){
        List<Acerca> acerca = impAcercaService.list();
        return new ResponseEntity(acerca, HttpStatus.OK);
    }
    
    @PostMapping("crear")
    public ResponseEntity<?> crearAcercade(@RequestBody dtoAcerca dtoAcercade){
        Acerca acerca = new Acerca(dtoAcercade.getPresentProf());
        impAcercaService.saveAcerca(acerca);
        return new ResponseEntity(acerca, HttpStatus.OK);
    }
    
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deleteAcercade(@PathVariable int id){
        impAcercaService.deleteAcerca(id);
        return new ResponseEntity("Borrada con exito", HttpStatus.OK);
    }
    
    @PutMapping("editar/{id}")
    public Acerca editarAcercade(@PathVariable int id, @RequestBody dtoAcerca dtoAcercade){
        Acerca acerca = impAcercaService.findAcerca(id);
        acerca.setPresentProf(dtoAcercade.getPresentProf());
        impAcercaService.saveAcerca(acerca);
        return acerca;
    }
    
    
}
