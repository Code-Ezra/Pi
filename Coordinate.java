package Pi;

//A coordinate class
public class Coordinate
{
    private double x;
    private double y;
    
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    
    public double distanceToOrgin(){
        return( Math.sqrt((Math.pow(this.x, 2)+(Math.pow(this.y, 2)))) );
    }
}
