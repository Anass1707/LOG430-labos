package log430.Logistique.Controller.API.Logistique;

import log430.Logistique.Models.DTOs.StockCentralDTO;
import log430.Logistique.Services.Logistique.LogistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/logistique")
public class LogistiqueController {

    private final LogistiqueService logistiqueService;

    @Autowired
    public LogistiqueController(LogistiqueService logistiqueService) {
        this.logistiqueService = logistiqueService;
    }
    @GetMapping("/stockProduit/{idProduct}/{quantity}")
    public ResponseEntity<StockCentralDTO> getStockById(@PathVariable int idProduct, @PathVariable int quantity) {
        final StockCentralDTO stock = logistiqueService.getStockById(idProduct, quantity);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } 
    @PutMapping("/stock/{idProduct}/{quantity}")
    public ResponseEntity<StockCentralDTO> updateStock(@PathVariable int idProduct, @PathVariable int quantity) {
        final StockCentralDTO updatedStock = logistiqueService.updateStock(idProduct, quantity);
        if (updatedStock != null) {
            return ResponseEntity.ok(updatedStock);
        } else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}