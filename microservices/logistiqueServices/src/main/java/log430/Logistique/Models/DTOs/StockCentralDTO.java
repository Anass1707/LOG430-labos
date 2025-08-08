package log430.Logistique.Models.DTOs;

public class StockCentralDTO {
    private Long id;
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