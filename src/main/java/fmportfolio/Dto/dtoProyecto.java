package fmportfolio.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class dtoProyecto {
    
    private String nombreProyecto;
    private String descrProyecto;
    private String urlProyecto;

    public dtoProyecto(String nombreProyecto, String descrProyecto, String urlProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descrProyecto = descrProyecto;
        this.urlProyecto = urlProyecto;
    }

    public dtoProyecto() {
    }
    
}
