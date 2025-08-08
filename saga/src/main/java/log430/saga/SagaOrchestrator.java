package log430.saga;

public class SagaOrchestrator {

    public void startSaga(String transactionId) {
        SagaContext context = new SagaContext(transactionId);
        context.transitionTo(SagaState.STARTED);

        if (callProductService(context)) {
            context.transitionTo(SagaState.PRODUCT_SUCCESS);
        } else {
            context.transitionTo(SagaState.FAILED);
            return;
        }

        if (callStoreService(context)) {
            context.transitionTo(SagaState.STORE_SUCCESS);
        } else {
            context.transitionTo(SagaState.FAILED);
            return;
        }

        if (callLogistiqueService(context)) {
            context.transitionTo(SagaState.LOGISTIQUE_SUCCESS);
            context.transitionTo(SagaState.COMPLETED);
        } else {
            context.transitionTo(SagaState.FAILED);
        }
    }

    private boolean callProductService(SagaContext context) {
        System.out.println("Calling service product for transaction " + context.getTransactionId());
        return true;
    }

    private boolean callLogistiqueService(SagaContext context) {
        System.out.println("Calling service logistique for transaction " + context.getTransactionId());
        return true;
    }

    private boolean callStoreService(SagaContext context) {
        System.out.println("Calling service store for transaction " + context.getTransactionId());
        return true;
    }
}