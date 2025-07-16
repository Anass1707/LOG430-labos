package log430.Labos.Models.Mappers;

import log430.Labos.Models.Entities.Magasin.StockMagasin;
import log430.Labos.Models.DTOs.StockMagasinDTO;

public class StockMagasinMapper {
    public static StockMagasinDTO toDTO(StockMagasin stock) {
        final StockMagasinDTO dto = new StockMagasinDTO();
        dto.setId(stock.getId());
        dto.setMagasinId(stock.getMagasin() != null ? stock.getMagasin().getId() : null);
        dto.setProduitId(stock.getProduit() != null ? stock.getProduit().getId() : null);
        dto.setMinimumStock(stock.getMinimumStock());
        dto.setQuantite(stock.getQuantite());
        return dto;
    }

    public static StockMagasin toEntity(StockMagasinDTO dto) {
        final StockMagasin stock = new StockMagasin();
        stock.setId(dto.getId());
        stock.setMinimumStock(dto.getMinimumStock());
        stock.setQuantite(dto.getQuantite());
        return stock;
    }
}