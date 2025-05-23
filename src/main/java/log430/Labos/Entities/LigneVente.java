package log430.Labos.Entities;
import jakarta.persistence.*;

@Entity
@Table(name = "ligneVente")
public class LigneVente {

    @EmbeddedId
    private LigneVenteId id;

    @ManyToOne
    @MapsId("idVente")
    private Vente vente;

    @ManyToOne
    @MapsId("idProduit")
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
