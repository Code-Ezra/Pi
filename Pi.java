package Pi;

/*
 * A program to calculate pi and graphicly show how I do it and how the 
 * result gets closer to pi the more points we use.
 * 
 * By Ezra, 3/6/25
 */

import javax.swing.JFrame;
import java.util.Arrays;
import java.util.ArrayList;

public class Pi
{
    //An array list of the calculated ratio that aprouches pi
    private ArrayList<Double> pis = new ArrayList<Double>();
    
    //This method computes pi by getting within a square of area 4 going from
    //x = -1, 1 and y = -1, 1 and then finding the points within a circle of
    //radius 1
    public double computePi(long times){        
        long count = 0;
        double computedPi;
        
        for(long i = 1; i<=times; i++){
            Coordinate randomPoint = new Coordinate((Math.random())*2-1, (Math.random())*2-1);
            if( randomPoint.distanceToOrgin() <= 1 ){
                count++;
            }
            //I'm multiplying by 4 beacuse the square's area is 4
            computedPi = 4.0*count/(i);
            pis.add(computedPi);
        }
        //4* beacuse of the same reason above
        return (4.0*count/times);
    }
    
    //A method to show graphically which points lie within the unit circle (red), 
    //and which points are in the square but not the circle (blue)
    public void drawCircle(long times){
        ArrayList<Coordinate> points = new ArrayList<Coordinate>();
        
        long count = 0;
        
        //This generates the points
        for(long i = 0; i<times; i++){
            //I multiplied the points by 100 to makes it clearer on the graph
            Coordinate randomPoint = new Coordinate(((Math.random())*2-1)*100, ((Math.random())*2-1)*100);
            points.add(randomPoint);
        }
        
        //This makes the plot
        CircleGraph graphPanel = new CircleGraph(points);

        JFrame frame = new JFrame("Circle Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphPanel);
        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
    //A method to plot the calculation of pi against time showing it gets closer to 
    //pi
    public void drawLineGraph(int times){
        ArrayList<Coordinate> dataPoints = new ArrayList<Coordinate>();
        
        //This calculates the points
        //X is 20 beacuse it looks better shifted 20 pixles over
        int x = 20;
        computePi(times);
        for(double pi : pis){
            dataPoints.add(new Coordinate(x, pi));
            x++;
        }
        
        //This makes the plot
        LineGraph graphPanel = new LineGraph(dataPoints);

        JFrame frame = new JFrame("Pi Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphPanel);
        frame.setSize(times, 250);
        frame.setResizable(true);
        frame.setVisible(true);
    }    
    
    
}
