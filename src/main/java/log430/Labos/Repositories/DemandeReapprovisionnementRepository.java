package log430.Labos.Repositories;

import log430.Labos.Entities.DemandeReapprovisionnement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeReapprovisionnementRepository extends JpaRepository<DemandeReapprovisionnement, Long> {
List<DemandeReapprovisionnement> findByMagasinId(long magasinId);
}