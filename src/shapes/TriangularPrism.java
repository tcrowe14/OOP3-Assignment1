package shapes;

public class TriangularPrism extends Shape
{
	private double sideLength;

    public TriangularPrism() 
    {
    	
    }

    public TriangularPrism(double height, double sideLength) 
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
        return (1.0 / 2.0) * getBaseArea() * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return (Math.sqrt(3) / 4.0) * Math.pow(sideLength, 2);
    }
    
    @Override
    public String toString()
    {
    	return "\nThe " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a side length of: " + getSideLength() + ", giving it a volume of: " + getVolume();
    }
}
