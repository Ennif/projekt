package sk.stuba.fei.oop.Graphics;

import sk.stuba.fei.oop.implemented.EdgeFromPlaceToTransition;
import sk.stuba.fei.oop.implemented.IllegalArgumentValueException;
import sk.stuba.fei.oop.implemented.Transition;

import java.awt.*;


public class PlaceToTransEdge2D extends Arrow implements  Drawable {

    private EdgeFromPlaceToTransition edgeFromPlaceToTransition;
    private MyCanvas canvas;
    public PlaceToTransEdge2D(EdgeFromPlaceToTransition edge,MyCanvas canvas) {
        super(edge.getFirstElement().getxPosition(),
                edge.getFirstElement().getyPosition(),
                edge.getSecondElement().getxPosition(),
                edge.getSecondElement().getyPosition());
        this.edgeFromPlaceToTransition = edge;
        this.canvas = canvas;
    }

    public long getID() {
        return edgeFromPlaceToTransition.getID();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        drawArrow(graphics2D);
        graphics2D.drawString(""+edgeFromPlaceToTransition.getWeight(),(int)this.getCenterX(),(int)this.getCenterY());
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
            edgeFromPlaceToTransition.setWeight(edgeFromPlaceToTransition.getWeight()+var);
            for(Transition t: canvas.getPetriNet().getTransition()){
                t.changeWeightOfEdges(edgeFromPlaceToTransition.getID(),var);
            }
        } catch (IllegalArgumentValueException e) {
            System.out.println(e.getMessage());
        }
    }
}
