package sk.stuba.fei.oop.implemented;

public class Place extends BaseElement {
    private int tokens;

    public Place(String name, long ID, int Token, int xPosition, int yPosition) throws IllegalArgumentValueException {
        super(name, ID,xPosition,yPosition);
        setTokens(Token);
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int token) throws IllegalArgumentValueException {
        if (token < 0) throw new IllegalArgumentValueException("Place must contain >= 0 tokens");
        this.tokens = token;
    }
}
