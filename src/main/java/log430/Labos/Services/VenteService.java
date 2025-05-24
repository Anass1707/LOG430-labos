package log430.Labos.Services;
import log430.Labos.Entities.Vente;
import log430.Labos.Repositories.VenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import log430.Labos.Entities.Produit;
import log430.Labos.Entities.LigneVente;
import log430.Labos.Entities.LigneVenteId;

import org.springframework.transaction.annotation.Transactional;
import log430.Labos.Repositories.ProduitRepository;

import java.util.List;

@Service
public class VenteService {

    private final VenteRepository venteRepository;
    private final ProduitRepository produitRepository;

    public VenteService(VenteRepository venteRepository, ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
        this.venteRepository = venteRepository;
    }

@Transactional
public Vente createVente(Vente vente) {
    float total = 0;
    if (vente.getLignesVente() != null && !vente.getLignesVente().isEmpty()) {
        final List<LigneVente> lignes = vente.getLignesVente();
        vente.setLignesVente(null);
        final Vente newVente = venteRepository.save(vente);
        for (LigneVente ligne : lignes) {
            final Produit produit = produitRepository.findById(ligne.getProduit().getId())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
    
            if (ligne.getQuantite() > produit.getQuantite()) {
                throw new IllegalArgumentException("Stock insuffisant pour le produit " + produit.getNom());
            }
    
            produit.setQuantite(produit.getQuantite() - ligne.getQuantite());
            final Produit updatedProduit = produitRepository.save(produit);
    
            final LigneVenteId id = new LigneVenteId();
            id.setIdVente(newVente.getId());
            System.out.println("produit : " + updatedProduit.getId());
            id.setIdProduit(updatedProduit.getId());
            ligne.setId(id);
            ligne.setVente(newVente);
            ligne.setProduit(updatedProduit);
            total += updatedProduit.getPrix() * ligne.getQuantite();
        }
        newVente.setLignesVente(lignes);
        newVente.setTotal(total);
        return venteRepository.save(newVente);
    }
    return null;
}

    public Vente getVente(Long id) {
        return venteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vente non trouvée"));
    }

    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }
}
