package log430.saga;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.support.RetryTemplate;

@SpringBootApplication
public class SagaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaApplication.class, args);
    }

	@Bean
	public ApplicationRunner runner(RabbitAdmin rabbitAdmin) {
		return args -> {
			RetryTemplate retryTemplate = RetryTemplate.builder()
				.maxAttempts(10)
				.fixedBackoff(2000)
				.build();

			retryTemplate.execute(context -> {
				rabbitAdmin.initialize();
				return null;
			});
		};
	}

}
