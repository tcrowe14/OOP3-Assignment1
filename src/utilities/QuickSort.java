package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Quick sort divides the array by creating a pivot variable to partition the array into 2 sub arrays, 
 * which then compares 2 objects and uses swap to rearrange the objects in descending order, and then 
 * recursively applies the process to both arrays and continues until only a single object remains as 
 * the final element in each partition.
 * 
 */

public class QuickSort
{		
    /**
     * Creates a partition pivot for the QuickSort algorithm to split the array and rearrange 
     * the Shape objects in descending order.
     *
	 * @param array           the comparable array to determine the order of the array
     * @param cmp             the comparator to determine the order of the array
     * @param min			  the lowest index position for the array
     * @param max             the last index position in the array
     * @return 				  returns the index +1 to move to the next indexed position
     */
	static int partition(Comparable<Shape> array[], Comparator<? super Shape> cmp, int min, int max)
	{
		Comparable<Shape> pivot = array[max];
		int i = min - 1;
		
		for (int j = min; j <= max -1; j++)
		{
			if (cmp.compare((Shape)array[j], (Shape)pivot) > 0)
			{
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, i + 1, max);
		return i + 1;
		
	}
	
    /**
     * Used to swap objects in the array when called from the partition
     * method when compared to other objects and determined to need to be swapped
     * in the array.
     *
     * @param array		      the comparable array to determine the order of the array
     * @param i 			  integer used as index positions to swap array objects
     * @param j			      integer used as index positions to swap array objects
     */
	
	static void swap(Comparable<Shape> array[], int i, int j)
	{
		Comparable<Shape> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
    /**
     * Sorts the specified array of Shape objects in descending order, according
     * to the order induced by the specified Comparator. All elements in the array
     * must be mutually comparable by the specified Comparator.
     *
     * @param array		      the comparable array to be sorted
     * @param min			  the lowest index position for the array
     * @param max             the last index position in the array
     * @param cmp             the comparator to determine the order of the array
     */
	public static void quickSort(Comparable<Shape> array[], Comparator<? super Shape> cmp, int min, int max)
	{
		if (min < max)
		{
			int piv = partition(array, cmp, min, max);
			
			quickSort(array, cmp, min, piv - 1);
			quickSort(array, cmp, piv + 1, max);
		}
	}
	
    /**
     * Creates a partition pivot for the QuickSort algorithm to split the array and rearrange 
     * the Shape objects in descending order.
     *
     * @param array		      the comparable array to be sorted
     * @param min			  the lowest index position for the array
     * @param max             the last index position in the array
     * @return 				  returns the index +1 to move to the next indexed position

     */
	
	static int partition(Comparable<Shape> array[], int min, int max)
	{
		Comparable<Shape> pivot = array[max];
		int i = min - 1;
		
		for (int j = min; j <= max -1; j++)
		{
			if (array[j].compareTo((Shape) pivot) > 0)
			{
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, i + 1, max);
		return i + 1;
		
	}
	
    /**
     * Creates a partition pivot for the QuickSort algorithm to split the array and rearrange 
     * the Shape objects in descending order.
     *
     * @param array		      the comparable array to be sorted
     * @param min			  the lowest index position for the array
     * @param max             the last index position in the array
     **/ 
	
	public static void quickSort(Comparable<Shape> array[], int min, int max)
	{
		if (min < max)
		{
			int piv = partition(array, min, max);
			
			quickSort(array, min, piv - 1);
			quickSort(array, piv + 1, max);
		}
	}
}
