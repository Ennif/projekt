package sk.stuba.fei.oop.implemented;


        import java.util.*;


public class PetriNets {

    private List<Transition> transition = new ArrayList<Transition>();
    private List<Place> place = new ArrayList<Place>();
    private List<Edge> edges = new ArrayList<Edge>();
    private long newID = 1;

    public void createTransition(String name, long ID, int xPosition, int yPosition) {

        try {
            idCheck(ID);
            transition.add(new Transition(name, ID,xPosition,yPosition));
        } catch (ElementAlreadyExistsException e) {
            e.getIdMessage(ID);
        }
    }
    public void createTransition(String name, int xPosition, int yPosition){
        createTransition(name,getNewID(),xPosition,yPosition);
    }

    public void createPlace(String name, long ID, int tokens, int xPosition, int yPosition) {
        try {
            idCheck(ID);
            place.add(new Place(name, ID, tokens,xPosition,yPosition));
        } catch (ElementAlreadyExistsException e) {
            e.getIdMessage(ID);
        } catch (IllegalArgumentValueException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createPlace(String name, int tokens, int xPosition, int yPosition){
        createPlace(name,getNewID(),tokens,xPosition,yPosition);
    }


    public Transition lookingForTransition(long transitionID) throws ElementDoesNotExistException {
        for (Transition t : transition) {
            if (t.getID() == transitionID) return t;
        }
        throw new ElementDoesNotExistException("Transition does not exist");
    }

    public Place lookingForPlace(long placeID) throws ElementDoesNotExistException {
        for (Place p : place) {
            if (p.getID() == placeID) return p;
        }
        throw new ElementDoesNotExistException("Place does not exist");
    }

    public void createTransitionToPlaceEdge(long transitionID, long placeID, int weight, long ID) {
        try {
            idCheck(ID);
            Transition trans = lookingForTransition(transitionID);
            Place place = lookingForPlace(placeID);
            trans.addTransitionToPlaceEdge(new EdgeFromTransitionToPlace(trans, place, weight,ID));
            edges.add(new EdgeFromTransitionToPlace(trans,place,weight,ID));
        } catch (ElementDoesNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        } catch (IllegalArgumentValueException ex) {
            System.out.println(ex.getMessage());
        } catch (ElementAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTransitionToPlaceEdge(long transitionID, long placeID, int weight){
        createTransitionToPlaceEdge(transitionID,placeID,weight,getNewID());
    }

    private void idCheck(long id) throws ElementAlreadyExistsException {
        for (Transition t : transition) {
            if (t.getID() == id) throw new ElementAlreadyExistsException(id);
        }

        for (Place p : place) {
            if (p.getID() == id) throw new ElementAlreadyExistsException(id);
        }

        for (Edge e : edges) {
            if (e.getID() == id) throw new ElementAlreadyExistsException(id);
        }
    }

    public void createPlaceToTransitionEdge(long placeID, long transitionID, int weight, long ID) {
        try {
            idCheck(ID);
            Transition trans = lookingForTransition(transitionID);
            Place place = lookingForPlace(placeID);
            trans.addPlaceToTransitionEdge(new EdgeFromPlaceToTransition(place, trans, weight,ID));
            edges.add(new EdgeFromPlaceToTransition(place,trans,weight, ID));
        } catch (ElementDoesNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        } catch (IllegalArgumentValueException ex) {
            System.out.println(ex.getMessage());
        } catch (ElementAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createPlaceToTransitionEdge(long placeID, long transitionID, int weight){
        createPlaceToTransitionEdge(placeID,transitionID,weight,getNewID());
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void createResetEdge(long placeID, long transitionID, long ID) {
        try {
            idCheck(ID);
            Transition trans = lookingForTransition(transitionID);
            Place place = lookingForPlace(placeID);
            trans.addReesetEdge(new ResetEdge(place, trans,ID));
            edges.add(new ResetEdge(place,trans, ID));
        } catch (ElementDoesNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        } catch (ElementAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createResetEdge(long placeID, long transitionID){
        createResetEdge(placeID, transitionID,getNewID());
    }

    public void launchTransition(long transitionID) {
        try {
            Transition trans = lookingForTransition(transitionID);
            trans.launch();
        }
         catch (ElementDoesNotExistException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }

    public void netInfo() {
        for (Place p : place) {
            System.out.println("Meno: " + p.getName() + "     Tokens: " + p.getTokens());
        }
        System.out.println("");
        for (Transition t : transition) {
            System.out.println("Meno: " + t.getName());
        }

    }

    public List<Transition> getTransition() {
        return transition;
    }

    public void setTransition(List<Transition> transition) {
        this.transition = transition;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }

    private boolean checkID(long ID){
        for(Transition t : transition){
            if(ID == t.getID()) {
                return true;
            }
        }
        for(Place p : place){
            if(ID == p.getID())
                return true;
        }
        for(Edge e : edges){
            if(ID == e.getID())
                return true;
        }
        return false;
    }

    private long setID(long newID){
        if(checkID(newID)){
            newID++;
            return setID(newID);
        }
        else
            return newID;
    }

    public long  getNewID(){
        this.newID = setID(this.newID);
        return this.newID;
    }

    public boolean sameArcUsed(long firstElementID, long secondElementID){
        for(Edge e: edges){
            if(e.getFirstElement().getID() == firstElementID && e.getSecondElement().getID() == secondElementID)
                return true;
        }
        return false;
    }

    public void deleteElement(long id) {
        for (Place p : place) {
            if (p.getID() == id) {
                deleteAttachedEdges(p);
                place.remove(p);
                break;
            }
        }
        for (Transition t : transition) {
            if (t.getID() == id) {
                deleteAttachedEdges(t);
                transition.remove(t);
                break;
            }
        }
        for(Edge e : edges){
            if(e.getID() == id){
                deleteEdgeFromTransition(e);
                edges.remove(e);
                break;
            }
        }
    }

    private void deleteAttachedEdges(final BaseElement element) {
        edges.removeIf(edge -> element.getID() == edge.getFirstElement().getID() || element.getID() == edge.getSecondElement().getID()) ;
        for (Transition t:transition) {
            t.getListOfTransitionToPlaceEdges().removeIf(edge -> element.getID() == edge.getFirstElement().getID() || element.getID() == edge.getSecondElement().getID());
            t.getListOfPlaceToTransitionEdges().removeIf(edge -> element.getID() == edge.getFirstElement().getID() || element.getID() == edge.getSecondElement().getID());
            t.getListOfResetEdges().removeIf(edge -> element.getID() == edge.getFirstElement().getID() || element.getID() == edge.getSecondElement().getID());
        }
    }

    private void deleteEdgeFromTransition(Edge edge){
        for(Transition t: transition){
            t.getListOfTransitionToPlaceEdges().removeIf(edge_1 -> edge.getID() == edge_1.getID());
            t.getListOfPlaceToTransitionEdges().removeIf(edge_1 -> edge.getID() == edge_1.getID());
            t.getListOfResetEdges().removeIf(edge_1 -> edge.getID() == edge_1.getID());
        }
    }
}






