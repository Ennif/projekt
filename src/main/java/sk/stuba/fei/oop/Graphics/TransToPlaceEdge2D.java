package sk.stuba.fei.oop.Graphics;


import sk.stuba.fei.oop.implemented.EdgeFromTransitionToPlace;
import sk.stuba.fei.oop.implemented.IllegalArgumentValueException;
import sk.stuba.fei.oop.implemented.Transition;

import java.awt.*;

public class TransToPlaceEdge2D extends Arrow implements Drawable {

    private EdgeFromTransitionToPlace edgeFromTransitionToPlace;
    private MyCanvas canvas;
    public TransToPlaceEdge2D(EdgeFromTransitionToPlace edgeFromTransitionToPlace,MyCanvas canvas) {
        super(edgeFromTransitionToPlace.getFirstElement().getxPosition(),
                edgeFromTransitionToPlace.getFirstElement().getyPosition(),
                edgeFromTransitionToPlace.getSecondElement().getxPosition(),
                edgeFromTransitionToPlace.getSecondElement().getyPosition());
        this.edgeFromTransitionToPlace = edgeFromTransitionToPlace;
        this.canvas = canvas;
    }


    public long getID() {
        return edgeFromTransitionToPlace.getID();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        drawArrow(graphics2D);
        graphics2D.drawString(""+edgeFromTransitionToPlace.getWeight(),(int)this.getCenterX(),(int)this.getCenterY());
    }

    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onClick(int var) {
        try {
            edgeFromTransitionToPlace.setWeight(edgeFromTransitionToPlace.getWeight()+var);
            for(Transition t: canvas.getPetriNet().getTransition()){
                t.changeWeightOfEdges(edgeFromTransitionToPlace.getID(),var);
            }
        } catch (IllegalArgumentValueException e) {
            System.out.println(e.getMessage());;
        }
    }

}
