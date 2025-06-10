package log430.Labos.Models.Mappers;

import log430.Labos.Models.Entities.Vente.LigneVente;
import log430.Labos.Models.DTOs.LigneVenteDTO;

public class LigneVenteMapper {
    public static LigneVenteDTO toDTO(LigneVente ligneVente) {
        final LigneVenteDTO dto = new LigneVenteDTO();
        dto.setIdVente(ligneVente.getVente() != null ? ligneVente.getVente().getId() : null);
        dto.setIdProduit(ligneVente.getProduit() != null ? ligneVente.getProduit().getId() : null);
        dto.setQuantite(ligneVente.getQuantite());
        return dto;
    }
}