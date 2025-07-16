package src.main.java.log430.Labos.Models.Mappers;

import src.main.java.log430.Labos.Models.Entities.Logistique.StockCentral;
import src.main.java.log430.Labos.Models.DTOs.StockCentralDTO;

public class StockCentralMapper {
    public static StockCentralDTO toDTO(StockCentral stock) {
        final StockCentralDTO dto = new StockCentralDTO();
        dto.setId(stock.getId());
        dto.setProduitId(stock.getProduit() != null ? stock.getProduit().getId() : null);
        dto.setQuantite(stock.getQuantite());
        return dto;
    }
}