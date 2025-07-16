package src.main.java.log430.Ventes.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.log430.Ventes.Models.Entities.Logistique.DemandeReapprovisionnement;

public interface DemandeReapprovisionnementRepository extends JpaRepository<DemandeReapprovisionnement, Long> {
List<DemandeReapprovisionnement> findByMagasinId(long magasinId);
}