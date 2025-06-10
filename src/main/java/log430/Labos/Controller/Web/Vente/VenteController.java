package log430.Labos.Controller.Web.Vente;
import java.util.List;
import java.util.Map.Entry;

import log430.Labos.Models.Entities.Produit.Produit;
import log430.Labos.Models.Entities.Vente.Vente;
import log430.Labos.Services.Vente.VenteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/{id}")
    public Vente getVente(Long id) {
        return venteService.getVente(id);
    }

    @GetMapping("/")
    public List<Vente> getAllVentes() {
        return venteService.getAllVentes();
    }
    
    @GetMapping("/produits-plus-vendus")
    public String produitsPlusVendus(Model model) {
        final List<Entry<Produit, Integer>> produits = venteService.getProduitsLesPlusVendus(1);

        model.addAttribute("produitsPlusVendus", produits);
        return "rapportProduitsPlusVendus";
    }
}
