package sk.stuba.fei.oop.implemented;

public class ExecutableException extends Exception {
    private String errorMessage;

    public ExecutableException(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
