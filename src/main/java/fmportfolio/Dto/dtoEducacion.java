package fmportfolio.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoEducacion {
    
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    private String fechaInicio;
    private String fechaFin;

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String institucion, String fechaInicio, String fechaFin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
}
