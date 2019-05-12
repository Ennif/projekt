package sk.stuba.fei.oop.Graphics;


import sk.stuba.fei.oop.implemented.ExecutableException;
import sk.stuba.fei.oop.implemented.ResetEdge;

import java.awt.*;

public class ResetEdgee2D extends Arrow implements Drawable {

    protected sk.stuba.fei.oop.implemented.ResetEdge resetEdge;
    public ResetEdgee2D(sk.stuba.fei.oop.implemented.ResetEdge resetEdge) {
        super(resetEdge.getFirstElement().getxPosition(),resetEdge.getFirstElement().getyPosition(),resetEdge.getSecondElement().getxPosition(),resetEdge.getSecondElement().getyPosition());
        this.resetEdge = resetEdge;
    }

    public long getID() {
        return resetEdge.getID();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        drawArrow(graphics2D);
        graphics2D.drawString("Reset",(int)this.getCenterX(),(int)this.getCenterY());

    }


    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onClick(int var) {

    }
}
