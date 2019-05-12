package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.AddEdgeListener;

import java.awt.event.ActionEvent;

public class AddEdgeActionListener extends BaseActionListener {
    public AddEdgeActionListener(MyCanvas canvas) {
        super(canvas);
    }
    public void actionPerformed(ActionEvent e) {
           canvas.removeMouseListeners();
           canvas.addListener(new AddEdgeListener(canvas));
    }
}
