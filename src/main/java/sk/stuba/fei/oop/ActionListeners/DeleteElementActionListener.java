package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.DeleteElementListener;
import sk.stuba.fei.oop.implemented.Transition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteElementActionListener extends BaseActionListener {
    public DeleteElementActionListener(MyCanvas canvas) {
        super(canvas);
    }

    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.addListener(new DeleteElementListener(canvas));


        }
    }

