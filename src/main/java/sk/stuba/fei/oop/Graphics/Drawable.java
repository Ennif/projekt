package sk.stuba.fei.oop.Graphics;


import java.awt.*;


public interface Drawable {

    long getID();

    void draw(Graphics2D graphics2D);

    boolean contains(int x , int y);

    void onClick();

    void onClick(int var);

}
