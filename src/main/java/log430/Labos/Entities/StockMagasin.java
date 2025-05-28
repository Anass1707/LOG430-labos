package log430.Labos.Entities;

import jakarta.persistence.*;

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
}