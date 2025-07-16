package src.main.java.log430.Labos.Models.Mappers;

import src.main.java.log430.Labos.Models.Entities.Vente.Vente;
import src.main.java.log430.Labos.Models.DTOs.VenteDTO;

public class VenteMapper {
    public static VenteDTO toDTO(Vente vente) {
        final VenteDTO dto = new VenteDTO();
        dto.setId(vente.getId());
        dto.setUtilisateurId(vente.getUtilisateur() != null ? vente.getUtilisateur().getId() : null);
        dto.setDateVente(vente.getDateVente());
        dto.setTotal(vente.getTotal());

        // dto.setMagasinId(vente..getMagasin() != null ? vente.getMagasin().getId() : null);
        // if (vente.getLignesVente() != null) {
        //     List<Long> lignesIds = vente.getLignesVente().stream()
        //         .map(LigneVente::getId)
        //         .collect(Collectors.toList());
        //     dto.setLignesVenteIds(lignesIds);
        // }
        return dto;
    }

    public static Vente toEntity(VenteDTO dto) {
        final Vente vente = new Vente();
        vente.setDateVente(dto.getDateVente());
        vente.setTotal(dto.getTotal());
        vente.setId(dto.getId());
        return vente;
    }
}