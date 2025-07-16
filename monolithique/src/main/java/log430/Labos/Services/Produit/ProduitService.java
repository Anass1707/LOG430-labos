package log430.Labos.Services.Produit;

import log430.Labos.Models.DTOs.ProduitDTO;
import log430.Labos.Models.Entities.Produit.Produit;
import log430.Labos.Models.Mappers.ProduitMapper;
import log430.Labos.Repositories.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public ProduitDTO getProduit(Long id) {
        final Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit non trouvé"));
        return ProduitMapper.toDTO(produit);
    }

    @Cacheable(value = "produits", unless = "#result == null || #result.isEmpty()")
    public List<ProduitDTO> getAllProduits() {
        return produitRepository.findAll().stream()
                .map(ProduitMapper::toDTO)
                .collect(Collectors.toList());
    }
    public ProduitDTO getProduitByNom(String nom) {
        final Produit produit = produitRepository.findByNom(nom);
        return produit != null ? ProduitMapper.toDTO(produit) : null;
    }

    public List<ProduitDTO> getProduitsByCategorie(String categorie) {
        return produitRepository.findByCategorie(categorie).stream()
                .map(ProduitMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProduitDTO addProduit(ProduitDTO produitDTO) {
        final Produit produitEntity = ProduitMapper.toEntity(produitDTO);
        final Produit createdProduit = produitRepository.save(produitEntity);
        return ProduitMapper.toDTO(createdProduit);
    }

    @Transactional
    public ProduitDTO updateProduit(Long id, ProduitDTO produitDTO) {
        final Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit non trouvé"));
        produit.setNom(produitDTO.getNom());
        produit.setCategorie(produitDTO.getCategorie());
        produit.setPrix(produitDTO.getPrix());
        return ProduitMapper.toDTO(produitRepository.save(produit));
    }

    @Transactional
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}