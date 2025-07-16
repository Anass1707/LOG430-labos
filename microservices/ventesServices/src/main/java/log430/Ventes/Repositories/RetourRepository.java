package src.main.java.log430.Ventes.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.log430.Ventes.Models.Entities.Vente.Retour;

import java.util.List;
import java.util.Optional;

public interface RetourRepository extends JpaRepository<Retour, Long> {
    Optional<Retour> findById(Long id);
    List<Retour> findByUtilisateurId(Long id);
    List<Retour> findByDateRetour(String dateRetour);
}