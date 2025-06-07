package log430.Labos.Entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventes")
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    private String dateVente;
    private float total;

    @OneToMany(mappedBy = "vente", fetch = FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneVente> lignesVente  = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_magasin")
    private Magasin magasin;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<LigneVente> getLignesVente() {
        return lignesVente;
    }

    public void setLignesVente(List<LigneVente> lignesVente) {
        this.lignesVente = lignesVente;
    }
    public void addLigneVente(LigneVente ligneVente) {
        this.lignesVente.add(ligneVente);
    }
    public void removeLigneVente(LigneVente ligneVente) {
        this.lignesVente.remove(ligneVente);
    }
}
