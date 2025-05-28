package log430.Labos.Services;
import log430.Labos.Entities.Vente;
import log430.Labos.Repositories.VenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import log430.Labos.Entities.Produit;
import log430.Labos.Entities.StockMagasin;
import log430.Labos.Entities.LigneVente;
import log430.Labos.Entities.LigneVenteId;
import log430.Labos.Entities.Magasin;

import org.springframework.transaction.annotation.Transactional;

import log430.Labos.Repositories.MagasinRepository;
import log430.Labos.Repositories.ProduitRepository;
import log430.Labos.Repositories.StockMagasinRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VenteService {

    private final VenteRepository venteRepository;
    private final ProduitRepository produitRepository;
    private final MagasinRepository magasinRepository;
    private final StockMagasinRepository stockMagasinRepository;

    public VenteService(VenteRepository venteRepository, ProduitRepository produitRepository,
                        MagasinRepository magasinRepository, StockMagasinRepository stockMagasinRepository) {
        this.magasinRepository = magasinRepository;
        this.stockMagasinRepository = stockMagasinRepository;
        this.produitRepository = produitRepository;
        this.venteRepository = venteRepository;
    }

@Transactional
public Vente createVente(Vente vente) {
    float total = 0;
    if (vente.getLignesVente() != null && !vente.getLignesVente().isEmpty()) {
        final List<LigneVente> lignes = vente.getLignesVente();
        vente.setLignesVente(null);
        final Vente newVente = venteRepository.save(vente);
        for (LigneVente ligne : lignes) {
            final Produit produit = produitRepository.findById(ligne.getProduit().getId())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
    
            if (ligne.getQuantite() > produit.getQuantite()) {
                throw new IllegalArgumentException("Stock insuffisant pour le produit " + produit.getNom());
            }
    
            produit.setQuantite(produit.getQuantite() - ligne.getQuantite());
            final Produit updatedProduit = produitRepository.save(produit);
    
            final LigneVenteId id = new LigneVenteId();
            id.setIdVente(newVente.getId());
            System.out.println("produit : " + updatedProduit.getId());
            id.setIdProduit(updatedProduit.getId());
            ligne.setId(id);
            ligne.setVente(newVente);
            ligne.setProduit(updatedProduit);
            total += updatedProduit.getPrix() * ligne.getQuantite();
        }
        newVente.setLignesVente(lignes);
        newVente.setTotal(total);
        return venteRepository.save(newVente);
    }
    return null;
}

    public Vente getVente(Long id) {
        return venteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vente non trouvée"));
    }

    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }
    public Map<Magasin, List<Vente>> getVentesParMagasin() {
        final List<Magasin> magasins = magasinRepository.findAll();
        final Map<Magasin, List<Vente>> ventesParMagasin = new HashMap<>();
        System.out.println("Magasins trouvés : " + magasins.size());
        for (Magasin magasin : magasins) {
            final List<Vente> ventes = venteRepository.findByMagasin(magasin);
            System.out.println("Ventes trouvées pour le magasin " + magasin.getNom() + ": " + ventes.size());
            ventesParMagasin.put(magasin, ventes);
        }
        return ventesParMagasin;
    }
    public List<Map.Entry<Produit, Integer>> getProduitsLesPlusVendus(int limit) {
        System.out.println("Nombre de ventes : " + venteRepository.findAll().size());
        venteRepository.findAll().forEach(v -> System.out.println("Lignes vente : " + v.getLignesVente().size()));
        return venteRepository.findAll().stream()
            .filter(vente -> vente.getLignesVente() != null)
            .flatMap(vente -> vente.getLignesVente().stream())
            .collect(Collectors.groupingBy(LigneVente::getProduit, Collectors.summingInt(LigneVente::getQuantite)))
            .entrySet().stream()
            .sorted((e1, e2) -> e2.getValue() - e1.getValue())
            //.limit(limit)
            .collect(Collectors.toList());
    }
    public Map<Magasin, List<StockMagasin>> getStocksRestantsParMagasin() {
        final List<Magasin> magasins = magasinRepository.findAll();
        final Map<Magasin, List<StockMagasin>> stocksParMagasin = new HashMap<>();
        for (Magasin magasin : magasins) {
            final List<StockMagasin> stocks = stockMagasinRepository.findByMagasin(magasin);
            System.out.println("Stocks trouvés pour le magasin " + magasin.getNom() + ": " + stocks.size());
            stocksParMagasin.put(magasin, stocks);
        }
        return stocksParMagasin;
    }
}
