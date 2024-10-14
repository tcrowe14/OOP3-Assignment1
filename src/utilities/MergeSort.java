package utilities;

import java.util.Comparator;

public class MergeSort 
{
    @SuppressWarnings("unchecked")
    private static <Shape extends Comparable<Shape>> void mergeSort(Shape[] unsortedArray)
    {
        int arraySize = unsortedArray.length;

        if (arraySize < 2) 
        {
            return;
        }

        int split = arraySize / 2;
        Shape[] left = (Shape[]) new Comparable[split];
        Shape[] right = (Shape[]) new Comparable[arraySize - split];

        for (int i = 0; i < split; i++) 
        {
            left[i] = unsortedArray[i];
        }
        for (int i = split; i < arraySize; i++) 
        {
            right[i - split] = unsortedArray[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(unsortedArray, left, right);
    }

    @SuppressWarnings("unchecked")
    private static <Shape> void mergeSort(Comparable<Shape> unsortedArray[], Comparator<? super Shape> comparator)
    {
        int arraySize = unsortedArray.length;

        if (arraySize < 2) 
        {
            return;
        }

        int split = arraySize / 2;
        Comparable<Shape>[] left = new Comparable[split];
        Comparable<Shape>[] right = new Comparable[arraySize - split];

        for (int i = 0; i < split; i++) 
        {
            left[i] = unsortedArray[i];
        }
        for (int i = split; i < arraySize; i++) 
        {
            right[i - split] = unsortedArray[i];
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(unsortedArray, left, right, comparator);
    }

    private static <Shape extends Comparable<Shape>> void merge(Shape unsortedArray[], Shape left[], Shape right[])
    {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize) 
        {
            if (left[i].compareTo(right[j]) <= 0) 
            {
                unsortedArray[k++] = left[i++];
            } else {
                unsortedArray[k++] = right[j++];
            }
        }

        while (i < leftSize)
		{
			unsortedArray[k] = left[i];
			i++;
			k++;		
		}
		while (j < rightSize)
		{
			unsortedArray[k] = right[j];
			j++;
			k++;		
		}
    }

    @SuppressWarnings("unchecked")
	private static <Shape> void merge(Comparable<Shape> unsortedArray[], Comparable<Shape> left[], Comparable<Shape> right[], Comparator<? super Shape> comparator) 
    {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize) 
        {
            if (comparator.compare((Shape) left[i], (Shape) right[j]) <= 0) 
            {
                unsortedArray[k++] = left[i++];
            } else {
                unsortedArray[k++] = right[j++];
            }
        }

        while (i < leftSize)
		{
			unsortedArray[k] = left[i];
			i++;
			k++;		
		}
		while (j < rightSize)
		{
			unsortedArray[k] = right[j];
			j++;
			k++;		
		}
    }
}
