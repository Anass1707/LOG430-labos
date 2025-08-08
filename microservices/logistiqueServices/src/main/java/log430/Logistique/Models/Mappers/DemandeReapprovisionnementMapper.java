package log430.Logistique.Models.Mappers;

import log430.Logistique.Models.DTOs.DemandeReapprovisionnementDTO;
import log430.Logistique.Models.Entities.Logistique.DemandeReapprovisionnement;

public class DemandeReapprovisionnementMapper {
    public static DemandeReapprovisionnementDTO toDTO(DemandeReapprovisionnement demande) {
        final DemandeReapprovisionnementDTO dto = new DemandeReapprovisionnementDTO();
        dto.setId(demande.getId());
        dto.setMagasinId(demande.getMagasinId());
        dto.setProduitId(demande.getProduitId());
        dto.setQuantiteDemandee(demande.getQuantiteDemandee());
        dto.setDateDemande(demande.getDateDemande());
        dto.setStatut(demande.getStatut());
        return dto;
    }

    public static DemandeReapprovisionnement toEntity(DemandeReapprovisionnementDTO dto) {
        final DemandeReapprovisionnement demande = new DemandeReapprovisionnement();
        demande.setId(dto.getId());
        demande.setQuantiteDemandee(dto.getQuantiteDemandee());
        demande.setDateDemande(dto.getDateDemande());
        demande.setStatut(dto.getStatut());
        return demande;
    }
}