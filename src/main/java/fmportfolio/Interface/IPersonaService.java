package fmportfolio.Interface;

import fmportfolio.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    //Traer una lista de personas    
    public List<Persona> getPersona();
    
    //guardar un objeto persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto persona
    public void deletePersona(Long id);
    
    //buscar una persona
    public Persona findPersona(Long id);
    
}
