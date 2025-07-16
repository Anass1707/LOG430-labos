package src.main.java.log430.Ventes.Controller.API.Vente;

import src.main.java.log430.Ventes.Models.DTOs.VenteDTO;
import src.main.java.log430.Ventes.Services.Vente.VenteService;
import src.main.java.log430.Ventes.Models.Mappers.VenteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/ventes")
public class VenteController {

    private final VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @PostMapping
    public ResponseEntity<VenteDTO> createVente(@RequestBody VenteDTO venteDTO) {
        return ResponseEntity.ok(venteService.createVente(venteDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenteDTO> getVente(@PathVariable Long id) {
        return ResponseEntity.ok(venteService.getVente(id));
    }

    @GetMapping
    public ResponseEntity<List<VenteDTO>> getAllVentes() {
        return ResponseEntity.ok(venteService.getAllVentes());
    }
}