package log430.Logistique.Models.DTOs;

import java.util.Date;

public class DemandeReapprovisionnementDTO {
    private Long id;
    private int magasinId;
    private int produitId;
    private int quantiteDemandee;
    private Date dateDemande;
    private String statut;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getMagasinId() {
        return magasinId;
    }
    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }
    public int getProduitId() {
        return produitId;
    }
    public void setProduitId(int produitId) {
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