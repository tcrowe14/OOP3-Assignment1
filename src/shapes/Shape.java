package shapes;


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

}
