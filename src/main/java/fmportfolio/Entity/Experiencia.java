package fmportfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter 
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String empresaE;
    private String descripcionE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String empresaE, String descripcionE) {
        this.nombreE = nombreE;
        this.empresaE = empresaE;
        this.descripcionE = descripcionE;
    }
  
}
