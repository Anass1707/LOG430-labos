package src.main.java.log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.log430.Labos.Models.Entities.Vente.LigneVente;

import java.util.List;
import java.util.Optional;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Long> {
    Optional<LigneVente> findById(Long id);
    List<LigneVente> findByVenteId(Long id);
}