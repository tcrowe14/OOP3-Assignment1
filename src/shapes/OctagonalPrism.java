package shapes;

public class OctagonalPrism extends Shape
{
	private double sideLength;
	
	public OctagonalPrism()
	{
		
	}
	
	public OctagonalPrism(double height, double sideLength)
	{
		super(height);
		this.setsideLength(sideLength);
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
		return 2 * Math.pow(sideLength, 2) * Math.tan(Math.PI / 8);
	}

    @Override
    public String toString()
    {
    	return "The " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a base area of: " + getBaseArea() + ", giving it a volume of: " + getVolume() + "\n";
    }
	
}
