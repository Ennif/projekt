package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.AddTransitionListener;
import sk.stuba.fei.oop.implemented.ExecutableException;
import sk.stuba.fei.oop.implemented.Transition;

import java.awt.event.ActionEvent;

public class AddTransitionActionListener extends  BaseActionListener {

    public AddTransitionActionListener(MyCanvas canvas){
        super(canvas);
    }
    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.addListener(new AddTransitionListener(canvas));


    }



}
