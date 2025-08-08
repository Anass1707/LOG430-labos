package log430.saga.Controller;

import java.util.UUID;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import log430.saga.SagaContext;
import log430.saga.Service.SagaService;
import java.util.Map;

@RestController
@RequestMapping("saga")
public class SagaController {
        private final SagaService sagaService;

    public SagaController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @GetMapping("/start")
    public ResponseEntity<Map<String, Object>> startSaga() {
        SagaContext context = new SagaContext(UUID.randomUUID().toString());
        Map<String, Object> rep = sagaService.executeSaga(context);
        return ResponseEntity.ok(rep);
    }

}
