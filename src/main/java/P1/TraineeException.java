package P1;

public class TraineeException extends Throwable {
    private TraineeErrorCode errorCode;

    public TraineeErrorCode getErrorCode() {
        return errorCode;
    }

    public TraineeException(TraineeErrorCode errorCode) {

        this.errorCode = errorCode;
    }
}
