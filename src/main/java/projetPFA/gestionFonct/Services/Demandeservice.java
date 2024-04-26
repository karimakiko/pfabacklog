package projetPFA.gestionFonct.Services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetPFA.gestionFonct.Demande_absence;
import projetPFA.gestionFonct.Repositories.DemandeRepository;

import java.util.List;

@Data
@Service
public class Demandeservice {
    private DemandeRepository demandeRepository;

    @Autowired
    public Demandeservice(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public void ajouterdemande(Demande_absence demande) {
        this.demandeRepository.save(demande);
    }

    public List<Demande_absence> affichertousdemande() {
        return this.demandeRepository.findAll();
    }

    public void deletedemande(String code) {
        boolean exists = demandeRepository.existsById(code);
        if (!exists) {
            throw new IllegalStateException("Aucune demande avec ce code : " + code + " n'existe ");
        } else {
            demandeRepository.deleteById(code);
        }
    }

    public Demande_absence getdemandeBycode(String code) {
        return demandeRepository.findById(code)
                .orElseThrow(() -> new IllegalStateException("Aucune demande avec ce code : " + code + " n'est trouvée"));
    }

    public Demande_absence updateDemande(String code, Demande_absence updatedDemande) {
        // Recherche de la demande d'absence existante par son code
        Demande_absence existingDemande = demandeRepository.findByCode(code);

        if (existingDemande != null) {
            // Mettre à jour les champs de la demande existante avec les valeurs de la demande mise à jour
            existingDemande.setDatededepart(updatedDemande.getDatededepart());
            existingDemande.setNbrjours(updatedDemande.getNbrjours());
            existingDemande.setNbrjourdeduire(updatedDemande.getNbrjourdeduire());
            existingDemande.setNbrjournepasdeduire(updatedDemande.getNbrjournepasdeduire());
            existingDemande.setType(updatedDemande.getType());
            existingDemande.setReliquat(updatedDemande.getReliquat());
            existingDemande.setCinramplacant(updatedDemande.getCinramplacant());
            existingDemande.setCumul(updatedDemande.getCumul());
            existingDemande.setFonctionnaire(updatedDemande.getFonctionnaire());

            // Enregistrer les modifications dans la base de données
            return demandeRepository.save(existingDemande);
        } else {
            // La demande d'absence n'existe pas avec le code spécifié, renvoyer null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
