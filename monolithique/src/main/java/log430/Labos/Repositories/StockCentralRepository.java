package src.main.java.log430.Labos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.log430.Labos.Models.Entities.Logistique.StockCentral;

public interface StockCentralRepository extends JpaRepository<StockCentral, Long> {
StockCentral findByProduitId(long produitId);
}