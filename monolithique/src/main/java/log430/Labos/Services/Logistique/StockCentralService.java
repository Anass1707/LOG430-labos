package log430.Labos.Services.Logistique;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import log430.Labos.Models.DTOs.DemandeReapprovisionnementDTO;
import log430.Labos.Models.DTOs.StockCentralDTO;
import log430.Labos.Models.Entities.Logistique.DemandeReapprovisionnement;
import log430.Labos.Models.Entities.Logistique.StockCentral;
import log430.Labos.Models.Entities.Magasin.Magasin;
import log430.Labos.Models.Entities.Produit.Produit;
import log430.Labos.Models.Mappers.DemandeReapprovisionnementMapper;
import log430.Labos.Models.Mappers.StockCentralMapper;
import log430.Labos.Repositories.DemandeReapprovisionnementRepository;
import log430.Labos.Repositories.MagasinRepository;
import log430.Labos.Repositories.ProduitRepository;
import log430.Labos.Repositories.StockCentralRepository;

@Service
public class StockCentralService {

    private final StockCentralRepository stockCentralRepository;
    private final DemandeReapprovisionnementRepository demandeRepository;
    private final MagasinRepository magasinRepository;
    private final ProduitRepository produitRepository;

    public StockCentralService(StockCentralRepository stockCentralRepository,
                              DemandeReapprovisionnementRepository demandeRepository,
                              MagasinRepository magasinRepository,
                              ProduitRepository produitRepository) {
        this.stockCentralRepository = stockCentralRepository;
        this.demandeRepository = demandeRepository;
        this.magasinRepository = magasinRepository;
        this.produitRepository = produitRepository;
    }

    public List<StockCentralDTO> getStockCentral() {
        return stockCentralRepository.findAll().stream().map(StockCentralMapper::toDTO).toList();
    }

    public List<DemandeReapprovisionnementDTO> getDemandesByMagasin(Long magasinId) {
        return demandeRepository.findByMagasinId(magasinId)
        .stream().map(DemandeReapprovisionnementMapper::toDTO).toList();
    }

    public void creerDemande(Long magasinId, Long produitId, int quantite) {
        final StockCentral stockCentral = stockCentralRepository.findByProduitId(produitId);
        if (stockCentral != null && stockCentral.getQuantite() >= quantite) {
            stockCentral.setQuantite(stockCentral.getQuantite() - quantite);
            final DemandeReapprovisionnement demande = new DemandeReapprovisionnement();
            final Magasin magasin = magasinRepository.findById(magasinId).orElse(null);
            if (magasin == null) {
                throw new IllegalArgumentException("Magasin non trouvé pour l'ID: " + magasinId);
            }
            demande.setMagasin(magasin);
            final Produit produit = produitRepository.findById(produitId).orElse(null);
            if (produit == null) {
                throw new IllegalArgumentException("Produit non trouvé pour l'ID: " + produitId);
            }
            
            demande.setProduit(produit);
            demande.setQuantiteDemandee(quantite);
            demande.setDateDemande(new Date());
            demande.setStatut("EN_ATTENTE");
            demandeRepository.save(demande);
            stockCentralRepository.save(stockCentral);
        } else {
            throw new IllegalArgumentException("Stock central insuffisant pour ce produit.");
        }
    }
}
