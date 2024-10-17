package appDomain;

import java.io.File;
import utilities.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
	public static final String HSORT = "z";
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
	{
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
        for (String arg : args) 
        {
            if (arg.substring(0,2).equals("-f") || arg.substring(0,2).equals("-F")) 
            {
            	fileArg = arg.replaceAll("-f", "").replaceAll("-F", "");
            } 
            else if(arg.toLowerCase().substring(0,2).equals("-t")) 
            {
            	cmpArg = arg.toLowerCase().replaceAll("-t", "");
            } 
            else
            {
            	sortArg = arg.toLowerCase().replaceAll("-s", "");
            }
        }
//        String fileName = "";
//        if (!fileArg.isEmpty()) 
//        {
        	String fileName = new File(fileArg).getName();
//            fileArg = "res/" + fileName;
//        } 
//        else 
//        {
//            System.err.println("No file name provided.");
//            return;
//        }
		
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

		System.out.println("Sorting...");
		
		long start, stop;
		start = System.currentTimeMillis();
		
//		System.out.println("Original Array: ");
//		for (Shape shape : shapeArray) 
//		{
//			System.out.print(shape.toString(cmpArg));
//		}

		if (cmpArg.equals("h")) 
		{
			switch(sortArg) 
			{
			case BSORT:
				System.out.println("Bubble Sorted " + fileName + " by Height");
				BubbleSort.bubbleSort(shapeArray);
				break;
			case ISORT:
				System.out.println("Insertion Sorted " + fileName + " by Volume");
				InsertionSort.insertionSort(shapeArray);
				break;
			case SSORT:
				SelectionSort.selectionSort(shapeArray);
				System.out.println("Selection Sorted " + fileName + " by Height");
				break;
			case MSORT:
				System.out.println("Merge Sorted " + fileArg + " by Height");
				MergeSort.mergeSort(shapeArray);
				break;
			case QSORT:
				System.out.println("Quick Sorted " + fileName + " Height");
				QuickSort.quickSort(shapeArray, 0, shapeArray.length -1);
				break;
			case GSORT:
				System.out.println("Gnome Sorted " + fileName + " by Height");
				GnomeSort.gnomeSort(shapeArray);
				break;
			case HSORT:
				System.out.println("Heap Sorted " + fileName + " by Height");
				HeapSort.heapSort(shapeArray, null);
				break;
			}	
				
			
		}
		else 
		{
			String sortInd = (" ");
			Comparator cmp;
			if(cmpArg.equals("v")) 
			{
				cmp = new VolumeComparator();
				sortInd = ("Volume");
			}
			else 
			{
				cmp = new BaseAreaComparator();
				sortInd = ("Base Area");
			}
			switch(sortArg) 
			{
			case BSORT:
				System.out.println("Bubble Sorted " + fileName +" by " + sortInd);
				BubbleSort.bubbleSort(shapeArray, cmp);
				break;
			case ISORT:
				System.out.println("Insertion Sorted " + fileName +" by " + sortInd);
				InsertionSort.insertionSort(shapeArray, cmp);
				break;
			case SSORT:
				SelectionSort.selectionSort(shapeArray, cmp);
				System.out.println("Selection Sorted " + fileName +" by " + sortInd);
				break;
			case MSORT:
				System.out.println("Merge Sorted " + fileName +" by " + sortInd);
				MergeSort.mergeSort(shapeArray, cmp);
				break;
			case QSORT:
				System.out.println("Quick Sorted " + fileName +" by " + sortInd);
				QuickSort.quickSort(shapeArray, cmp,  0, shapeArray.length -1);
				break;
			case GSORT:
				System.out.println("Gnome Sorted " + fileName +" by " + sortInd);
				GnomeSort.gnomeSort(shapeArray, cmp);
				break;
			case HSORT:
				System.out.println("Heap Sorted " + fileName + " by Height");
				HeapSort.heapSort(shapeArray, cmp);
				break;
			}	
		}

		if (shapeArray.length > 0) 
		{
		    System.out.println("\nFirst sorted shape: " + shapeArray[0].toString(cmpArg));

		    if (shapeArray.length > 1000) 
		    {
		        System.out.println("\nThousandth values in between:");
		        for (int j = 1000; j < shapeArray.length; j += 1000) 
		        {
		            System.out.print((j) + "-th Shape is: " + shapeArray[j].toString(cmpArg));
		        }
		        System.out.println();
		    }
		    System.out.println("Last sorted shape: " + shapeArray[shapeArray.length - 1].toString(cmpArg));
		}

		stop = System.currentTimeMillis();
		System.out.println("\nTime to sort: " + (stop - start) + " milliseconds");
			
		if (!Arrays.asList("b", "s", "i", "m", "q", "g", "z").contains(sortArg) || !Arrays.asList("v", "h", "a").contains(cmpArg))
		{
			System.out.println("\nIncorrect arguements entered \n\nUsage: \nFor file location use: \n\t-f[location] \n\tie: -fres/shapes1.txt \n"
					+ "For sort by use: \n\t-t[v for volume, h for height, a for base area] \n\tie to sort by volume: -tv \n"
					+ "For selecting the sorting algorithm use: \n\t-s[b for bubble, s for selection, i for insertion, m for merge, q for quick, z for gnome] \n\tie to use quick sort -sq \n\n"
					+ "Full example for a file in the projects res folder, searching by height using bubble sort: \n\tjava -jar Sort.jar -fres/shapes1.txt -th -sb ");
		}
	}
}