package src.main.java.log430.Labos.Repositories;

import src.main.java.log430.Labos.Models.Entities.Magasin.Magasin;
import src.main.java.log430.Labos.Models.Entities.Magasin.StockMagasin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMagasinRepository extends JpaRepository<StockMagasin, Long> {
    List<StockMagasin> findByMagasin(Magasin magasin);
}