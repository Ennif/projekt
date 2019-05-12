package sk.stuba.fei.oop.implemented;



import java.util.List;

public abstract class BaseElement {
    private final String name;
    private final long ID;
    private int xPosition;
    private int yPosition;
    protected BaseElement(String name, long ID, int xPosition, int yPosition) {
        if ((name == null || name.length() == 0) && (ID <= 0)) {
            throw new IllegalArgumentException("Name must be used and ID must be > 0 ");
        }
        this.name = name;
        this.ID = ID;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
