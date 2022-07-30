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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String institucion;
    private String fechaInicio;
    private String fechaFin;

    public Educacion() {
    }

    public Educacion(String titulo, String institucion, String fechaInicio, String fechaFin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
}
