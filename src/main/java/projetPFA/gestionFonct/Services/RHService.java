package projetPFA.gestionFonct.Services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetPFA.gestionFonct.Demande_absence;
import projetPFA.gestionFonct.Fonctionnaire;
import projetPFA.gestionFonct.Repositories.DemandeRepository;
import projetPFA.gestionFonct.Repositories.FonctionnaireRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Data
@Service
public class RHService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private FonctionnaireRepository fonctionnaireRepository;

    public void approuverDemande(String codeDemande) {

        Demande_absence demande = demandeRepository.findByCode(codeDemande);

        Fonctionnaire fonctionnaire = demande.getFonctionnaire();
        fonctionnaire.setSoldeAbsence(((Fonctionnaire) fonctionnaire).getSoldeAbsence() - demande.getNbrjours());

        demandeRepository.save(demande);
        fonctionnaireRepository.save(fonctionnaire);
    }

    public void rejeterDemande(String codeDemande) {
        Demande_absence demande = demandeRepository.findByCode(codeDemande);
        demandeRepository.delete(demande);
    }

    public void updateSoldeAbsenceOnNewYear() {

        LocalDate currentDate = LocalDate.now();


        if (currentDate.getMonth() == Month.DECEMBER && currentDate.getDayOfMonth() == 31) {

            List<Fonctionnaire> fonctionnaires = fonctionnaireRepository.findAll();
            for (Fonctionnaire fonctionnaire : fonctionnaires) {
                fonctionnaire.setSoldeAbsence(0);
                fonctionnaireRepository.save(fonctionnaire);
            }
        }

        if (currentDate.getMonth() == Month.JANUARY && currentDate.getDayOfMonth() == 1) {

            List<Fonctionnaire> fonctionnaires = fonctionnaireRepository.findAll();
            for (Fonctionnaire fonctionnaire : fonctionnaires) {
                fonctionnaire.setSoldeAbsence(22);
                fonctionnaireRepository.save(fonctionnaire);
            }
        }
    }
}
