package log430.Labos.Services;
import log430.Labos.Entities.Produit;
import log430.Labos.Repositories.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduit(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit non trouvé"));
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public Produit getProduitByNom(String nom) {
        return produitRepository.findByNom(nom);
    }
    public List<Produit> getProduitsByCategorie(String categorie) {
        return produitRepository.findByCategorie(categorie);
    }
}