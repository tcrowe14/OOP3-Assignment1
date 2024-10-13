package shapes;

public class PentagonalPrism extends Shape
{
	private double sideLength;

    public PentagonalPrism() 
    {
        
    }

    public PentagonalPrism(double height, double sideLength) 
    {
        super(height);
        this.sideLength = sideLength;
    }

    public double getSideLength() 
    {
        return sideLength;
    }

    public void setSideLength(double sideLength) 
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
        // The base area of a regular pentagon
        return (5.0 / 4.0) * Math.tan(Math.PI / 5) * Math.pow(sideLength, 2);
    }
    
    @Override
    public String toString()
    {
    	return "\nThe " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a side length of: " + getSideLength() + ", giving it a volume of: " + getVolume();
    }
}
