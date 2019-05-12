package sk.stuba.fei.oop.Graphics;

import sk.stuba.fei.oop.implemented.ExecutableException;
import sk.stuba.fei.oop.implemented.Place;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Place2D extends Ellipse2D.Float implements Drawable {
    private Place place;
    public Place2D(Place place){
        super(place.getxPosition(),place.getyPosition(),40,40);
        this.place = place;
    }


    public long getID() {
        return place.getID();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.draw(this);
        graphics2D.drawString(place.getName(),(int)this.getCenterX(),(int)this.getCenterY()+35);
        graphics2D.drawString(""+place.getTokens(),(int)this.getCenterX(),(int)this.getCenterY());

    }

    public boolean contains(int x, int y ){
        return super.contains(x,y);
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onClick(int var) {

    }


}
