package log430.Labos.Services;
import log430.Labos.Entities.Vente;
import log430.Labos.Repositories.VenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {

    private final VenteRepository venteRepository;

    public VenteService(VenteRepository venteRepository) {
        this.venteRepository = venteRepository;
    }

    public Vente createVente(Vente vente) {
        return venteRepository.save(vente);
    }

    public Vente getVente(Long id) {
        return venteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vente non trouvée"));
    }

    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }
}
