package log430.Ventes.Models.DTOs;

import java.util.List;

public class VenteDTO {
    private Long id;
    private Long utilisateurId;
    private String dateVente;
    private float total;
    private List<Long> lignesVenteIds;
    private Long magasinId;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUtilisateurId() {
        return utilisateurId;
    }
    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
    public String getDateVente() {
        return dateVente;
    }
    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public List<Long> getLignesVenteIds() {
        return lignesVenteIds;
    }
    public void setLignesVenteIds(List<Long> lignesVenteIds) {
        this.lignesVenteIds = lignesVenteIds;
    }
    public Long getMagasinId() {
        return magasinId;
    }
    public void setMagasinId(Long magasinId) {
        this.magasinId = magasinId;
    }
}