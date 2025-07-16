package log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import log430.Labos.Models.Entities.Vente.Retour;

import java.util.List;
import java.util.Optional;

public interface RetourRepository extends JpaRepository<Retour, Long> {
    Optional<Retour> findById(Long id);
    List<Retour> findByUtilisateurId(Long id);
    List<Retour> findByDateRetour(String dateRetour);
}