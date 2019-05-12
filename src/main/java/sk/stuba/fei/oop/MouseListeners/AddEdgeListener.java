package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.Drawable;
import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.implemented.MouseClickedToNullException;

import java.awt.event.MouseEvent;

public class AddEdgeListener extends BaseListener {

    public AddEdgeListener(MyCanvas canvas) {
        super(canvas);
    }
    private Long firstElementID = null, secondElementID = null;
    public void mouseClicked(MouseEvent e) {


        if(firstElementID == null){
            System.out.println("PRVY ELEMENT");
            try {
                setFirstElementID(e);
            } catch (MouseClickedToNullException e1) {
                System.out.println(e1.geteMessage());
            }
        }


        else if(secondElementID == null){
            System.out.println("DRUHY ELEMENT");
            try {
                setSecondElementID(e);
                if(!(canvas.getPetriNet().sameArcUsed(firstElementID,secondElementID))){
                setArc(this.firstElementID,this.secondElementID);
                atributesToNull();
                canvas.addElemets();
                canvas.repaint();
                }

            } catch (MouseClickedToNullException e1) {
                System.out.println(e1.geteMessage());
            }
            atributesToNull();

        }


    }
    private void setFirstElementID(MouseEvent e) throws MouseClickedToNullException {
        for(Drawable element : canvas.getElements()){
            if(element.contains(e.getX(),e.getY())){
                this.firstElementID = element.getID();
                System.out.println(""+element.getClass());
                return;
            }
        }
        atributesToNull();
        throw new MouseClickedToNullException("Clicked to null");
    }

    private void setSecondElementID(MouseEvent e) throws MouseClickedToNullException{
        for(Drawable element : canvas.getElements()){
            if(element.contains(e.getX(),e.getY())){
                this.secondElementID = element.getID();
                System.out.println(""+element.getClass());
                return;
            }
        }
        atributesToNull();
        throw new MouseClickedToNullException("Clicked to null");

    }

    private void setArc(long firstElementID, long secondElementID){
        canvas.getPetriNet().createPlaceToTransitionEdge(firstElementID,secondElementID,1);
        canvas.getPetriNet().createTransitionToPlaceEdge(firstElementID,secondElementID,1);

    }

    private void atributesToNull(){
        this.firstElementID = null;
        this.secondElementID = null;
    }


    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
