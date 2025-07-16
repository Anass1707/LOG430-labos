package log430.Ventes.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import log430.Ventes.Models.Entities.Vente.LigneVente;

import java.util.List;
import java.util.Optional;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Long> {
    Optional<LigneVente> findById(Long id);
    List<LigneVente> findByVenteId(Long id);
}