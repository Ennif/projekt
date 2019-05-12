package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.generated.Export;
import sk.stuba.fei.oop.generated.FileChooser;

import java.awt.event.ActionEvent;

public class ExportActionListener extends BaseActionListener {
    public ExportActionListener(MyCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Export(canvas.getPetriNet()).exportToXml(new FileChooser().choosePathtoDirectory());
    }
}
