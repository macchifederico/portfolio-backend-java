package fmportfolio.Repository;

import fmportfolio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//<Clase de donde proviene, tipo de PK>
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
