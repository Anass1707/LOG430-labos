package log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import log430.Labos.Entities.Produit;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findById(Long id);
    Produit findByNom(String nom);
    List<Produit> findByQuantite(Integer quantite);
    List<Produit> findByCategorie(String categorie);
}