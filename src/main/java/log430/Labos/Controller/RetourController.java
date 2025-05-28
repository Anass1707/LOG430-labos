package log430.Labos.Controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import log430.Labos.Entities.Retour;
import log430.Labos.Services.RetourService;

@Controller
@RequestMapping("/retours")
public class RetourController {
    private final RetourService retourService;

    public RetourController(RetourService retourService) {
        this.retourService = retourService;
    }
}