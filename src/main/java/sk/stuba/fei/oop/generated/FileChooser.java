package sk.stuba.fei.oop.generated;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;


public class FileChooser {

    private JFileChooser fileChooser;

    public FileChooser(){
        fileChooser = new JFileChooser();
    }


    public String getPathToSelectedFile(){
        JButton confirm = new JButton();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileFilter() {

            public String getDescription() {
                return "xml Documents (*.xml)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".xml");
                }
            }
        });

        if(fileChooser.showOpenDialog(confirm) == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public String choosePathtoDirectory(){
        JButton confirm = new JButton();
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setDialogTitle("Vyberte kde chcete subor ulozit");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //
        // disable the "All files" option.
        //
        fileChooser.setAcceptAllFileFilterUsed(false);
        //
        if (fileChooser.showOpenDialog(confirm) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return  null;
    }
}
