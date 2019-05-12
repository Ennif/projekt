package sk.stuba.fei.oop.implemented;

public class TransitionExecutabilityException extends Throwable {
    private String message;

    public TransitionExecutabilityException(String errorMessage) {
        this.message = errorMessage;
    }

    public String getErrorMessage() {
        return message;
    }
}
