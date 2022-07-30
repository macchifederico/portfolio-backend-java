package fmportfolio.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoSkills {
    
    private int id;
    private String tecnologia;
    private int porcentaje;

    public dtoSkills() {
    }

    public dtoSkills(int id, String tecnologia, int porcentaje) {
        this.id = id;
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
    }

}
