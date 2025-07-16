package src.main.java.log430.Ventes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.log430.Ventes.Models.Entities.Magasin.Magasin;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
}