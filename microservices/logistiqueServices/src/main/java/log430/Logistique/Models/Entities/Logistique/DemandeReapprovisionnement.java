package log430.Logistique.Models.Entities.Logistique;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "demandes_reapprovisionnement")
public class DemandeReapprovisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_magasin")
    private int magasinId;

    @Column(name = "id_produit")
    private int produitId;

    private int quantiteDemandee;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_demande")
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