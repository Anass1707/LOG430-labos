package src.main.java.log430.Ventes.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.log430.Ventes.Models.Entities.Utilisateur.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByNom(String nom);
    Optional<Utilisateur> findById(Long id);
}