package log430.Ventes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import log430.Ventes.Models.Entities.Logistique.StockCentral;

public interface StockCentralRepository extends JpaRepository<StockCentral, Long> {
StockCentral findByProduitId(long produitId);
}