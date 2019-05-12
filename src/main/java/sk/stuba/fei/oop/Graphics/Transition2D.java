package sk.stuba.fei.oop.Graphics;

import sk.stuba.fei.oop.implemented.ExecutableException;
import sk.stuba.fei.oop.implemented.ForegroundNotActiveException;
import sk.stuba.fei.oop.implemented.Transition;


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Drawable {
    private boolean switcher = false;

    public boolean getSwitcher() {
        return switcher;
    }



    private Transition transition;
    public Transition2D(Transition transition){
        super(transition.getxPosition(),transition.getyPosition(),40,40);
        this.transition = transition;

    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    public long getID() {
        return transition.getID();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        fillTransWithColor(graphics2D);
        graphics2D.draw(this);
        graphics2D.drawString(transition.getName(),(int)this.getCenterX(),(int)this.getCenterY()+35);

    }

    private void fillTransWithColor(Graphics2D graphics2D){
        try{
            transition.checkExecutability();
            foregroundStatusChecker();
            graphics2D.setPaint(Color.GREEN);
            graphics2D.fill(this);

         } catch (ExecutableException e) {
            e.getMessage();
        }catch(ForegroundNotActiveException e){

        }
    }

    private void foregroundStatusChecker() throws ForegroundNotActiveException{
        if(!this.switcher){
            throw  new ForegroundNotActiveException();
        }
    }


    public boolean contains(int x, int y) {
        return super.contains(x,y);
    }

    public void onClick()  {
            transition.launch();

    }

    @Override
    public void onClick(int var) {

    }

}






