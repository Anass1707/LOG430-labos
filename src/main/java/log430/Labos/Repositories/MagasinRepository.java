package log430.Labos.Repositories;

import log430.Labos.Entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
}