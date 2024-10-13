package shapes;

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
    	return "\nThe " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a side length of: " + getSideLength() + ", giving it a volume of: " + getVolume();
    }
}
