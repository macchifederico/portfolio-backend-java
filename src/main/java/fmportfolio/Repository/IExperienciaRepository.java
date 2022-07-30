package fmportfolio.Repository;

import fmportfolio.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    
    public Optional<Experiencia> findByNombreE(String nombre);
    public boolean existsByNombreE(String nombre);

}
