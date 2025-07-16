package log430.Ventes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VentesApplication {
 public static void main(String[] args) {
	SpringApplication.run(VentesApplication.class, args);
 }
}
