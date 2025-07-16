package log430.Labos.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import log430.Labos.Models.Entities.Utilisateur.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByNom(String nom);
    Optional<Utilisateur> findById(Long id);
}