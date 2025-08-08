package log430.saga.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public EventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishEvent(String eventType, String transactionId) {
        Map<String, String> event = new HashMap<>();
        event.put("type", eventType);
        event.put("transactionId", transactionId);

        rabbitTemplate.convertAndSend("saga-exchange", "key", event);
        System.out.println("Événement publié : " + eventType);
    }
}
