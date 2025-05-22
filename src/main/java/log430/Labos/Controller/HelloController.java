package log430.Labos.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import log430.Labos.Repositories.UtilisateurRepository;
import log430.Labos.Entities.Utilisateur;
import java.util.List;

@RestController
public class HelloController {

    private final UtilisateurRepository utilisateurRepository;
    public HelloController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/users")
    public List<Utilisateur> getAllUtilisateurs() {
        final List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur trouvé.");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (Utilisateur utilisateur : utilisateurs) {
                System.out.println(utilisateur.getNom() + " - " + utilisateur.getEmail());
            }
        }
        System.out.println(utilisateurRepository.findAll());
        return utilisateurs;
    }
}