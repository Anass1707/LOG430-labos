package src.main.java.log430.Labos.Controller.API.Produit;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import src.main.java.log430.Labos.Models.DTOs.ProduitDTO;
import src.main.java.log430.Labos.Services.Produit.ProduitService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/produits")
public class ProductController {

    private final ProduitService produitService;

    public ProductController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public ResponseEntity<List<ProduitDTO>> getAllProduits() {
        final List<ProduitDTO> produits = produitService.getAllProduits()
            .stream()
            .collect(Collectors.toList());
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        final ProduitDTO produit = produitService.getProduit(id);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produit);
    }

    @GetMapping("/nom")
    public ResponseEntity<ProduitDTO> getProduitByNom(@RequestParam String nom) {
        final ProduitDTO produit = produitService.getProduitByNom(nom);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produit);
    }

    @GetMapping("/categorie")
    public ResponseEntity<List<ProduitDTO>> getProduitsByCategorie(@RequestParam String categorie) {
        final List<ProduitDTO> produits = produitService.getProduitsByCategorie(categorie)
            .stream()
            .collect(Collectors.toList());
        return ResponseEntity.ok(produits);
    }
    @PostMapping
    public ResponseEntity<ProduitDTO> addProduit(@RequestBody ProduitDTO produit) {
        final ProduitDTO createdProduit = produitService.addProduit(produit);
        return ResponseEntity.status(201).body(createdProduit);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProduitDTO> updateProduit(@PathVariable Long id, @RequestBody ProduitDTO produitDTO) {
        final ProduitDTO updatedProduit = produitService.updateProduit(id, produitDTO);
        if (updatedProduit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduit);
    }
}
