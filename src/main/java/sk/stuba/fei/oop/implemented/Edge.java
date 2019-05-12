package sk.stuba.fei.oop.implemented;

public abstract class Edge  {
    private BaseElement firstElement;
    private BaseElement secondElement;
    private final long ID;

    public Edge(BaseElement firstElement, BaseElement secondElement, long id) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        ID = id;
    }

    public long getID() {
        return ID;
    }

    public BaseElement getFirstElement() {
        return firstElement;
    }

    public BaseElement getSecondElement() {
        return secondElement;
    }

    public abstract void launch() throws IllegalArgumentValueException;

}
