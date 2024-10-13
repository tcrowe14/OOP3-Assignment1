package shapes;

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
    	return "\nThe " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a base side length of: " + getBaseSideLength() + ", giving it a volume of: " + getVolume();
    }
}
