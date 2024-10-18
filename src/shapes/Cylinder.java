package shapes;

/**
 * Cylinder class defines the shapes height, volume, radius and base area.
 */
public class Cylinder extends Shape
{
	private double radius;

    public Cylinder() 
    {

    }

    public Cylinder(double height, double radius) 
    {
        super(height);
        this.radius = radius;
    }

    public double getRadius() 
    {
        return radius;
    }

    public void setRadius(double radius) 
    {
        this.radius = radius;
    }

    @Override
    public double getVolume() 
    {
        return Math.PI * Math.pow(radius, 2) * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public String toString()
    {
    	return "The " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a base area of: " + getBaseArea() + ", giving it a volume of: " + getVolume() + "\n";
    }
}
