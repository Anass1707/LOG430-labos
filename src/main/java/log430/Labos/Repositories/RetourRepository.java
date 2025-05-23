package log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import log430.Labos.Entities.Retour;
import java.util.Optional;

public interface RetourRepository extends JpaRepository<Retour, Long> {
    Optional<Retour> findById(Long id);
    List<Retour> findByUtilisateurId(Long id);
    List<Retour> findByDateRetour(String dateRetour);
    Retour save(Retour retour);
}