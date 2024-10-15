package appDomain;

import java.io.File;
import utilities.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import shapes.*;

public class AppDriver
{
	public static final String BSORT = "b";
	public static final String ISORT = "i";
	public static final String SSORT = "s";
	public static final String MSORT = "m";
	public static final String QSORT = "q";
	public static final String GSORT = "g";
	@SuppressWarnings("unchecked")
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
		String fileArg = "";
		String cmpArg = "";
		String sortArg = "";
		for(String arg: args) {
			System.out.println(arg);
			if(arg.substring(0,2).equals("-f") || arg.substring(0,2).equals("-F")) {
				fileArg = arg.replaceAll("-f", "").replaceAll("-F", "");
			}
			else if(arg.toLowerCase().substring(0,2).equals("-t")) {
				cmpArg = arg.toLowerCase().replaceAll("-t", "");
			}
			else {
				sortArg = arg.toLowerCase().replaceAll("-s", "");
			}
		}

		File shapeFile = new File(fileArg);
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
		
		// Loop through the input file and create a new object for each line based on its shape name
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
		scanFile.close();

		long start, stop;
		start = System.currentTimeMillis();
		

		
//		Comparator vac = new VolumeComparator();
		
//		System.out.println("\nGnome Sorted");
//		SelectionSort.selectionSort(shapeArray);
//		System.out.println(Arrays.toString(shapeArray));
		System.out.println("\nOriginal Array: ");
		for (Shape shape : shapeArray) {
			System.out.print(shape.toString(cmpArg));
		}
		System.out.println();
		if (cmpArg.equals("h")) {
			switch(sortArg) {
			case BSORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case ISORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case SSORT:
				SelectionSort.selectionSort(shapeArray);
				System.out.println("\nSelection Sorted");
				break;
			case MSORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case QSORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case GSORT:
				GnomeSort.gnomeSort(shapeArray);
				System.out.println("\nGnome Sorted");
				
				break;
			}	
		}
		else {
			Comparator cmp;
			if(cmpArg.equals("v")) {
				cmp = new VolumeComparator();
			}
			else {
				cmp = new BaseAreaComparator();
			}
			switch(sortArg) {
			case BSORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case ISORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case SSORT:
				SelectionSort.selectionSort(shapeArray, cmp);
				System.out.println("\nSelection Sorted");
				break;
			case MSORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case QSORT:
				System.out.println("Not Implemented yet ;)");
				break;
			case GSORT:
				GnomeSort.gnomeSort(shapeArray, cmp);
				System.out.println("\nGnome Sorted");
				break;
			}	
		}
		for (Shape shape : shapeArray) {
			System.out.print(shape.toString(cmpArg));
		}
		stop = System.currentTimeMillis();
		System.out.println("\nTime to sort: " + (stop - start) + " milliseconds");
		
//		System.out.println("Original Array: ");
//		System.out.println(Arrays.toString(shapeArray));
//		
//		System.out.println("\nQuick Sorted by Volume");

//		VolumeComparator qsVol = new VolumeComparator();	
//		QuickSort.quickSort(shapeArray, qsVol,  0, shapeArray.length -1);
//		System.out.println(Arrays.toString(shapeArray));
//		
//		System.out.println("\nQuick Sorted by Base Area");
//		BaseAreaComparator qsBase = new BaseAreaComparator();
//		QuickSort.quickSort(shapeArray, qsBase,  0, shapeArray.length -1);
//		System.out.println(Arrays.toString(shapeArray));
//		
//		System.out.println("\nQuick Sorted by Height");
//		QuickSort.quickSort(shapeArray, 0, shapeArray.length -1);
//		System.out.println(Arrays.toString(shapeArray));


		//System.out.println(fileArg+ " "+ cmpArg + " "+ sortArg);
	}

}
