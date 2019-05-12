package sk.stuba.fei.oop.ActionListeners;


import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.ChangeWeightListener;

import java.awt.event.ActionEvent;

public class ChangeWeightActionListener extends BaseActionListener {
    public ChangeWeightActionListener(MyCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.addListener(new ChangeWeightListener(canvas));
    }
}
