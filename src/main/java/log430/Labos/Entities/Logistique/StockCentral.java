package log430.Labos.Entities.Logistique;

import jakarta.persistence.*;
import log430.Labos.Entities.Produit.Produit;

@Entity
@Table(name = "stock_central")
public class StockCentral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    private int quantite;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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