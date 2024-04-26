package projetPFA.gestionFonct.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetPFA.gestionFonct.Services.RHService;

@RestController
@RequestMapping("/ressourcehumaine")
public class RHController {

    @Autowired
    private RHService rhService;

    @PostMapping("/demandeabsence/{code}/approuver")
    public void approuverDemande(@PathVariable String code) {
        rhService.approuverDemande(code);
    }

    @PostMapping("/demandeabsence/{code}/rejeter")
    public void rejeterDemande(@PathVariable String code) {
        rhService.rejeterDemande(code);
    }

    @PostMapping("/updateAbsenceOnNewYear")
    public void updateSoldeAbsenceOnNewYear() {
        rhService.updateSoldeAbsenceOnNewYear();
    }
}
