package log430.Labos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import log430.Labos.Entities.Logistique.StockCentral;

public interface StockCentralRepository extends JpaRepository<StockCentral, Long> {
StockCentral findByProduitId(long produitId);
}