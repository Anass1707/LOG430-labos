package log430.Logistique.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import log430.Logistique.Models.Entities.Logistique.StockCentral;

public interface StockCentralRepository extends JpaRepository<StockCentral, Long> {
StockCentral findByProduitId(long produitId);
}