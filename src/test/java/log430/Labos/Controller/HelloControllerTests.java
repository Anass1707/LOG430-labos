package log430.Labos.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import log430.Labos.Controller.HelloController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)

public class HelloControllerTests {
    @Autowired
    private MockMvc mockMvc;

    // 🔹 Test du contenu de la réponse
    @Test
    public void testHelloMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(content().string("Hello, World!"));
    }

    // 🔹 Test du code HTTP (statut 200 OK)
    @Test
    public void testHelloStatus() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
