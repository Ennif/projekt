package sk.stuba.fei.oop.implemented;

public class ElementDoesNotExistException extends Exception {
    private String message;

    public ElementDoesNotExistException(String errorMessage) {
        this.message = errorMessage;
    }

    public String getErrorMessage() {
        return message;
    }
}
