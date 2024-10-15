package appDomain;

import java.io.File;
import utilities.*;
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
		String fileArg = args[0];
		String cmpArg = args[1].toLowerCase().replaceAll("-t", "");
		String sortArg = args[2].toLowerCase().replaceAll("-s", "");
		for(String arg: args) {
			System.out.println(arg);
			if(arg.substring(0,2).equals("-f") || arg.substring(0,2).equals("-F")) {
				fileArg = arg.replaceAll("-f", "").replaceAll("-F", "");
			}
			else if(arg.substring(0,2).equals("-t") || arg.substring(0,2).equals("-T")) {
				cmpArg = arg.replaceAll("-t", "").replaceAll("-T", "");
			}
			else {
				sortArg = arg.replaceAll("-s", "").replaceAll("-S", "");
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
		
//		long start, stop;
//		start = System.currentTimeMillis();
//		
//		stop = System.currentTimeMillis();
//		System.out.println("Time to sort: " + (stop - start) + " milliseconds");
		
//		Comparator vac = new VolumeComparator();
		
//		System.out.println("\nGnome Sorted");
//		SelectionSort.selectionSort(shapeArray);
//		System.out.println(Arrays.toString(shapeArray));
		
		System.out.println(fileArg + " " + cmpArg + " " + sortArg);
		
		System.out.println("\nOriginal Array: ");
		System.out.println(Arrays.toString(shapeArray));
		
		if (!Arrays.asList("b", "s", "i", "m", "q", "z").contains(sortArg) || !Arrays.asList("v", "h", "a").contains(cmpArg))
		{
			System.out.println("\nIncorrect arguements entered \n\nUsage: \nFor file location use: \n\t-f[location] \n\tie: -fres/shapes1.txt \n"
					+ "For sort by use: \n\t-t[v for volume, h for height, a for base area] \n\tie to sort by volume: -tv \n"
					+ "For selecting the sorting algorithm use: \n\t-s[b for bubble, s for selection, i for insertion, m for merge, q for quick, z for gnome] \n\tie to use quick sort -sq \n\n"
					+ "Full example for a file in the projects res folder, searching by height using bubble sort: \n\tjava -jar Sort.jar -fres/shapes1.txt -th -sb ");
		}
		else if (sortArg.equals("b"))
		{
			if (cmpArg.equals("v"))
			{

			}
			else if (cmpArg.equals("h"))
			{

			}
			else if (cmpArg.equals("a"))
			{

			}
		}
		else if (sortArg.equals("s"))
		{
			if (cmpArg.equals("v"))
			{

			}
			else if (cmpArg.equals("h"))
			{

			}
			else if (cmpArg.equals("a"))
			{

			}
		}
		else if (sortArg.equals("i"))
		{
			if (cmpArg.equals("v"))
			{

			}
			else if (cmpArg.equals("h"))
			{

			}
			else if (cmpArg.equals("a"))
			{

			}
		}
		else if (sortArg.equals("m"))
		{
			if (cmpArg.equals("v"))
			{

			}
			else if (cmpArg.equals("h"))
			{

			}
			else if (cmpArg.equals("a"))
			{

			}
		}
		else if (sortArg.equals("q"))
		{
			if (cmpArg.equals("v"))
			{
			System.out.println("\nQuick Sorted by Volume");
			
			VolumeComparator qsVol = new VolumeComparator();	
			QuickSort.quickSort(shapeArray, qsVol,  0, shapeArray.length -1);
			System.out.println(Arrays.toString(shapeArray));
			}
			else if (cmpArg.equals("h"))
			{
				System.out.println("\nQuick Sorted by Height");
				QuickSort.quickSort(shapeArray, 0, shapeArray.length -1);
				System.out.println(Arrays.toString(shapeArray));
			}
			else if (cmpArg.equals("a"))
			{
				System.out.println("\nQuick Sorted by Base Area");
				BaseAreaComparator qsBase = new BaseAreaComparator();
				QuickSort.quickSort(shapeArray, qsBase,  0, shapeArray.length -1);
				System.out.println(Arrays.toString(shapeArray));
			}
		}
		else if (sortArg.equals("z"))
		{
			if (cmpArg.equals("v"))
			{

			}
			else if (cmpArg.equals("h"))
			{

			}
			else if (cmpArg.equals("a"))
			{

			}
		}
		else
		{

		}
	}

}