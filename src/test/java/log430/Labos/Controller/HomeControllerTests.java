package log430.Labos.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import log430.Labos.Entities.Utilisateur;
import log430.Labos.Repositories.UtilisateurRepository;
import log430.Labos.Services.MagasinService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTests {
    private UtilisateurRepository utilisateurRepository;
    private MagasinService magasinService;
    private HomeController helloController;

    @BeforeEach
    void setUp() {
        utilisateurRepository = mock(UtilisateurRepository.class);
        helloController = new HomeController(utilisateurRepository, mock(MagasinService.class));
        magasinService = mock(MagasinService.class);
    }


    @Test
    void testHelloWorld() {
        assertEquals("Hello, World!", helloController.helloWorld());
    }

    @Test
    void testGetAllUtilisateurs_empty() {
        when(utilisateurRepository.findAll()).thenReturn(Collections.emptyList());
        List<Utilisateur> result = helloController.getAllUtilisateurs();
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetAllUtilisateurs_nonEmpty() {
        Utilisateur u1 = new Utilisateur();
        u1.setNom("Alice");
        u1.setEmail("alice@example.com");
        Utilisateur u2 = new Utilisateur();
        u2.setNom("Bob");
        u2.setEmail("bob@example.com");
        List<Utilisateur> utilisateurs = Arrays.asList(u1, u2);

        when(utilisateurRepository.findAll()).thenReturn(utilisateurs);
        List<Utilisateur> result = helloController.getAllUtilisateurs();
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getNom());
        assertEquals("Bob", result.get(1).getNom());
    }
}
