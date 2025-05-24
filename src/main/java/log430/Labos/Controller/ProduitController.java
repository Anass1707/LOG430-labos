package log430.Labos.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import log430.Labos.Entities.Produit;
import log430.Labos.Services.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable Long id) {
        return produitService.getProduit(id);
    }
    @GetMapping("/nom")
    public Produit getProduitsByNom(@RequestParam String nom) {
        return produitService.getProduitByNom(nom);
    }
    @GetMapping("/categorie")
    public List<Produit> getProduitsByCategorie(@RequestParam String categorie) {
        return produitService.getProduitsByCategorie(categorie);
    }

    @GetMapping("/")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
}