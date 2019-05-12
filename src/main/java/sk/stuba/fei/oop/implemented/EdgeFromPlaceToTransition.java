package sk.stuba.fei.oop.implemented;

public class EdgeFromPlaceToTransition extends EdgeWithWeight {


    public EdgeFromPlaceToTransition(Place firstElement, Transition secondElement, int weight, long ID) throws IllegalArgumentValueException{
        super(firstElement, secondElement, weight,ID);
    }


    @Override
    public void launch() throws IllegalArgumentValueException{
        Place p;

        if (getFirstElement() instanceof Place) {
            p = (Place) getFirstElement();
            p.setTokens(p.getTokens() - getWeight());
        }
    }


    public void check() throws ExecutableException {
        Place p;

        if (getFirstElement() instanceof Place) {
            p = (Place) getFirstElement();

            if (p.getTokens() < getWeight())
                throw new ExecutableException("Transition is not executable");
        }
    }


}

