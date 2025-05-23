package log430.Labos.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ventes")
public class VenteController {

    @GetMapping("/")
    public String helloVente() {
        return "Hello, vente!";
    }
}