package log430.Labos.Controller.Magasin;

import log430.Labos.Entities.Magasin.Magasin;
import log430.Labos.Entities.Magasin.StockMagasin;
import log430.Labos.Entities.Produit.Produit;
import log430.Labos.Entities.Vente.Vente;
import log430.Labos.Services.Magasin.MagasinService;
import log430.Labos.Services.Vente.VenteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.Map.Entry;

@Controller
@RequestMapping("/rapports")
public class RapportController {

    private final VenteService venteService;
    private final MagasinService magasinService;

    public RapportController(VenteService venteService, MagasinService magasinService) {
        this.magasinService = magasinService;
        this.venteService = venteService;
    }


    @GetMapping
    public String pageRapports() {
        return "rapports";
    }

    @GetMapping("/rapportDetaille")
    public String rapportDetaille(Model model) {
        final Map<Magasin, List<Vente>> ventesParMagasin = venteService.getVentesParMagasin();
        model.addAttribute("ventesParMagasin", ventesParMagasin);

        final List<Entry<Produit, Integer>> produitsPlusVendus = venteService.getProduitsLesPlusVendus(1);
        model.addAttribute("produitsPlusVendus", produitsPlusVendus);

        final Map<Magasin, List<StockMagasin>> stocksParMagasin = magasinService.getStocksRestantsParMagasin();
        model.addAttribute("stocksParMagasin", stocksParMagasin);

        return "rapportDetaille";
    }

    @GetMapping("/ventes-par-magasin")
    public String ventesParMagasin(Model model) {
        final Map<Magasin, List<Vente>> ventesParMagasin = venteService.getVentesParMagasin();
        System.out.println("Ventes par magasin: " + ventesParMagasin.size());
        model.addAttribute("ventesParMagasin", ventesParMagasin);
        return "rapportVentesParMagasin";
    }

    @GetMapping("/stocks-par-magasin")
    public String stocksParMagasin(Model model) {
        final Map<Magasin, List<StockMagasin>> stocksParMagasin = magasinService.getStocksRestantsParMagasin();
        System.out.println("Stocks par magasin: " + stocksParMagasin.size());
        model.addAttribute("stocksParMagasin", stocksParMagasin);
        return "rapportStocksParMagasin";
    }
    @GetMapping("/stock-magasin")
    public String stockMagasinParId(Long magasinId, Model model) {
        final Magasin magasin = magasinService.getMagasin(magasinId);

        if (magasin != null) {
            model.addAttribute("magasin", magasin);
            model.addAttribute("stocks", magasin.getStocks());
        } else {
            model.addAttribute("message", "Magasin non trouvé");
        }
        return "stockMagasinParId";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("magasins", magasinService.getDashboard());
        return "dashboard";
    }
}