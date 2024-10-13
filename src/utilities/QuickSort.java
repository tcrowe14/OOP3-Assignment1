package utilities;

import shapes.Shape;

public class QuickSort
{
	static int partition(Shape[] array, int min, int max)
	{
		Shape pivot = array[max];
		int i = min - 1;
		
		for (int j = min; j <= max -1; j++)
		{
			if (array[j].getVolume() < pivot.getVolume())
			{
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, i + 1, max);
		return i + 1;
		
	}
	
	static void swap(Shape[] array, int i, int j)
	{
		Shape temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void quickSort(Shape[] array, int min, int max)
	{
		if (min < max)
		{
			int piv = partition(array, min, max);
			
			quickSort(array, min, piv - 1);
			quickSort(array, piv + 1, max);
		}
	}
}
