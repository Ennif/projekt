package sk.stuba.fei.oop.ActionListeners;

import sk.stuba.fei.oop.Graphics.MyCanvas;
import sk.stuba.fei.oop.generated.FileChooser;
import sk.stuba.fei.oop.generated.ImportXml;
import sk.stuba.fei.oop.generated.TransportXml;

import java.awt.event.ActionEvent;

public class ImportListener extends BaseActionListener {


    public ImportListener(MyCanvas canvas) {
        super(canvas);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            FileChooser fileChooser = new FileChooser();
            canvas.setNet(new TransportXml(new ImportXml(fileChooser.getPathToSelectedFile()).getDocument()).getPN());
            canvas.repaint();
        }catch(NullPointerException ex){}
    }
    }

