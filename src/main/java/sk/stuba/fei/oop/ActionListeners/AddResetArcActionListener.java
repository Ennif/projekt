package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.AddResetArcListener;

import java.awt.event.ActionEvent;

public class AddResetArcActionListener extends BaseActionListener {
    public AddResetArcActionListener(MyCanvas canvas) {
        super(canvas);
    }

    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.addListener(new AddResetArcListener(canvas));
    }
}
