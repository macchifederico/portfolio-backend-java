package fmportfolio.Services;

import fmportfolio.Entity.Proyecto;
import fmportfolio.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpProyectoService {
    
    @Autowired
    IProyectoRepository iProyectoRepository;
    
    public List<Proyecto> list(){
        return iProyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getUnProyecto(int id){
       return iProyectoRepository.findById(id);
    }
    
    public Proyecto getUnProyectoById(int id){
        Proyecto proyecto = iProyectoRepository.getById(id);
        return proyecto;
    }
    
    public void saveProyecto(Proyecto proyecto){
        iProyectoRepository.save(proyecto);
    }
    
    public void deleteProyecto(int id){
        iProyectoRepository.deleteById(id);
    }
        
}
