package shapes;

/**
 * Pyramid class defines the shapes height, volume, side length and base area.
 */
public class Pyramid extends Shape
{
	private double sideLength;

    public Pyramid() 
    {
        
    }

    public Pyramid(double height, double sideLength) 
    {
        super(height);
        this.sideLength = sideLength;
    }

    public double getBaseSideLength() 
    {
        return sideLength;
    }

    public void setBaseSideLength(double sideLength) 
    {
        this.sideLength = sideLength;
    }

    @Override
    public double getVolume() 
    {
        return (1.0 / 3.0) * getBaseArea() * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return Math.pow(sideLength, 2);
    }
    
    @Override
    public String toString()
    {
    	return "The " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a base area of: " + getBaseArea() + ", giving it a volume of: " + getVolume() + "\n";
    }
}
