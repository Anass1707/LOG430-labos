package log430.Logistique.Services.Logistique;

import org.springframework.stereotype.Service;

import log430.Logistique.Models.DTOs.DemandeReapprovisionnementDTO;
import log430.Logistique.Models.DTOs.StockCentralDTO;
import log430.Logistique.Models.Entities.Logistique.DemandeReapprovisionnement;
import log430.Logistique.Models.Entities.Logistique.StockCentral;
import log430.Logistique.Models.Mappers.DemandeReapprovisionnementMapper;
import log430.Logistique.Models.Mappers.StockCentralMapper;
import log430.Logistique.Repositories.DemandeReapprovisionnementRepository;
import log430.Logistique.Repositories.StockCentralRepository;

@Service
public class LogistiqueService {
    
    private final StockCentralRepository stockCentralRepository;
    private final DemandeReapprovisionnementRepository demandeReapprovisionnementRepository;

    public LogistiqueService(StockCentralRepository stockCentralRepository,
                             DemandeReapprovisionnementRepository demandeReapprovisionnementRepository) {
        this.stockCentralRepository = stockCentralRepository;
        this.demandeReapprovisionnementRepository = demandeReapprovisionnementRepository;
    }
    // verif prod -> verif magasin -> verif stock -> create demande


    public StockCentralDTO getStockById(int idProduct, int Quantity) {
        final StockCentral stockCentral = stockCentralRepository.findByProduitId(idProduct);
        if (stockCentral != null && stockCentral.getQuantite() >= Quantity) {
            return StockCentralMapper.toDTO(stockCentral);
        }
        return null;
    }
    public StockCentralDTO updateStock(int idProduct, int quantity) {
        final StockCentral stockCentral = stockCentralRepository.findByProduitId(idProduct);
        if (stockCentral != null) {
            stockCentral.setQuantite(stockCentral.getQuantite() - quantity);
            stockCentralRepository.save(stockCentral);
            return StockCentralMapper.toDTO(stockCentral);
        }
        return null;
    }
    public String createReapprovisionnementRequest(int idProduct, int quantity, int idMagasin) {
        final DemandeReapprovisionnementDTO demande = new DemandeReapprovisionnementDTO();
        demande.setProduitId(idProduct);
        demande.setQuantiteDemandee(quantity);
        demande.setMagasinId(idMagasin);
        demande.setStatut("En attente");
        demande.setDateDemande(new java.util.Date()); 
        try {
            final DemandeReapprovisionnement demandeEntity = DemandeReapprovisionnementMapper.toEntity(demande);
            demandeReapprovisionnementRepository.save(demandeEntity);
        } catch (Exception e) {
            return "Erreur lors de la création de la demande de réapprovisionnement: " + e.getMessage();
        }
        return "Reussi";
    }
}
