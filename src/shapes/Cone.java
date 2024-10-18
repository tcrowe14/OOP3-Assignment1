package shapes;

/**
 * Cone class defines the shapes height, volume, radius and base area.
 */
public class Cone extends Shape
{
	private double radius;
	
	public Cone()
	{
		
	}
	
	public Cone(double height, double radius)
	{
		super(height);
		this.setRadius(radius);
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
		return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * this.height;
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
