package log430.Labos.Repositories;

import log430.Labos.Models.Entities.Magasin.Magasin;
import log430.Labos.Models.Entities.Magasin.StockMagasin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMagasinRepository extends JpaRepository<StockMagasin, Long> {
    List<StockMagasin> findByMagasin(Magasin magasin);
}