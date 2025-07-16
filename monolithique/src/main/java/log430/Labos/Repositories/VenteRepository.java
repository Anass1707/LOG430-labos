package src.main.java.log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import src.main.java.log430.Labos.Models.Entities.Magasin.Magasin;
import src.main.java.log430.Labos.Models.Entities.Vente.Vente;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente, Long> {
    Optional<Vente> findById(Long id);
    List<Vente> findByUtilisateurId(Long id);
    List<Vente> findByDateVente(String dateVente);
    List<Vente> findByMagasin(Magasin magasin);
}