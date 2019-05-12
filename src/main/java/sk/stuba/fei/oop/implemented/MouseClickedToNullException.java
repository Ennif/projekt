package sk.stuba.fei.oop.implemented;

public class MouseClickedToNullException extends Exception {
    private String eMessage;
    public MouseClickedToNullException(String eMessage){
        this.eMessage = eMessage;
    }

    public String geteMessage() {
        return eMessage;
    }
}
