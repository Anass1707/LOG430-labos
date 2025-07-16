package src.main.java.log430.Labos.Controller.Web.Produit;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import src.main.java.log430.Labos.Models.DTOs.ProduitDTO;
import src.main.java.log430.Labos.Services.Produit.ProduitService;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/")
    public String getAllProduits(Model model) {
        model.addAttribute("produits", produitService.getAllProduits());
        return "produits";
    }

    @GetMapping("/{id}")
    public String getProduitById(@PathVariable Long id, Model model) {
        final ProduitDTO produit = produitService.getProduit(id);
        model.addAttribute("produit", produit);
        return "produitDetails";
    }

    @GetMapping("/nom")
    public String getProduitByNom(@RequestParam String nom, Model model) {
        final ProduitDTO produit = produitService.getProduitByNom(nom);
        model.addAttribute("produit", produit);
        return "produitDetails";
    }

    @GetMapping("/categorie")
    public String getProduitsByCategorie(@RequestParam String categorie, Model model) {
        final List<ProduitDTO> produits = produitService.getProduitsByCategorie(categorie);
        model.addAttribute("produits", produits);
        return "produits";
    }
}