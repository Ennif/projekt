package sk.stuba.fei.oop.Graphics;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import sk.stuba.fei.oop.ActionListeners.*;


public class FrameApp extends Frame {
    protected MyCanvas canvas;


    public FrameApp() {

        setBackground(Color.GRAY);
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setVisible(true);
        canvas = new MyCanvas();


        Button importButton = new Button("Import XML");
        Button addTransitionButton = new Button("Transition");
        Button addPlaceButton = new Button("Place");
        Button addArcButton = new Button("Arc");
        Button addResetArcButton = new Button("ResetArc");
        Button runButton = new Button("Run");
        Button modifyTokens = new Button("Tokens");
        Button deleteButton = new Button("Delete");
        Button changeWeightButton = new Button("Weight");
        Button exportButton = new Button("Export");

        addPlaceButton.addActionListener(new AddPlaceActionListener(canvas));
        addTransitionButton.addActionListener(new AddTransitionActionListener(canvas));
        runButton.addActionListener(new AddRunActionListener(canvas));
        modifyTokens.addActionListener(new TokenActionListener(canvas));
        addArcButton.addActionListener(new AddEdgeActionListener(canvas));
        importButton.addActionListener(new ImportListener(canvas));
        deleteButton.addActionListener(new DeleteElementActionListener(canvas));
        addResetArcButton.addActionListener(new AddResetArcActionListener(canvas));
        changeWeightButton.addActionListener(new ChangeWeightActionListener(canvas));
        exportButton.addActionListener(new ExportActionListener(canvas));

        Panel panelUp = new Panel();

        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
        panelUp.add(importButton);
        panelUp.add(addTransitionButton);
        panelUp.add(addPlaceButton);
        panelUp.add(addArcButton);
        panelUp.add(runButton);
        panelUp.add(modifyTokens);
        panelUp.add(deleteButton);
        panelUp.add(addResetArcButton);
        panelUp.add(changeWeightButton);
        panelUp.add(exportButton);

        add(panelUp, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);


        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
}
