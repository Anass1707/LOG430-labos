package log430.Labos.Repositories;

import log430.Labos.Entities.StockCentral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockCentralRepository extends JpaRepository<StockCentral, Long> {
StockCentral findByProduitId(long produitId);
}