package log430.Labos.Services;

import log430.Labos.Entities.Retour;
import log430.Labos.Repositories.RetourRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetourService {

    private final RetourRepository retourRepository;

    public RetourService(RetourRepository retourRepository) {
        this.retourRepository = retourRepository;
    }

    public Retour createRetour(Retour retour) {
        return retourRepository.save(retour);
    }

    public Retour getRetour(Long id) {
        return retourRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Retour non trouvé"));
    }

    public List<Retour> getAllRetours() {
        return retourRepository.findAll();
    }
}
