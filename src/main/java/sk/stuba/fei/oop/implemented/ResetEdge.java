package sk.stuba.fei.oop.implemented;
public class ResetEdge extends Edge {


    public ResetEdge(Place firstElement, Transition secondElement, long ID) {
        super(firstElement, secondElement, ID);
    }

    @Override
    public void launch() throws IllegalArgumentValueException{
        Place p;
        if (getFirstElement() instanceof Place) {
            p = (Place) getFirstElement();
            p.setTokens(0);
        }
    }

}
