package src.main.java.log430.Ventes.Models.Entities.Magasin;

import jakarta.persistence.*;
import src.main.java.log430.Ventes.Models.Entities.Vente.Vente;

import java.util.List;

@Entity
@Table(name = "magasins")
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "magasin")
    private List<Vente> ventes;

    @OneToMany(mappedBy = "magasin")
    private List<StockMagasin> stocks;

    // getters/setters
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
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public List<Vente> getVentes() {
        return ventes;
    }
    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
    public List<StockMagasin> getStocks() {
        return stocks;
    }
    public void setStocks(List<StockMagasin> stocks) {
        this.stocks = stocks;
    }
}