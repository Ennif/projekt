package sk.stuba.fei.oop.implemented;

 public class IllegalArgumentValueException extends Exception {
    String message;
    public IllegalArgumentValueException(String errorMessage) {
        this.message = errorMessage;
    }
    public String getMessage(){
        return message;
    }
}
