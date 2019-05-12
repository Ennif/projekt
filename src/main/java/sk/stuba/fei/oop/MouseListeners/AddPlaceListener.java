package sk.stuba.fei.oop.MouseListeners;


import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.Graphics.Place2D;
import java.awt.event.MouseEvent;


public class AddPlaceListener extends BaseListener {
    public AddPlaceListener(MyCanvas canvas) {
        super(canvas);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(canvas.getPetriNet().getNewID());
        canvas.getPetriNet().createPlace("",0,e.getX(),e.getY());
        canvas.getElements().clear();
        canvas.setElement(new Place2D((canvas.getPetriNet().getPlace()).get(canvas.getPetriNet().getPlace().size()-1)));
        canvas.addElemets();
        canvas.repaint();
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

