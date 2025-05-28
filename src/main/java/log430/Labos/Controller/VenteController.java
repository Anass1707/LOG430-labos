package log430.Labos.Controller;
import java.util.List;
import log430.Labos.Entities.Vente;
import log430.Labos.Services.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ventes")
public class VenteController {

    private final VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    public Vente createVente(Vente vente) {
        System.out.println("Vente reçue : " + vente.getLignesVente().size());
        return venteService.createVente(vente);
    }

    public Vente getVente(Long id) {
        return venteService.getVente(id);
    }
    public List<Vente> getAllVentes() {
        return venteService.getAllVentes();
    }
}
