package log430.Labos.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/retours")
public class RetourController {

    @GetMapping("/")
    public String helloRetour() {
        return "Hello, retour!";
    }
}