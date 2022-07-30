package fmportfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String apellido;
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    private String img;
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String ocupacion;
    private String urlLinkedin;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String ocupacion, String urlLinkedin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.ocupacion = ocupacion;
        this.urlLinkedin = urlLinkedin;
    }
    
    
    
}
