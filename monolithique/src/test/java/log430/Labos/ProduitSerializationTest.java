package log430.Labos;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import log430.Labos.Models.DTOs.ProduitDTO;
import log430.Labos.Models.Entities.Produit.Produit;

public class ProduitSerializationTest {
     @Test
    public void testProduitSerialization() throws Exception {
        Produit produit = new Produit();
        produit.setId(1L);
        produit.setNom("Produit Test");
        produit.setCategorie("Catégorie Test");
        produit.setPrix(10.0f);
        produit.setQuantite(100);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(produit);
        
        assertNotNull(json);
        System.out.println(json);
        ObjectMapper om = new ObjectMapper();
        ProduitDTO p = new ProduitDTO();
        p.setId(1L);
        p.setNom("Produit Test");
        p.setPrix(10.0f);

        // Sérialisation
        String j = om.writeValueAsString(p);
        System.out.println("Sérialisé : " + j);

        // Désérialisation
        ProduitDTO deserializedProduit = om.readValue(j, ProduitDTO.class);
        System.out.println("Désérialisé : " + deserializedProduit.getNom());

            assertNotNull(j);
            System.out.println("Produit sérialisé : " + j);

            ProduitDTO produitDTO = om.readValue(j, ProduitDTO.class);
            assertNotNull(produitDTO);
            System.out.println("Produit désérialisé : " + produitDTO.getNom());

        }   
}