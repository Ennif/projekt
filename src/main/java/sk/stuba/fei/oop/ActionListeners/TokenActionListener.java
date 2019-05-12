package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.MouseListeners.TokenMouseListener;

import java.awt.event.ActionEvent;

public class TokenActionListener extends BaseActionListener {
    public TokenActionListener(MyCanvas canvas) {
        super(canvas);
    }

    public void actionPerformed(ActionEvent e) {
        canvas.removeMouseListeners();
        canvas.addMouseListener(new TokenMouseListener(canvas));
    }
}
