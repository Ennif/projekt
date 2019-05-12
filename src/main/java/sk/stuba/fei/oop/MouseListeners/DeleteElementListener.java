package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.*;
import java.awt.event.MouseEvent;

public class DeleteElementListener extends BaseListener  {

    public DeleteElementListener(MyCanvas canvas){
        super(canvas);
    }

    public void mouseClicked(MouseEvent e) {

        delete(e);
        canvas.addElemets();
        canvas.repaint();

    }

    private void delete(MouseEvent e){
        if(drawableClicked(e) != null){
            canvas.getPetriNet().deleteElement(drawableClicked(e).getID());
        }
    }

    private Drawable drawableClicked(MouseEvent e){
        for (Drawable element: canvas.getElements()) {
            if(element instanceof Arrow){
                if(betterClick(e,(Arrow)element)){
                    return element;
                }
            }
            else{
                if(element.contains(e.getX(),e.getY())) {
                    return element;
                }
            }
        }
        return null;
    }
    private boolean betterClick(MouseEvent e, Arrow arc){
        if(arc.intersects(e.getX()-7,e.getY()-7,14,14)){
            return true;
        }
        return false;
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
