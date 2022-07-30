package fmportfolio.Services;

import fmportfolio.Entity.Acerca;
import fmportfolio.Repository.IAcercaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpAcercaService {
    
    @Autowired
    IAcercaRepository acercaRepository;
    
    public Optional<Acerca> getUnAcercade(int id){
        return acercaRepository.findById(id);
    }
 
    public void saveAcerca(Acerca acerca) {
        acercaRepository.save(acerca);
    }

    public void deleteAcerca(int id) {
        acercaRepository.deleteById(id);
    }

    public Acerca findAcerca(int id) {
        Acerca acerca = acercaRepository.findById(id).orElse(null);
       return acerca;
    }
    
    public List<Acerca> list(){
       return acercaRepository.findAll();
    }
}
