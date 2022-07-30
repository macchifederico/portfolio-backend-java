package fmportfolio.Services;

import fmportfolio.Entity.Experiencia;
import fmportfolio.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService{
    
    @Autowired
    IExperienciaRepository iExperienciaRepository;
    
    public List<Experiencia> list(){
        return iExperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getUnaExperiencia(int id){
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getUnaExperienciaByNombre(String nombre){
        return iExperienciaRepository.findByNombreE(nombre);
    }
    
    
    public void saveExperiencia(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    public void deleteExperiencia(int id) {
        iExperienciaRepository.deleteById(id);
    }

    public Experiencia findExperiencia(int id) {
        Experiencia persona = iExperienciaRepository.findById(id).orElse(null);
       return persona;
    }
    
    
    public boolean existsByIdExperiencia(int id){
        return iExperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreExperiencia(String nombre){
        return iExperienciaRepository.existsByNombreE(nombre);
    }
    
}