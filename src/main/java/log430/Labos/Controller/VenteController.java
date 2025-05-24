package log430.Labos.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import log430.Labos.Entities.Vente;
import log430.Labos.Services.VenteService;

@RestController
@RequestMapping("/ventes")
public class VenteController {

    private final VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @PostMapping
    public Vente createVente(@RequestBody Vente vente) {
        System.out.println("Vente reçue : " + vente.getLignesVente().size());
        return venteService.createVente(vente);
    }

    @GetMapping("/{id}")
    public Vente getVente(@PathVariable Long id) {
        return venteService.getVente(id);
    }

    @GetMapping("/")
    public List<Vente> getAllVentes() {
        return venteService.getAllVentes();
    }
}
