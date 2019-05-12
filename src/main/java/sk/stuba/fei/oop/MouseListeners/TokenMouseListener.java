package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.Drawable;
import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.implemented.ElementDoesNotExistException;
import sk.stuba.fei.oop.implemented.IllegalArgumentValueException;
import sk.stuba.fei.oop.implemented.PetriNets;


import java.awt.event.MouseEvent;

public class TokenMouseListener extends BaseListener {
    private PetriNets net;
    public TokenMouseListener(MyCanvas canvas ){
        super(canvas);
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            modifyToken(e,1);
        }
        if(e.getButton() == MouseEvent.BUTTON3){
            modifyToken(e,-1);
        }
    }
    private void modifyToken(MouseEvent e, int var){
        for(Drawable element : canvas.getElements()){
            if(element.contains(e.getX(),e.getY())){
                try {
                    net = canvas.getPetriNet();
                    net.lookingForPlace(element.getID()).setTokens(net.lookingForPlace(element.getID()).getTokens()+var);
                    canvas.repaint();
                } catch (ElementDoesNotExistException e1) {
                } catch (IllegalArgumentValueException e1) {
                }

            }
        }
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
