package log430.Ventes.Models.Entities.Logistique;

import jakarta.persistence.*;
import log430.Ventes.Models.Entities.Magasin.Magasin;
import log430.Ventes.Models.Entities.Produit.Produit;

import java.util.Date;

@Entity
@Table(name = "demandes_reapprovisionnement")
public class DemandeReapprovisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_magasin")
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

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
    public Magasin getMagasin() {
        return magasin;
    }
    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
    public Produit getProduit() {
        return produit;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
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