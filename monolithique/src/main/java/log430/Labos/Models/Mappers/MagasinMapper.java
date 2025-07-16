package log430.Labos.Models.Mappers;

import log430.Labos.Models.Entities.Magasin.Magasin;
import log430.Labos.Models.DTOs.MagasinDTO;

public class MagasinMapper {
    public static MagasinDTO toDTO(Magasin magasin) {
        final MagasinDTO dto = new MagasinDTO();
        dto.setId(magasin.getId());
        dto.setNom(magasin.getNom());
        dto.setAdresse(magasin.getAdresse());
        return dto;
    }
}