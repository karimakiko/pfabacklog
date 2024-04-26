package projetPFA.gestionFonct;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.Date;
@Data
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Demande_absence {
    @Id
    private String code;
    private Date datededepart;
    private int nbrjours;
    private int nbrjourdeduire;
    private int nbrjournepasdeduire;
    private Typeabsence type ;
    private int reliquat;
    private  String cinramplacant;
    private int cumul;

    @ManyToOne
    private Fonctionnaire fonctionnaire;

}
