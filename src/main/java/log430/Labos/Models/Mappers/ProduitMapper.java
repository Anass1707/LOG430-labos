package log430.Labos.Models.Mappers;
import log430.Labos.Models.DTOs.ProduitDTO;
import log430.Labos.Models.Entities.Produit.Produit;

public class ProduitMapper {

    public static ProduitDTO toDTO(Produit produit) {
        final ProduitDTO dto = new ProduitDTO();
        dto.setId(produit.getId());
        dto.setNom(produit.getNom());
        dto.setPrix(produit.getPrix());
        dto.setCategorie(produit.getCategorie());
        return dto;
    }

    public static Produit toEntity(ProduitDTO dto) {
        final Produit produit = new Produit();
        produit.setId(dto.getId());
        produit.setNom(dto.getNom());
        produit.setPrix(dto.getPrix());
        produit.setCategorie(dto.getCategorie());
        return produit;
    }
}