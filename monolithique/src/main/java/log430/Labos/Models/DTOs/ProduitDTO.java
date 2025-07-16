package src.main.java.log430.Labos.Models.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProduitDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("prix")
    private float prix;
    @JsonProperty("categorie")
    private String categorie;

    public ProduitDTO() {
    }
    
    public ProduitDTO(Long id, String nom, String categorie, float prix) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
    }

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
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}