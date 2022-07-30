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
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tecnologia;
    private int porcentaje;

    public Skills() {
    }

    public Skills(String tecnologia, int porcentaje) {
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
    }
    
}
