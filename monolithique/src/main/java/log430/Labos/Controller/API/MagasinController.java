package log430.Labos.Controller.API;

import log430.Labos.Models.DTOs.MagasinDTO;
import log430.Labos.Services.Magasin.MagasinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/magasins")
public class MagasinController {

    private final MagasinService magasinService;
    
    public MagasinController(MagasinService magasinService) {
        this.magasinService = magasinService;
    }
    @GetMapping
    public ResponseEntity<List<MagasinDTO>> getAllMagasins() {
        final List<MagasinDTO> magasins = magasinService.getAllMagasins()
            .stream()
            .collect(Collectors.toList());
        return ResponseEntity.ok(magasins);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MagasinDTO> getMagasinById(@PathVariable Long id) {
        final MagasinDTO magasin = magasinService.getMagasin(id);
        if (magasin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(magasin);
    }
}
