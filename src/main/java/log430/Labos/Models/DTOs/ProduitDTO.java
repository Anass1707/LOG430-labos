package log430.Labos.Models.DTOs;

public class ProduitDTO {
    private Long id;
    private String nom;
    private float prix;
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