package utilities;

public class MergeSort
{
	private static void mergeSort(int[] unsortedArray)
	{
		int arrayLength = unsortedArray.length;
		
		if (arrayLength < 2)
		{
			return;
		}
		
		int split = arrayLength / 2;	
		int[] left = new int[split];
		int[] right = new int[arrayLength - split];
		
		for (int i = 0; i < split; i++)
		{
			left[i] = unsortedArray[i];
		}
		for (int i = split; i < arrayLength; i++)
		{
			right[i - split] = unsortedArray[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(unsortedArray, left, right);
			
	}
	
	private static void merge (int[] inputArray, int[] left, int[] right)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < leftSize && j < rightSize)
		{
			if (left[i] <= right[j])
			{
				inputArray[k] = left[i];
				i++;
			}
			else
			{
				inputArray[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < leftSize)
		{
			inputArray[k] = left[i];
			i++;
			k++;		
		}
		while (j < rightSize)
		{
			inputArray[k] = right[j];
			j++;
			k++;		
		}
	}
}



