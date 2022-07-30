package fmportfolio.Controller;

import fmportfolio.Dto.dtoSkills;
import fmportfolio.Entity.Skills;
import fmportfolio.Services.ImpSkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/skills/")
public class SkillsController {
    
    @Autowired
    ImpSkillsService impSkillsService;
    
    @GetMapping("lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> proyectos = impSkillsService.list();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Skills> getUnSkill(@PathVariable int id){
        Skills skill = impSkillsService.getUnSkill(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("crear")
    public ResponseEntity<?> crearSkill(@RequestBody dtoSkills dtoSkills){
        Skills skill = new Skills(dtoSkills.getTecnologia(), dtoSkills.getPorcentaje());
        impSkillsService.saveSkill(skill);
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PutMapping("editar/{id}")
    public ResponseEntity<?> editarSkill(@PathVariable int id, @RequestBody dtoSkills dtoSkills){
        Skills skill = impSkillsService.getUnSkillById(id);
        
        skill.setTecnologia(dtoSkills.getTecnologia());
        skill.setPorcentaje(dtoSkills.getPorcentaje());
        
        impSkillsService.saveSkill(skill);
        
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") int  id){
        impSkillsService.deleteSkill(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
