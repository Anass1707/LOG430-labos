package log430.Ventes.Models.Mappers;

import log430.Ventes.Models.Entities.Vente.Retour;
import log430.Ventes.Models.DTOs.RetourDTO;

public class RetourMapper {
    public static RetourDTO toDTO(Retour retour) {
        final RetourDTO dto = new RetourDTO();
        dto.setId(retour.getId());
        dto.setUtilisateurId(retour.getUtilisateur() != null ? retour.getUtilisateur().getId() : null);
        dto.setVenteId(retour.getVente() != null ? retour.getVente().getId() : null);
        dto.setDateRetour(retour.getDateRetour());
        dto.setMotif(retour.getMotif());
        return dto;
    }

    public static Retour toEntity(RetourDTO dto) {
        final Retour retour = new Retour();
        retour.setId(dto.getId());
        retour.setDateRetour(dto.getDateRetour());
        retour.setMotif(dto.getMotif());
        return retour;
    }
}