package src.main.java.log430.Labos.Models.Entities.Produit;
import jakarta.persistence.*;
import src.main.java.log430.Labos.Models.Entities.Logistique.StockCentral;
import src.main.java.log430.Labos.Models.Entities.Magasin.StockMagasin;
import src.main.java.log430.Labos.Models.Entities.Vente.LigneVente;

import java.util.List;

@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String categorie;
    private float prix;
    private int quantite;

    @OneToMany(mappedBy = "produit")
    private List<LigneVente> lignesVente;

    @OneToMany(mappedBy = "produit")
    private List<StockMagasin> stocksMagasin;

    @OneToMany(mappedBy = "produit")
    private List<StockCentral> stocksCentral;

    public Produit() {
    }

    public Produit(long id, String nom, String categorie, float prix) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public List<LigneVente> getLignesVente() {
        return lignesVente;
    }
    public void addLigneVente(LigneVente ligneVente) {
        this.lignesVente.add(ligneVente);
    }
    public void removeLigneVente(LigneVente ligneVente) {
        this.lignesVente.remove(ligneVente);
    }
    public List<StockMagasin> getStocksMagasin() {
        return stocksMagasin;
    }
    public void setStocksMagasin(List<StockMagasin> stocksMagasin) {
        this.stocksMagasin = stocksMagasin;
    }
    public List<StockCentral> getStocksCentral() {
        return stocksCentral;
    }
    public void setStocksCentral(List<StockCentral> stocksCentral) {
        this.stocksCentral = stocksCentral;
    }
}