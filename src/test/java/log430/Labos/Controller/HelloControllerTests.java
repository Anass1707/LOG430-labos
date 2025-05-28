package log430.Labos.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import log430.Labos.Controller.HelloController;
import log430.Labos.Entities.Utilisateur;
import log430.Labos.Repositories.UtilisateurRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloControllerTests {
    private UtilisateurRepository utilisateurRepository;
    private HelloController helloController;

    @BeforeEach
    void setUp() {
        utilisateurRepository = mock(UtilisateurRepository.class);
        helloController = new HelloController(utilisateurRepository);
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
