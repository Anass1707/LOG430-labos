package src.main.java.log430.Ventes.Models.Mappers;

import src.main.java.log430.Ventes.Models.Entities.Logistique.DemandeReapprovisionnement;
import src.main.java.log430.Ventes.Models.DTOs.DemandeReapprovisionnementDTO;

public class DemandeReapprovisionnementMapper {
    public static DemandeReapprovisionnementDTO toDTO(DemandeReapprovisionnement demande) {
        final DemandeReapprovisionnementDTO dto = new DemandeReapprovisionnementDTO();
        dto.setId(demande.getId());
        dto.setMagasinId(demande.getMagasin() != null ? demande.getMagasin().getId() : null);
        dto.setProduitId(demande.getProduit() != null ? demande.getProduit().getId() : null);
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