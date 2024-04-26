package projetPFA.gestionFonct.Services;

import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetPFA.gestionFonct.Fonctionnaire;
import projetPFA.gestionFonct.Repositories.FonctionnaireRepository;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class FonctionnaireService {
    private FonctionnaireRepository fonctionnaireRepository;
    @Autowired
    public FonctionnaireService(FonctionnaireRepository fonctionnaireRepository){
        this.fonctionnaireRepository=fonctionnaireRepository;
    }
    public void ajouterFonctionnaire(Fonctionnaire fonctionnaire) {

        fonctionnaireRepository.save(fonctionnaire);
    }

    public List<Fonctionnaire> getAllFonct() {

        return fonctionnaireRepository.findAll();
    }


    public void deleteFonct(String cin) {
        boolean exists=fonctionnaireRepository.existsById(cin);
        if (!exists) {
            throw new IllegalStateException("NO INFOPERSO WITH THIS CIN : " + cin + "IS FOUND");
        }
        else fonctionnaireRepository.deleteById(cin);

    }

    public Fonctionnaire getFonctById(String cin) {
        return fonctionnaireRepository.findById(cin).orElseThrow(()-> new IllegalStateException("NO INFOPERSO WITH THIS CIN : "+cin+"IS FOUND"));
}
}