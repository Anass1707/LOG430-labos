package log430.Logistique.Models.Mappers;

import log430.Logistique.Models.Entities.Logistique.StockCentral;
import log430.Logistique.Models.DTOs.StockCentralDTO;

public class StockCentralMapper {
    public static StockCentralDTO toDTO(StockCentral stock) {
        final StockCentralDTO dto = new StockCentralDTO();
        dto.setId(stock.getId());
        dto.setProduitId(stock.getProduitId());
        dto.setQuantite(stock.getQuantite());
        return dto;
    }
}