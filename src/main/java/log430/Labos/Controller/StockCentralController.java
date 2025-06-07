package log430.Labos.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import log430.Labos.Entities.Magasin;
import log430.Labos.Entities.StockMagasin;
import log430.Labos.Services.MagasinService;
import log430.Labos.Services.StockCentralService;

@Controller
@RequestMapping("/stockCentral")
public class StockCentralController {

    private final StockCentralService stockCentralService;
    private final MagasinService magasinService;

    public StockCentralController(StockCentralService stockCentralService, MagasinService magasinService) {
        this.stockCentralService = stockCentralService;
        this.magasinService = magasinService;
    }

    @GetMapping
    public String afficherStockCentral(@RequestParam(required = false) Long magasinId, Model model) {
        model.addAttribute("stockCentral", stockCentralService.getStockCentral());
        model.addAttribute("magasins", magasinService.getAllMagasins());

        if (magasinId != null) {
            final Magasin magasin = magasinService.getMagasin(magasinId);
            model.addAttribute("magasin", magasin);

            // Récupère le stock du magasin sélectionné
            final List<StockMagasin> stockMagasinList = magasinService.getMagasin(magasinId).getStocks();
            model.addAttribute("stockMagasin", stockMagasinList);

            final Map<Long, StockMagasin> stockMagasinMap = new HashMap<>();
            for (StockMagasin s : stockMagasinList) {
               stockMagasinMap.put(s.getProduit().getId(), s);
            }
            model.addAttribute("stockMagasinMap", stockMagasinMap);
        }
        return "stockCentral";
    }

    @PostMapping("/demande")
    public String creerDemande(@RequestParam Long magasinId,
                               @RequestParam Long produitId,
                               @RequestParam int quantite,
                               RedirectAttributes redirectAttributes) {
        stockCentralService.creerDemande(magasinId, produitId, quantite);
        redirectAttributes.addFlashAttribute("message", "Demande de réapprovisionnement envoyée !");
        return "redirect:/stockCentral?magasinId=" + magasinId;
    }
}
