package log430.Logistique.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import log430.Logistique.Models.Entities.Logistique.DemandeReapprovisionnement;

public interface DemandeReapprovisionnementRepository extends JpaRepository<DemandeReapprovisionnement, Long> {
List<DemandeReapprovisionnement> findByMagasinId(long magasinId);
}