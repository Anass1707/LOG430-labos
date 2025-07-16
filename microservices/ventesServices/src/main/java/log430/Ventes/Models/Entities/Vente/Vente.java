package src.main.java.log430.Ventes.Models.Entities.Vente;
import jakarta.persistence.*;
import src.main.java.log430.Ventes.Models.Entities.Magasin.Magasin;
import src.main.java.log430.Ventes.Models.Entities.Utilisateur.Utilisateur;

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

    @Column(name = "date_vente")
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
    public void setId(Long id) {
        this.id = id;
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
