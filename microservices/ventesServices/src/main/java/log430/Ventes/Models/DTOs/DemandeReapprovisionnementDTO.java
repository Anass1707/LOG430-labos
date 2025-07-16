package log430.Ventes.Models.DTOs;

import java.util.Date;

public class DemandeReapprovisionnementDTO {
    private Long id;
    private Long magasinId;
    private Long produitId;
    private int quantiteDemandee;
    private Date dateDemande;
    private String statut;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getMagasinId() {
        return magasinId;
    }
    public void setMagasinId(Long magasinId) {
        this.magasinId = magasinId;
    }
    public Long getProduitId() {
        return produitId;
    }
    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
    public int getQuantiteDemandee() {
        return quantiteDemandee;
    }
    public void setQuantiteDemandee(int quantiteDemandee) {
        this.quantiteDemandee = quantiteDemandee;
    }
    public Date getDateDemande() {
        return dateDemande;
    }
    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
}