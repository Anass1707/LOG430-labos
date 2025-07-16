package log430.Ventes.Models.Entities.Vente;
import jakarta.persistence.*;
import log430.Ventes.Models.Entities.Produit.Produit;

@Entity
@Table(name = "ligne_vente")
public class LigneVente {

    @EmbeddedId
    private LigneVenteId id;

    @ManyToOne
    @MapsId("idVente")
    @JoinColumn(name = "id_vente")
    private Vente vente;

    @ManyToOne
    @MapsId("idProduit")
    @JoinColumn(name = "id_produit")
    private Produit produit;

    private int quantite;

    // Getters et Setters
    public LigneVenteId getId() {
        return id;
    }

    public void setId(LigneVenteId id) {
        this.id = id;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
