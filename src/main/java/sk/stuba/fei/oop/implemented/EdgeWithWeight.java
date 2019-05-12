package sk.stuba.fei.oop.implemented;

public abstract class EdgeWithWeight extends Edge {
    private int weight;

    public EdgeWithWeight( BaseElement firstElement, BaseElement secondElement, int weight, long ID) throws IllegalArgumentValueException {
        super(firstElement, secondElement, ID);
        setWeight(weight);
    }


    public void setWeight(int weight) throws IllegalArgumentValueException {
        if (weight < 1) {
            throw new IllegalArgumentValueException("Multiplicity of Edge must be higher/equals than 1");
        }
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }


}
