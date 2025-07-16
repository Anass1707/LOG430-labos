package log430.api_gateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

public class CorsGlobalConfiguration {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*")); // Autorise tous les domaines
        config.setAllowedHeaders(List.of("*")); // Autorise tous les headers
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Méthodes autorisées
        config.setExposedHeaders(List.of("Authorization")); // Headers exposés au navigateur

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Appliqué globalement

        return source;
    }
}
