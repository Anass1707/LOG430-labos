package log430.Logistique.Models.Entities.Logistique;

import jakarta.persistence.*;

@Entity
@Table(name = "stock_central")
public class StockCentral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_produit")
    private int produitId;

    private int quantite;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getProduitId() {
        return produitId;
    }
    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}