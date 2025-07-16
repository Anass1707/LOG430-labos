package src.main.java.log430.Ventes.Models.Mappers;

import src.main.java.log430.Ventes.Models.Entities.Magasin.StockMagasin;
import src.main.java.log430.Ventes.Models.DTOs.StockMagasinDTO;

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