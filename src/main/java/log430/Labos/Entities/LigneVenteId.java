package log430.Labos.Entities;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LigneVenteId implements Serializable {

    private Integer idVente;
    private Integer idProduit;

    public LigneVenteId() {
    }

    public LigneVenteId(Integer idVente, Integer idProduit) {
        this.idVente = idVente;
        this.idProduit = idProduit;
    }

    // Getters et Setters
    public Integer getIdVente() {
        return idVente;
    }
    public void setIdVente(Integer idVente) {
        this.idVente = idVente;
    }
    public Integer getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    // equals() et hashCode() requis pour une clé composite
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneVenteId)) return false;
        final LigneVenteId lv = (LigneVenteId) o;
        return Objects.equals(getIdVente(), lv.getIdVente()) &&
               Objects.equals(getIdProduit(), lv.getIdProduit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdVente(), getIdProduit());
    }
}
