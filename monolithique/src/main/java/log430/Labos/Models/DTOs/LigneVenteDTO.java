package src.main.java.log430.Labos.Models.DTOs;

public class LigneVenteDTO {
    private Long idVente;
    private Long idProduit;
    private int quantite;

    public Long getIdVente() {
        return idVente;
    }
    public void setIdVente(Long idVente) {
        this.idVente = idVente;
    }
    public Long getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}