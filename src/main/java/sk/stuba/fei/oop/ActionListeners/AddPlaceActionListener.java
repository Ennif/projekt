package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.AddPlaceListener;

import java.awt.event.ActionEvent;

public class AddPlaceActionListener extends BaseActionListener {

    public AddPlaceActionListener(MyCanvas canvas){
        super(canvas);
    }
    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.addMouseListener(new AddPlaceListener(canvas));

    }
}
