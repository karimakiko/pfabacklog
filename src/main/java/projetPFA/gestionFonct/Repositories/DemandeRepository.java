package projetPFA.gestionFonct.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetPFA.gestionFonct.Demande_absence;
import projetPFA.gestionFonct.Fonctionnaire;

@Repository
public interface DemandeRepository extends JpaRepository<Demande_absence,String > {
    Demande_absence findByCode(String codeDemande);
}
