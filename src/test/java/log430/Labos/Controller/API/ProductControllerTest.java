package log430.Labos.Controller.API;

import com.fasterxml.jackson.databind.ObjectMapper;

import log430.Labos.Controller.API.Produit.ProductController;
import log430.Labos.Models.DTOs.ProduitDTO;
import log430.Labos.Models.Entities.Produit.Produit;
import log430.Labos.Models.Mappers.ProduitMapper;
import log430.Labos.Services.Produit.ProduitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduitService produitService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /api/v1/produits - OK")
    void testGetAllProduits() throws Exception {
        Produit p = new Produit(1,"Casque", "Électronique", 2.5f);
        Mockito.when(produitService.getAllProduits()).thenReturn(List.of(p));

        mockMvc.perform(get("/api/v1/produits"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nom").value("Casque"));
    }

    @Test
    @DisplayName("GET /api/v1/produits/{id} - OK")
    void testGetProduitById_found() throws Exception {
        Produit p = new Produit(1,"Casque", "Électronique", 2.5f);
        Mockito.when(produitService.getProduit(1L)).thenReturn(p);

        mockMvc.perform(get("/api/v1/produits/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nom").value("Casque"));
    }

    @Test
    @DisplayName("GET /api/v1/produits/{id} - NOT FOUND")
    void testGetProduitById_notFound() throws Exception {
        Mockito.when(produitService.getProduit(99L)).thenReturn(null);

        mockMvc.perform(get("/api/v1/produits/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/v1/produits/nom?nom=Casque - OK")
    void testGetProduitByNom() throws Exception {
        Produit p = new Produit(1,"Casque", "Électronique", 2.5f);
        Mockito.when(produitService.getProduitByNom("Casque")).thenReturn(p);

        mockMvc.perform(get("/api/v1/produits/nom").param("nom", "Casque"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.categorie").value("Électronique"));
    }

    @Test
    @DisplayName("POST /api/v1/produits - Created")
    void testAddProduit() throws Exception {
        ProduitDTO dto = new ProduitDTO(1L, "Casque", "Électronique", 2.5f);
        Produit created = new Produit(1,"Casque", "Électronique", 2.5f);

        Mockito.when(produitService.addProduit(any())).thenReturn(created);

        mockMvc.perform(post("/api/v1/produits")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.nom").value("Casque"));
    }

    @Test
    @DisplayName("PUT /api/v1/produits/{id} - OK")
    void testUpdateProduit() throws Exception {
        ProduitDTO dto = new ProduitDTO(1L, "Casque", "Électronique", 2.5f);
        Produit updated =  new Produit(1,"Casque", "Électronique", 20.5f);

        Mockito.when(produitService.updateProduit(eq(2L), any())).thenReturn(updated);

        mockMvc.perform(put("/api/v1/produits/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nom").value("Casque"));
    }

    @Test
    @DisplayName("PUT /api/v1/produits/{id} - NOT FOUND")
    void testUpdateProduit_notFound() throws Exception {
        ProduitDTO dto = new ProduitDTO(1L, "Micro", "Électronique", 20.5f);

        Mockito.when(produitService.updateProduit(eq(100L), any())).thenReturn(null);

        mockMvc.perform(put("/api/v1/produits/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isNotFound());
    }
}
