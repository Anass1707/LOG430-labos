package log430.Ventes.Models.Mappers;

import log430.Ventes.Models.Entities.Logistique.StockCentral;
import log430.Ventes.Models.DTOs.StockCentralDTO;

public class StockCentralMapper {
    public static StockCentralDTO toDTO(StockCentral stock) {
        final StockCentralDTO dto = new StockCentralDTO();
        dto.setId(stock.getId());
        dto.setProduitId(stock.getProduit() != null ? stock.getProduit().getId() : null);
        dto.setQuantite(stock.getQuantite());
        return dto;
    }
}