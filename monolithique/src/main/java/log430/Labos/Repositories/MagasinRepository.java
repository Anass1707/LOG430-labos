package log430.Labos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import log430.Labos.Models.Entities.Magasin.Magasin;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {
}