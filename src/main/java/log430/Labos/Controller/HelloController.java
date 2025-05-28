package log430.Labos.Controller;
import log430.Labos.Repositories.UtilisateurRepository;
import log430.Labos.Entities.Utilisateur;
import java.util.List;
import java.util.Optional;

public class HelloController {

    private final UtilisateurRepository utilisateurRepository;
    public HelloController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
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
}