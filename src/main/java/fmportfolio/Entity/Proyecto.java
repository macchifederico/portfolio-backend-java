package fmportfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyecto;
    private String descrProyecto;
    private String urlProyecto;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descrProyecto, String urlProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descrProyecto = descrProyecto;
        this.urlProyecto = urlProyecto;
    }

 
}
