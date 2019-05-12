package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 abstract class BaseActionListener implements ActionListener {

    protected MyCanvas canvas;
    public BaseActionListener(MyCanvas canvas){
        this.canvas = canvas;
    }

}
