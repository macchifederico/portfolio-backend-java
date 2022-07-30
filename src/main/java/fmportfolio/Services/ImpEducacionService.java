package fmportfolio.Services;

import fmportfolio.Entity.Educacion;
import fmportfolio.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService{
    
    @Autowired
    IEducacionRepository iEducacionRepository;

    public List<Educacion> list() {
        List<Educacion> educaciones = iEducacionRepository.findAll();
        return educaciones;
    }
    
    public Optional<Educacion> getUnaEducacion(int id){
        return iEducacionRepository.findById(id);
    }
    
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    public void deleteEducacion(int id) {
        iEducacionRepository.deleteById(id);
    }

    public Educacion findEducacion(int id) {
        Educacion educacion = iEducacionRepository.findById(id).orElse(null);
       return educacion;
    }
    
    public boolean existsByIdEducacion(int id){
        return iEducacionRepository.existsById(id);
    }
   
    
}
