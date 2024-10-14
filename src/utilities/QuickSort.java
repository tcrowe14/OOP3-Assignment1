package utilities;

import java.util.Comparator;
import shapes.Shape;

public class QuickSort
{		
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
	
	static void swap(Comparable<Shape> array[], int i, int j)
	{
		Comparable<Shape> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void quickSort(Comparable<Shape> array[], Comparator<? super Shape> cmp, int min, int max)
	{
		if (min < max)
		{
			int piv = partition(array, cmp, min, max);
			
			quickSort(array, cmp, min, piv - 1);
			quickSort(array, cmp, piv + 1, max);
		}
	}
		
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
