package log430.Labos.Models.Entities.Magasin;

import jakarta.persistence.*;
import log430.Labos.Models.Entities.Produit.Produit;

@Entity
@Table(name = "stock_magasin")
public class StockMagasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_magasin")
    private Magasin magasin;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    private int minimum_stock;
    private int quantite;

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
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public int getMinimumStock() {
        return minimum_stock;
    }
    public void setMinimumStock(int minimum_stock) {
        this.minimum_stock = minimum_stock;
    }
}