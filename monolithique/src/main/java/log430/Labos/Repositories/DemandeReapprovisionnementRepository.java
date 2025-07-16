package log430.Labos.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import log430.Labos.Models.Entities.Logistique.DemandeReapprovisionnement;

public interface DemandeReapprovisionnementRepository extends JpaRepository<DemandeReapprovisionnement, Long> {
List<DemandeReapprovisionnement> findByMagasinId(long magasinId);
}