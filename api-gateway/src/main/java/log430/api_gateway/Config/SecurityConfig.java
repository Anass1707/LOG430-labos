package log430.api_gateway.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable) // Désactive CSRF (utile pour API REST)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(
                            "/api/v1/produits/swagger-ui.html", "/api/v1/produits/v3/api-docs/**",
                            "api/v2/ventes/swagger-ui.html", "api/v2/ventes/v3/api-docs/**"
                        ).permitAll()
                        .anyExchange().permitAll() // Tu peux remplacer par .authenticated() si tu veux protéger
                )
                .cors(Customizer.withDefaults()) // Active CORS
                .build();
    }
}
