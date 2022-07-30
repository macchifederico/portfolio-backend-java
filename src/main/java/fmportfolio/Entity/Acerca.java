package fmportfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Acerca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 1, max = 700, message = "No cumple con la longitud")
    private String presentProf;

    public Acerca() {
    }

    public Acerca(String presentProf) {
        this.presentProf = presentProf;
    }
    
    
}
