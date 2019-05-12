package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.Arrow;
import sk.stuba.fei.oop.Graphics.Drawable;
import sk.stuba.fei.oop.Graphics.MyCanvas;

import java.awt.event.MouseEvent;
import java.util.Objects;

public class ChangeWeightListener extends BaseListener {
    public ChangeWeightListener(MyCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(drawableClicked(e) != null){
            if(e.getButton() == MouseEvent.BUTTON1){
                Objects.requireNonNull(drawableClicked(e)).onClick(+1);
            }
            if(e.getButton() == MouseEvent.BUTTON3){
                drawableClicked(e).onClick(-1);
            }
        }
        canvas.repaint();
    }

    private Drawable drawableClicked(MouseEvent e){
        for (Drawable element: canvas.getElements()) {
            if(element instanceof Arrow){
                if(betterClick(e,(Arrow)element)){
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


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
