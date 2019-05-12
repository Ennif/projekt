package sk.stuba.fei.oop.Graphics;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Arrow extends Line2D.Float {

    private final int ARR_SIZE = 6;



    public Arrow(int x1, int y1, int x2, int y2) {
        super(x1+20,y1+20,x2+20,y2+20);
        setPositions(getAngle());
    }


    void drawArrow(Graphics g1) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);

        int len = (int) Math.sqrt(dx * dx + dy * dy) - 20;


        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len},
                new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4);

    }


    double getCenterX(){
        return (super.x1+super.x2)/2;
    }
    double getCenterY(){
        return (super.y1+super.y2)/2;
    }
    private void setPositions(int angleInDegrees) {
        if (angleInDegrees >= 45 && angleInDegrees < 135)
            super.y1 = super.y1+20;
        else if (angleInDegrees >= 135 && angleInDegrees < 225)
            super.x1= super.x1-20;
        else if (angleInDegrees >= 225 && angleInDegrees < 315)
            super.y1=super.y1-20;
        else if (angleInDegrees >= 315 || angleInDegrees < 45)
            super.x1= super.x1+20;

    }
    private int getAngle(){
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);

        int len = (int) Math.sqrt(dx * dx + dy * dy) - 20;
        int angleInDegrees = (int) ((angle * 180) / Math.PI);
        if (angleInDegrees < 0) {
            angleInDegrees = angleInDegrees + 360;
        }
        return angleInDegrees;
    }


}
