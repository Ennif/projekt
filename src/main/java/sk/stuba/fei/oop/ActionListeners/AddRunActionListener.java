package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.RunListener;

import java.awt.event.ActionEvent;

public class AddRunActionListener extends BaseActionListener {
    public AddRunActionListener(MyCanvas canvas) {
        super(canvas);
    }

    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.setSwitchersToTrue();
        canvas.addListener(new RunListener(canvas));
    }
}
