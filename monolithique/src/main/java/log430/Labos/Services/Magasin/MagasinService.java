package log430.Labos.Services.Magasin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import log430.Labos.Models.DTOs.MagasinDTO;
import log430.Labos.Models.DTOs.StockMagasinDTO;
import log430.Labos.Models.Entities.Magasin.Magasin;
import log430.Labos.Models.Entities.Magasin.StockMagasin;
import log430.Labos.Models.Mappers.MagasinMapper;
import log430.Labos.Models.Mappers.StockMagasinMapper;
import log430.Labos.Repositories.MagasinRepository;
import log430.Labos.Repositories.StockMagasinRepository;

@Service
public class MagasinService {
    private final MagasinRepository magasinRepository;
    private final StockMagasinRepository stockMagasinRepository;

    public MagasinService(MagasinRepository magasinRepository,
                          StockMagasinRepository stockMagasinRepository) {
        this.stockMagasinRepository = stockMagasinRepository;
        this.magasinRepository = magasinRepository;
    }

    public MagasinDTO getMagasin(Long id) {
        return magasinRepository.findById(id)
            .map(magasin -> MagasinMapper.toDTO(magasin))
            .orElseThrow(() -> new EntityNotFoundException("Magasin non trouvé pour l'ID: " + id));
    }

    public List<MagasinDTO> getAllMagasins() {
        return magasinRepository.findAll().stream()
            .map(MagasinMapper::toDTO)
            .toList();
    }

    public List<Map<String, Object>> getDashboard() {
        final List<Map<String, Object>> result = new ArrayList<>();
        final LocalDate today = LocalDate.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 

        for (Magasin magasin : magasinRepository.findAll()) {
            final Map<String, Object> indicateurs = new HashMap<>();
            indicateurs.put("magasin", magasin);

            double chiffreAffaires = 0.0;
            final List<Map<String, Object>> tendances = new ArrayList<>();
            if (magasin.getVentes() != null) {
                // Chiffre d'affaires total
                chiffreAffaires = magasin.getVentes().stream()
                        .mapToDouble(vente -> vente.getTotal())
                        .sum();

                for (int i = 6; i >= 0; i--) {
                    final LocalDate day = today.minusDays(i);
                    final int ventesJour = (int) magasin.getVentes().stream()
                        .filter(vente -> {
                            final LocalDate dateVente = LocalDate.parse(vente.getDateVente(), formatter);
                            return dateVente.equals(day);
                        })
                        .count();
                        final Map<String, Object> tendanceJour = new HashMap<>();
                        tendanceJour.put("jour", day);
                        tendanceJour.put("ventes", ventesJour);
                        tendances.add(tendanceJour);
                }
            } else {
                System.out.println("Aucune vente pour le magasin " + magasin.getNom());
                for (int i = 0; i < 7; i++) {
                    final Map<String, Object> tendanceJour = new HashMap<>();
                    tendanceJour.put("jour", today.minusDays(6 - i));
                    tendanceJour.put("ventes", 0);
                    tendances.add(tendanceJour);
                }
            }

            // Ruptures de stock et surstocks
            final List<StockMagasin> ruptures = new ArrayList<>();
            final List<StockMagasin> surstocks = new ArrayList<>();
            for (StockMagasin stock : magasin.getStocks()) {
                if (stock.getQuantite() < stock.getMinimumStock()) {
                    ruptures.add(stock);
                }
                if (stock.getQuantite() > 10 * stock.getMinimumStock()) {
                    surstocks.add(stock);
                }
            }
            indicateurs.put("ruptures", ruptures);
            indicateurs.put("surstocks", surstocks);
            indicateurs.put("tendances", tendances);
            indicateurs.put("chiffreAffaires", chiffreAffaires);
            result.add(indicateurs);
        }
        return result;
    }

    public Map<MagasinDTO, List<StockMagasinDTO>> getStocksRestantsParMagasin() {
        final List<Magasin> magasins = magasinRepository.findAll();
        final Map<MagasinDTO, List<StockMagasinDTO>> stocksParMagasin = new HashMap<>();
        for (Magasin magasin : magasins) {
            final List<StockMagasinDTO> stocks = stockMagasinRepository.findByMagasin(magasin)
            .stream().map(StockMagasinMapper::toDTO)
            .toList();
            System.out.println("Stocks trouvés pour le magasin " + magasin.getNom() + ": " + stocks.size());
            final MagasinDTO magasinDTO = MagasinMapper.toDTO(magasin);
            stocksParMagasin.put(magasinDTO, stocks);
        }
        return stocksParMagasin;
    }
}
