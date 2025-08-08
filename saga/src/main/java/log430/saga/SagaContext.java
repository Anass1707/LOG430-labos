package log430.saga;

public class SagaContext {
    private SagaState currentState;
    private String transactionId;

    public SagaContext(String transactionId) {
        this.transactionId = transactionId;
        this.currentState = SagaState.STARTED; // Initial state
    }

    public void transitionTo(SagaState newState) {
        System.out.println("Saga " + transactionId + " transition: " + currentState + " to " + newState);
        this.currentState = newState;
    }
    public SagaState getCurrentState() {
        return currentState;
    }
    public String getTransactionId() {
        return transactionId;
    }
}
