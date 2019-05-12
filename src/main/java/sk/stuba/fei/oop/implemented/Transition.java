package sk.stuba.fei.oop.implemented;

import java.util.ArrayList;
import java.util.List;

public class Transition extends BaseElement {
    private List<EdgeFromTransitionToPlace> listOfTransitionToPlaceEdges = new ArrayList<EdgeFromTransitionToPlace>();
    private List<EdgeFromPlaceToTransition> listOfPlaceToTransitionEdges = new ArrayList<EdgeFromPlaceToTransition>();
    private List<ResetEdge> listOfResetEdges = new ArrayList<ResetEdge>();


    public Transition(String name, long ID,int xPosition, int yPosition) {
        super(name, ID,xPosition,yPosition);
    }

    public void addTransitionToPlaceEdge(EdgeFromTransitionToPlace edge) {
        listOfTransitionToPlaceEdges.add(edge);
    }

    public void addPlaceToTransitionEdge(EdgeFromPlaceToTransition edge) {
        listOfPlaceToTransitionEdges.add(edge);
    }

    public void addReesetEdge(ResetEdge edge) {
        listOfResetEdges.add(edge);
    }

    public void launch()  {

        try {
            checkExecutability();
            for (EdgeFromPlaceToTransition edge : listOfPlaceToTransitionEdges)
                edge.launch();

            for (EdgeFromTransitionToPlace edge : listOfTransitionToPlaceEdges)
                edge.launch();

            for (ResetEdge edge : listOfResetEdges)
                edge.launch();
        }
        catch (IllegalArgumentValueException e){
            System.out.println(e.getMessage());
        } catch (ExecutableException e) {
            e.getMessage();
        }

    }

    public void checkExecutability() throws ExecutableException{
        EdgeFromPlaceToTransition placeToTransition;
        for (EdgeFromPlaceToTransition edge : listOfPlaceToTransitionEdges) {
                edge.check() ;


        }
    }

    public List<EdgeFromTransitionToPlace> getListOfTransitionToPlaceEdges() {
        return listOfTransitionToPlaceEdges;
    }

    public List<EdgeFromPlaceToTransition> getListOfPlaceToTransitionEdges() {
        return listOfPlaceToTransitionEdges;
    }

    public List<ResetEdge> getListOfResetEdges() {
        return listOfResetEdges;
    }

    public void changeWeightOfEdges(long id, int var) {
        try {
            for (EdgeFromPlaceToTransition e : listOfPlaceToTransitionEdges) {
                if (e.getID() == id) {
                    e.setWeight(e.getWeight() + var);
                }
            }
            for (EdgeFromTransitionToPlace e : listOfTransitionToPlaceEdges) {
                if (e.getID() == id) {
                    e.setWeight(e.getWeight() + var);
                }
            }
        } catch (IllegalArgumentValueException e) {
            e.printStackTrace();
        }
    }
}





