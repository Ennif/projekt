package sk.stuba.fei.oop.MouseListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;

import java.awt.event.MouseListener;

public abstract class BaseListener implements MouseListener {

    protected MyCanvas canvas ;

    public BaseListener(MyCanvas canvas){this.canvas = canvas;}

    public MyCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }
}
