package log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import log430.Labos.Entities.Vente;
import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente, Long> {
    Optional<Vente> findById(Long id);
    List<Vente> findByUtilisateurId(Long id);
    List<Vente> findByDateVente(String dateVente);
    Vente save(Vente vente);
}