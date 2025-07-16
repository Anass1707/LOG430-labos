package src.main.java.log430.Labos.Models.Entities.Utilisateur;
import jakarta.persistence.*;
import src.main.java.log430.Labos.Models.Entities.Vente.Retour;
import src.main.java.log430.Labos.Models.Entities.Vente.Vente;

import java.util.List;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @OneToMany(mappedBy = "utilisateur")
    private List<Vente> ventes;

    @OneToMany(mappedBy = "utilisateur")
    private List<Retour> retours;

    // Getters et Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
    public List<Retour> getRetours() {
        return retours;
    }

    public void setRetours(List<Retour> retours) {
        this.retours = retours;
    }
    
}