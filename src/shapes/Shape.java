package shapes;

/**
 * The Shape class is an abstract class defining Height, Volume and base area and is implemented by all other shape classes.
 * Includes a toString method and a compareTo method for shape objects. 
 */
public abstract class Shape implements Comparable<Shape>
{
	protected double height;
	
	public Shape() 
	{
		
	}
	
	public Shape(double height)
	{
		this.height = height;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public void setHeight(double value) 
	{
		this.height = value;
	}
	
	public abstract double getVolume();
	
	public abstract double getBaseArea();

	@Override
	public int compareTo(Shape that)
	{
		if( this.height > that.height )
		{
			return 1;
		}
		else if( this.height < that.height )
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	@Override
    public String toString()
    {
    	return "The " + getClass().getSimpleName() + " has a height of: " + getHeight() + " and a base area of: " + getBaseArea() + ", giving it a volume of: " + getVolume() + "\n";
    }
	public String toString(String type)
    {
		if(type.equals("h")) {
			return "The " + getClass().getSimpleName() + " has a height of: " + getHeight() + "\n";
		}
		else if(type.equals("v")) {
			return "The " + getClass().getSimpleName() +" has a volume of: " + getVolume() + "\n";
		}
		else {
			return "The " + getClass().getSimpleName() +" has a base area of: " + getBaseArea() + "\n";
		}
    	
    }

}
