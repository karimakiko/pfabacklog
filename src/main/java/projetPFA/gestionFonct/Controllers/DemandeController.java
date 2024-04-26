package projetPFA.gestionFonct.Controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetPFA.gestionFonct.Demande_absence;
import projetPFA.gestionFonct.Services.Demandeservice;

import java.util.List;

@Data
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ressourcehumaine/demandeabsence")
public class DemandeController {

    @Autowired
    private Demandeservice demandeservice;

    @PostMapping("/ajouter")
    public ResponseEntity<Demande_absence> ajouterDemande(@RequestBody Demande_absence demande) {
        demandeservice.ajouterdemande(demande);
        return new ResponseEntity<>(demande, HttpStatus.CREATED);
    }

    @GetMapping("/afficher-tous")
    public ResponseEntity<List<Demande_absence>> afficherTousDemandes() {
        List<Demande_absence> demandes = demandeservice.affichertousdemande();
        return new ResponseEntity<>(demandes, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{code}")
    public ResponseEntity<String> supprimerDemande(@PathVariable String code) {
        demandeservice.deletedemande(code);
        return new ResponseEntity<>("Demande avec le code " + code + " supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping("/afficher/{code}")
    public ResponseEntity<Demande_absence> afficherDemandeParCode(@PathVariable String code) {
        Demande_absence demande = demandeservice.getdemandeBycode(code);
        return new ResponseEntity<>(demande, HttpStatus.OK);
    }

    @PutMapping("/modifier/{code}")
    public ResponseEntity<Demande_absence> modifierDemande(@PathVariable String code, @RequestBody Demande_absence updatedDemande) {
        Demande_absence updated = demandeservice.updateDemande(code, updatedDemande);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
