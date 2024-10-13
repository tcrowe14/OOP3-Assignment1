package utilities;

public class QuickSort
{
	static int partition(Integer[] array, int min, int max)
	{
		int pivot = array[max];
		int i = min - 1;
		
		for (int j = min; j <= max -1; j++)
		{
			if (array[j] < pivot)
			{
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, max);
		return i + 1;
	}
	
	static void swap(Integer[] array, int i, int j)
	{
		int swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}
	
	static void quickSort(Integer[] array, int min, int max)
	{
		if (min < max)
		{
			int piv = partition(array, min, max);
			
			quickSort(array, min, piv - 1);
			quickSort(array, piv + 1, max);
		}
	}
}
