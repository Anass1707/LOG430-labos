package log430.Labos.Services.Produit;
import log430.Labos.Models.DTOs.ProduitDTO;
import log430.Labos.Models.Entities.Produit.Produit;
import log430.Labos.Models.Mappers.ProduitMapper;
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

    public Produit addProduit(ProduitDTO produit) {
        final Produit produitEntity = ProduitMapper.toEntity(produit);
        return produitRepository.save(produitEntity);
    }
    public Produit updateProduit(Long id, ProduitDTO produitDTO) {
        final Produit produit = getProduit(id);
        produit.setNom(produitDTO.getNom());
        produit.setCategorie(produitDTO.getCategorie());
        produit.setPrix(produitDTO.getPrix());
        return produitRepository.save(produit);
    }
}