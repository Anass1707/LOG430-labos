package log430.Ventes.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import log430.Ventes.Models.Entities.Produit.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findById(Long id);
    Produit findByNom(String nom);
    List<Produit> findByQuantite(Integer quantite);
    List<Produit> findByCategorie(String categorie);
}