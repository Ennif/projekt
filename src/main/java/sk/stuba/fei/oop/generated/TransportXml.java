package sk.stuba.fei.oop.generated;


import sk.stuba.fei.oop.implemented.IllegalArgumentValueException;
import sk.stuba.fei.oop.implemented.PetriNets;

public class TransportXml {
    private PetriNets net = new PetriNets();
    private Document xmlFile;
    public TransportXml(Document xmlFile){
        this.xmlFile = xmlFile;
        try{
        setTransition(xmlFile);
        setPlace(xmlFile);
        setEdge(xmlFile);}
        catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void setTransition(Document xmlFile) {
        for (sk.stuba.fei.oop.generated.Transition t : xmlFile.getTransition()) {
            net.getTransition().add(new sk.stuba.fei.oop.implemented.Transition(t.getLabel(), t.getId(),t.getX(),t.getY()));
        }
    }


    public void setPlace(Document xmlFile) {
        try {
            for (sk.stuba.fei.oop.generated.Place p : xmlFile.getPlace()) {
                net.getPlace().add(new sk.stuba.fei.oop.implemented.Place(p.getLabel(), p.getId(), p.getTokens(),p.getX(),p.getY()));
            }
        } catch (IllegalArgumentValueException e) {
            System.out.println(e.getMessage());
        }
    }


    private String EdgeCheck(Arc edge) {
        return edge.getType().value();
    }


    private boolean ifTransitionExists(int transitionID) {
        for (sk.stuba.fei.oop.implemented.Transition t : net.getTransition()) {
            if (t.getID() == transitionID)
                return true;
        }
        return false;
    }

    private void setEdge(Document xmlFile) {
        for(Arc a : xmlFile.getArc()){
            if(EdgeCheck(a).equals("reset")){
                net.createResetEdge(a.getSourceId(),a.getDestinationId(),a.getId());
            }
            else if(EdgeCheck(a).equals("regular")){
                if(ifTransitionExists(a.getSourceId())){
                    net.createTransitionToPlaceEdge(a.getSourceId(),a.getDestinationId(),a.getMultiplicity(),a.getId());
                }else{
                    net.createPlaceToTransitionEdge(a.getSourceId(),a.getDestinationId(),a.getMultiplicity(),a.getId());
                }
            }
        }
    }

    public PetriNets getPN(){
        return this.net;

    }
}
