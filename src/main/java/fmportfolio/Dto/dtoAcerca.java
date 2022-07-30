package fmportfolio.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoAcerca {

    private String presentProf;

    public dtoAcerca() {
    }

    public dtoAcerca(String presentProf) {
        this.presentProf = presentProf;
    }
    
}
