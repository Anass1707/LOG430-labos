package log430.Labos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LabosApplication {
public static void main(String[] args) {
	SpringApplication.run(LabosApplication.class, args);
 }
}