package sk.stuba.fei.oop.implemented;

public class EdgeFromTransitionToPlace extends EdgeWithWeight {
    public EdgeFromTransitionToPlace(Transition firstElement, Place secondElement, int weight, long ID) throws IllegalArgumentValueException{
        super(firstElement, secondElement, weight,ID);
    }

    @Override
    public void launch() throws IllegalArgumentValueException{
        Place p;
        if (getSecondElement() instanceof Place) {
            p = (Place) getSecondElement();
            p.setTokens(p.getTokens() + getWeight());
        }
    }

}
