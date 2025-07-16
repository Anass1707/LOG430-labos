package log430.Ventes.Models.DTOs;

public class StockMagasinDTO {
    private Long id;
    private Long magasinId;
    private Long produitId;
    private int minimumStock;
    private int quantite;
    public StockMagasinDTO() {
    }
    public StockMagasinDTO(Long id, Long magasinId, Long produitId, int minimumStock, int quantite) {
        this.id = id;
        this.magasinId = magasinId;
        this.produitId = produitId;
        this.minimumStock = minimumStock;
        this.quantite = quantite;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getMagasinId() {
        return magasinId;
    }
    public void setMagasinId(Long magasinId) {
        this.magasinId = magasinId;
    }
    public Long getProduitId() {
        return produitId;
    }
    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
    public int getMinimumStock() {
        return minimumStock;
    }
    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}