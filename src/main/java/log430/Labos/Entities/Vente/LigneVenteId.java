package log430.Labos.Entities.Vente;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LigneVenteId implements Serializable {

    private Long idVente;
    private Long idProduit;

    public LigneVenteId() {
    }

    public LigneVenteId(Long idVente, Long idProduit) {
        this.idVente = idVente;
        this.idProduit = idProduit;
    }

    // Getters et Setters
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
