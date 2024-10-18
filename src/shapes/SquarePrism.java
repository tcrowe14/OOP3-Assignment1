package shapes;

/**
 * Square Prism class defines the shapes height, volume, side length and base area.
 */
public class SquarePrism extends Shape
{
	private double sideLength;

    public SquarePrism() 
    {
        
    }

    public SquarePrism(double height, double sideLength) 
    {
        super(height);
        this.sideLength = sideLength;
    }

    public double getSideLength() 
    {
        return sideLength;
    }

    public void setsideLength(double sideLength) 
    {
        this.sideLength = sideLength;
    }

    @Override
    public double getVolume() 
    {
        return getBaseArea() * getHeight();
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
