package Pi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class LineGraph extends JPanel
{
    private final double pi = Math.PI;
    private List<Coordinate> points;

    public LineGraph(ArrayList<Coordinate> points) {
        this.points = points;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw axes
        g.setColor(Color.BLACK);
        
        g.drawLine(15, getHeight()-20, getWidth()-20, getHeight()-20); // x-axis
        g.drawLine(20, getHeight()-15, 20, 20); // y-axis
                
        // Plot points
        g.setColor(Color.RED);
        for (Coordinate point : points) {
           
            if(point.getY() >= pi){
                g.setColor(Color.RED);
            }
            else{
                g.setColor(Color.BLUE);
            }
            //I multiplied the points 100 and addded 100 to make it look better when plotted            
            g.fillOval((int)(point.getX()), (int)(getHeight()-((point.getY()-3)*100+100)), 6, 6); // Draw a small circle for the point
            System.out.println(point.getY());
        }
        
        //Pi line
        g.setColor(Color.GREEN);
        g.fillRect(20, (int)(getHeight()-((pi-3)*100+100)), getWidth(), 3);

    }
    
}
