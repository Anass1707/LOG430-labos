package log430.Labos.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import log430.Labos.Entities.DemandeReapprovisionnement;
import log430.Labos.Entities.Magasin;
import log430.Labos.Repositories.DemandeReapprovisionnementRepository;
import log430.Labos.Repositories.MagasinRepository;

@Service
public class MagasinService {
    private final MagasinRepository magasinRepository;
    private final DemandeReapprovisionnementRepository demandeRepository;

    public MagasinService(MagasinRepository magasinRepository, 
                          DemandeReapprovisionnementRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
        this.magasinRepository = magasinRepository;
    }

    public Magasin getMagasin(Long id) {
        return magasinRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Magasin non trouvé"));
    }

    public List<Magasin> getAllMagasins() {
        return magasinRepository.findAll();
    }
    public List<DemandeReapprovisionnement> getDemandesByMagasin(Long magasinId) {
    return demandeRepository.findByMagasinId(magasinId);
}
}
