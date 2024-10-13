package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import shapes.*;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)
		
		File shapeFile = new File("res/shapes1.txt");
		Scanner scanFile = null;

		
		try
		{
			scanFile = new Scanner( shapeFile );
		}
		catch( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Take the first line in the text file (the total number of objects in file) and assign it as array size
		int arrSize = Integer.parseInt(scanFile.nextLine());
		Shape[] shapeArray = new Shape[arrSize];
		int i = 0;
		
		// Loop through the input file and create a new object for each line based on it's shape name
		while( scanFile.hasNext() )
		{
			
			String shape = scanFile.next();
			
			if (shape.contains("Cylinder"))
			{
				double height = scanFile.nextDouble();
				double radius = scanFile.nextDouble();
				shapeArray[i] = new Cylinder(height, radius);
			}
			else if (shape.contains("Cone"))
			{
				double height = scanFile.nextDouble();
				double radius = scanFile.nextDouble();
				shapeArray[i] = new Cone(height, radius);
			}
			
			else if (shape.contains("Pyramid"))
			{
				double height = scanFile.nextDouble();
				double sideLength = scanFile.nextDouble();
				shapeArray[i] = new Pyramid(height, sideLength);
			}
			else if (shape.contains("Prism"))
			{
				if (shape.contains("Square"))
				{	
					double height = scanFile.nextDouble();
					double sideLength = scanFile.nextDouble();
					shapeArray[i] = new SquarePrism(height, sideLength);
				}
				else if (shape.contains("Triangular"))
				{	
					double height = scanFile.nextDouble();
					double sideLength = scanFile.nextDouble();
					shapeArray[i] = new TriangularPrism(height, sideLength);
				}
				else if (shape.contains("Pentagonal"))
				{	
					double height = scanFile.nextDouble();
					double sideLength = scanFile.nextDouble();
					shapeArray[i] = new PentagonalPrism(height, sideLength);
				}
				else if (shape.contains("Octagonal"))
				{	
					double height = scanFile.nextDouble();
					double sideLength = scanFile.nextDouble();
					shapeArray[i] = new OctagonalPrism(height, sideLength);
				}
			}
		    i++;
		    

		}
		System.out.println(Arrays.toString(shapeArray));

		
		scanFile.close();
	}

}
