package log430.saga.Service;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import log430.saga.SagaContext;
import log430.saga.SagaState;
import java.util.HashMap;
import java.util.Map;

@Service
public class SagaService {

    private final RestTemplate restTemplate;
    private final EventPublisher eventPublisher;
    private final String serviceStore = "http://app:8080/api/v1/magasins";
    private final String serviceProduct = "http://app:8080/api/v1/produits";
    private final String serviceLogistique = "http://logistique-service:8080/api/v2/logistique/stockProduit";


    public SagaService(RestTemplateBuilder builder, EventPublisher eventPublisher) {
        this.restTemplate = builder.build();
        this.eventPublisher = eventPublisher;
    }

    public Map<String, Object> executeSaga(SagaContext context) {
        Map<String, Object> result = new HashMap<>();
        try {
            context.transitionTo(SagaState.STARTED);
            eventPublisher.publishEvent("SAGA_STARTED", context.getTransactionId());
            ResponseEntity<String> responseA = restTemplate.getForEntity(serviceProduct + "/1" /*context.getTransactionId()*/, String.class);
            result.put("productResponse", responseA.getBody());

            if (responseA.getStatusCode().is2xxSuccessful()) {
                eventPublisher.publishEvent("PRODUCT_SUCCESS", context.getTransactionId());
                context.transitionTo(SagaState.PRODUCT_SUCCESS);

                ResponseEntity<String> responseB = restTemplate.getForEntity(serviceStore + "/1", String.class);
                result.put("storeResponse", responseB.getBody());
                if (responseB.getStatusCode().is2xxSuccessful()) {
                    eventPublisher.publishEvent("STORE_SUCCESS", context.getTransactionId());
                    context.transitionTo(SagaState.STORE_SUCCESS);
                } else {
                    eventPublisher.publishEvent("STORE_FAILED", context.getTransactionId());
                    context.transitionTo(SagaState.FAILED);
                }
                ResponseEntity<String> responseC = restTemplate.getForEntity(serviceLogistique + "/1/20", String.class);
                result.put("logistiqueResponse", responseC.getBody());
                if (responseC.getStatusCode().is2xxSuccessful()) {
                    eventPublisher.publishEvent("LOGISTIQUE_SUCCESS", context.getTransactionId());
                    context.transitionTo(SagaState.LOGISTIQUE_SUCCESS);
                    eventPublisher.publishEvent("SAGA_SUCCESS", context.getTransactionId());
                    context.transitionTo(SagaState.COMPLETED);
                } else {
                    eventPublisher.publishEvent("LOGISTIQUE_FAILED", context.getTransactionId());
                    context.transitionTo(SagaState.FAILED);
                }
            } else {
                eventPublisher.publishEvent("PRODUCT_FAILED", context.getTransactionId());
                context.transitionTo(SagaState.FAILED);
            }
        } catch (Exception e) {
            eventPublisher.publishEvent("SAGA_ERROR", context.getTransactionId());
            context.transitionTo(SagaState.ERROR);
            System.err.println("Erreur Saga " + context.getTransactionId() + " : " + e.getMessage());
        }
        return result;
    }
}
