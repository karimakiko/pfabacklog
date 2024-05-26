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
    private String toncin;
    private Date datededepart;
    private int nbrjours;
    private int nbrjourdeduire;
    private int nbrjournepasdeduire;
    @Enumerated(EnumType.STRING)
    private Typeabsence type = Typeabsence.maladie; // Set a default value

    private int reliquat;
    private  String cinramplacant;
    private int cumul;
    private statusdemade status=statusdemade.notyet;
    @ManyToOne
    private Fonctionnaire fonctionnaire;

}
