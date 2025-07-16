package log430.Labos.Models.DTOs;

public class RetourDTO {
    private Long id;
    private Long utilisateurId;
    private Long venteId;
    private String dateRetour;
    private String motif;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUtilisateurId() {
        return utilisateurId;
    }
    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
    public Long getVenteId() {
        return venteId;
    }
    public void setVenteId(Long venteId) {
        this.venteId = venteId;
    }
    public String getDateRetour() {
        return dateRetour;
    }
    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }
    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        this.motif = motif;
    }
}