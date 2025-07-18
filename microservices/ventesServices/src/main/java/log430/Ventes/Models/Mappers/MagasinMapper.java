package log430.Ventes.Models.Mappers;

import log430.Ventes.Models.Entities.Magasin.Magasin;
import log430.Ventes.Models.DTOs.MagasinDTO;

public class MagasinMapper {
    public static MagasinDTO toDTO(Magasin magasin) {
        final MagasinDTO dto = new MagasinDTO();
        dto.setId(magasin.getId());
        dto.setNom(magasin.getNom());
        dto.setAdresse(magasin.getAdresse());
        return dto;
    }
}