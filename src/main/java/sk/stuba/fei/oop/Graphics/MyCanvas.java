package sk.stuba.fei.oop.Graphics;

import sk.stuba.fei.oop.implemented.*;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MyCanvas extends Canvas  {
    private List<Drawable> elements =  new ArrayList<Drawable>();
    private PetriNets net = new PetriNets();

    public void setNet(PetriNets net) {
        this.net = net;
        addElemets();
    }




    public MyCanvas(){
        super();
        setBackground(Color.WHITE);
        setSize(1000,1000);
    }

    public void addElemets(){
        elements.clear();
        for(Place place : net.getPlace()){
            setElement(new Place2D(place));
        }
        for(Transition transition: net.getTransition()){
            setElement(new Transition2D(transition));
        }
        for(Edge edges : net.getEdges()){
            if(edges instanceof  EdgeFromTransitionToPlace){
                setElement(new TransToPlaceEdge2D((EdgeFromTransitionToPlace)edges,this));
            }else if (edges instanceof  EdgeFromPlaceToTransition){
                setElement(new PlaceToTransEdge2D((EdgeFromPlaceToTransition)edges,this));
            }else if (edges instanceof sk.stuba.fei.oop.implemented.ResetEdge){
                setElement(new ResetEdgee2D((sk.stuba.fei.oop.implemented.ResetEdge)edges));
            }
        }
    }



    public void clear(){
        elements.clear();
    }



    public List<Drawable> getElements() {
        return elements;
    }


    public PetriNets getPetriNet(){
        return net;
    }


    public void setElement(Drawable element) {
        this.elements.add(element);
    }



    public void setSwitchersToFalse(){
        for( Drawable element : elements){
            if(element instanceof Transition2D){
                ((Transition2D) element).setSwitcher(false);
            }
        }
        this.repaint();
    }
    public void setSwitchersToTrue(){
        for( Drawable element : elements){
            if(element instanceof Transition2D){
                ((Transition2D) element).setSwitcher(true);
            }
        }
        this.repaint();
    }

    @Override
    public void paint(Graphics g ){
        for(Drawable element: elements){
            element.draw((Graphics2D)g);
        }
    }


    public void removeMouseListeners(){
        for(MouseListener m : getMouseListeners()){
            removeMouseListener(m);
            setSwitchersToFalse();
        }
    }

    public void addListener(MouseListener mouseListener){
        addMouseListener(mouseListener);
    }



}
