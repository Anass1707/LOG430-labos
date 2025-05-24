package log430.Labos.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import log430.Labos.Controller.HelloController;

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

@WebMvcTest(HelloController.class)

public class HelloControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void testHelloMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testHelloStatus() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
