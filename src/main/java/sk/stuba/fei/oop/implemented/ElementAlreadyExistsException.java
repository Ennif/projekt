package sk.stuba.fei.oop.implemented;

public class ElementAlreadyExistsException extends Exception {

    public ElementAlreadyExistsException(long ID) {
    }

    public ElementAlreadyExistsException(String message) {
        super(message);
    }

    public void getIdMessage(long ID) {
        System.out.println("Chosen ID " + ID + " already exists");
    }
}
