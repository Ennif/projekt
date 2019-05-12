package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.Drawable;
import sk.stuba.fei.oop.Graphics.MyCanvas;


import java.awt.event.MouseEvent;

public class RunListener extends BaseListener {
    public RunListener(MyCanvas canvas){
        super(canvas);
    }
    public void mouseClicked(MouseEvent e) {

        for(Drawable x: ((MyCanvas)e.getSource()).getElements()){
            if(x.contains(e.getX(),e.getY())){
                    x.onClick();
            }
            canvas.repaint();
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
