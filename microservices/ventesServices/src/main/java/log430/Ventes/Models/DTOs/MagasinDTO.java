package log430.Ventes.Models.DTOs;

public class MagasinDTO {

    private Long id;
    private String nom;
    private String adresse;
    
    public MagasinDTO() {
    }
    public MagasinDTO(Long id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
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
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}