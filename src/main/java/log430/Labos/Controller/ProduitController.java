package log430.Labos.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @GetMapping("/")
    public String helloProduit() {
        return "Hello, produit!";
    }
}