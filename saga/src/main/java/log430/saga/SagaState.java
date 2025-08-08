package log430.saga;

public enum SagaState {
    STARTED,
    PRODUCT_SUCCESS,
    STORE_SUCCESS,
    LOGISTIQUE_SUCCESS,
    FAILED,
    COMPLETED,
    ERROR
}
