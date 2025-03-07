package Pi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class CircleGraph extends JPanel {

    private List<Coordinate> points;

    public CircleGraph(List<Coordinate> points) {
        this.points = points;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw axes
        g.setColor(Color.BLACK);
        g.drawLine(20, getHeight()/2, getWidth() - 20, getHeight()/2); // x-axis
        g.drawLine(getWidth()/2, 20, getWidth()/2, getHeight()-20); // y-axis

        // Plot points
        g.setColor(Color.RED);
        for (Coordinate point : points) {
            //if point.distanceToOrgin()<=100 that means that the points is in the circle
            if(point.distanceToOrgin()<=100){
                g.setColor(Color.RED);
            }
            else{
                g.setColor(Color.BLUE);
            }
            double x = point.getX() + getWidth()/2;
            double y = point.getY() + getHeight()/2;
            g.fillOval((int)x, (int)y, 6, 6); // Draw a small circle for the point
        }
        
    }
    
}
