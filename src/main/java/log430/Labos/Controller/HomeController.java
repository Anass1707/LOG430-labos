package log430.Labos.Controller;
import log430.Labos.Repositories.UtilisateurRepository;
import log430.Labos.Services.Magasin.MagasinService;
import log430.Labos.Entities.Magasin.Magasin;
import log430.Labos.Entities.Utilisateur.Utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UtilisateurRepository utilisateurRepository;
    private final MagasinService magasinService;
    
    public HomeController(UtilisateurRepository utilisateurRepository,
                           MagasinService magasinService) {
        this.utilisateurRepository = utilisateurRepository;
        this.magasinService = magasinService;
    }
    
    public String helloWorld() {
        return "Hello, World!";
    }
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

    public Utilisateur getUtilisateur(int id) {
        final Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById((long) id);
        if (!utilisateurOpt.isPresent()) {
            System.out.println("Aucun utilisateur trouvé.");
            return null;
        } else {
            final Utilisateur utilisateur = utilisateurOpt.get();
            System.out.println("Utilisateur trouvé :");
            System.out.println(utilisateur.getNom() + " - " + utilisateur.getEmail());
            return utilisateur;
        }
    }
    @GetMapping("/")
    public String choisirMagasin(Model model) {
        final List<Magasin> magasins = magasinService.getAllMagasins();
        if (magasins.isEmpty()) {
            System.out.println("Aucun magasin trouvé.");
            model.addAttribute("message", "Aucun magasin trouvé.");
        } else {
            System.out.println("Liste des magasins :");
            for (Magasin magasin : magasins) {
                System.out.println(magasin.getNom() + " - " + magasin.getAdresse());
            }
            model.addAttribute("magasins", magasins);
        }
        return "choisirMagasin";
    }
}