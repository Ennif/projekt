package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.Graphics.Transition2D;

import java.awt.event.MouseEvent;

public class AddTransitionListener extends BaseListener {

    public AddTransitionListener(MyCanvas canvas){
        super(canvas);
    }

    public void mouseClicked(MouseEvent e) {
        canvas.getPetriNet().createTransition("",e.getX(),e.getY());
        canvas.getElements().clear();
        canvas.setElement(new Transition2D((canvas.getPetriNet().getTransition()).get(canvas.getPetriNet().getTransition().size()-1)));
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
