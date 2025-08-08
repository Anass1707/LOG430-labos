package log430.Logistique;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LogistiqueApplication {
 public static void main(String[] args) {
	SpringApplication.run(LogistiqueApplication.class, args);
 }
}
