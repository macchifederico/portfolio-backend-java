package fmportfolio.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoPersona {

    private String nombre;
    private String apellido;
    private String img;
    private String ocupacion;
    private String urlLinkedin;


    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String ocupacion, String urlLinkedin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.ocupacion = ocupacion;
        this.urlLinkedin= urlLinkedin;
    }
    
    
}
