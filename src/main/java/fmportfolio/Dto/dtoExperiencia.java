package fmportfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoExperiencia {
    
    private String nombreE;
    private String empresaE;
    private String descripcionE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String empresaE, String descripcionE) {
        this.nombreE = nombreE;
        this.empresaE = empresaE;
        this.descripcionE = descripcionE;
    }

    
    
}
