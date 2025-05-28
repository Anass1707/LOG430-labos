package log430.Labos.Controller;

import log430.Labos.Entities.Magasin;
import log430.Labos.Entities.Produit;
import log430.Labos.Entities.StockMagasin;
import log430.Labos.Entities.Vente;
import log430.Labos.Services.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rapports")
public class RapportController {

    private final VenteService venteService;

    public RapportController(VenteService venteService) {
        this.venteService = venteService;
    }

    @GetMapping("/ventes-par-magasin")
    public String ventesParMagasin(Model model) {
        final Map<Magasin, List<Vente>> ventesParMagasin = venteService.getVentesParMagasin();
        System.out.println("Ventes par magasin: " + ventesParMagasin.size());
        model.addAttribute("ventesParMagasin", ventesParMagasin);
        return "rapportVentesParMagasin";
    }

    @GetMapping("/produits-plus-vendus")
    public String produitsPlusVendus(Model model) {
        final List<Map.Entry<Produit, Integer>> produits = venteService.getProduitsLesPlusVendus(1);

        model.addAttribute("produitsPlusVendus", produits);
        return "rapportProduitsPlusVendus";
    }

    @GetMapping("/stocks-par-magasin")
    public String stocksParMagasin(Model model) {
        final Map<Magasin, List<StockMagasin>> stocksParMagasin = venteService.getStocksRestantsParMagasin();
        System.out.println("Stocks par magasin: " + stocksParMagasin.size());
        model.addAttribute("stocksParMagasin", stocksParMagasin);
        return "rapportStocksParMagasin";
    }
}