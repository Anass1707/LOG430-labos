package log430.Labos.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import log430.Labos.Entities.Retour;
import log430.Labos.Services.RetourService;

@RestController
@RequestMapping("/retours")
public class RetourController {
    private final RetourService retourService;

    public RetourController(RetourService retourService) {
        this.retourService = retourService;
    }

    @PostMapping
    public Retour effectuerRetour(@RequestBody Retour retour) {
        return retourService.effectuerRetour(retour);
    }

    @GetMapping("/{id}")
    public Retour getRetour(@PathVariable Long id) {
        return retourService.getRetour(id);
    }
    @GetMapping("/")
    public List<Retour> getAllRetours() {
        return retourService.getAllRetours();
    }
}