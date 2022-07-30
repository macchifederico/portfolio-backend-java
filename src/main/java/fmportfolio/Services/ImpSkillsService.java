package fmportfolio.Services;

import fmportfolio.Entity.Skills;
import fmportfolio.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpSkillsService {
    
    @Autowired
    ISkillsRepository iSkillsRepository;
    
     public List<Skills> list(){
        return iSkillsRepository.findAll();
    }
    
    public Optional<Skills> getUnSkill(int id){
       return iSkillsRepository.findById(id);
    }
    
    public Skills getUnSkillById(int id){
        Skills skill = iSkillsRepository.getById(id);
        return skill;
    }
    
    public void saveSkill(Skills skill){
        iSkillsRepository.save(skill);
    }
    
    public void deleteSkill(int id){
        iSkillsRepository.deleteById(id);
    }
}
