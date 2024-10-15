package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * The MergeSort class provides static methods to sort a Shape object array
 * using the merge sort algorithm. It supports sorting arrays either using the
 * natural ordering of the elements, if they implement Comparable, or using a
 * specified Comparator.
 */


/**
 * Sorts the specified array of Shape objects in ascending order, according
 * to the natural ordering of its elements. All elements in the array must implement
 * the Comparable interface.
 *
 * @param <Shape>         the type of elements in the array, which must extend {@code Comparable}
 * @param unsortedArray   the array to be sorted
 * @throws ClassCastException if the array contains elements that are not mutually comparable
 */
public class MergeSort 
{
    @SuppressWarnings("unchecked")
    public static <Shape extends Comparable<Shape>> void mergeSort(Shape[] unsortedArray)
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

    /**
     * Sorts the specified array of Shape objects in ascending order, according
     * to the order induced by the specified Comparator. All elements in the array
     * must be mutually comparable by the specified Comparator.
     *
     * @param <Shape>         the type of elements in the array
     * @param unsortedArray   the array to be sorted
     * @param comparator      the comparator to determine the order of the array
     * @throws ClassCastException if the array contains elements that are not mutually comparable
     *         using the specified comparator
     */
    @SuppressWarnings("unchecked")
    public static <Shape> void mergeSort(Comparable<Shape> unsortedArray[], Comparator<? super Shape> comparator)
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

    /**
     * Merges two sorted arrays, left and right, back into a single sorted array.
     * This method is used internally by the merge sort algorithm that sorts based on
     * the natural ordering of the elements.
     *
     * @param <Shape>         the type of objects in the arrays, which must extend Comparable
     * @param unsortedArray   the initial array and used to hold the merged result
     * @param left            the left array to merge
     * @param right           the right array to merge
     */
    private static <Shape extends Comparable<Shape>> void merge(Shape unsortedArray[], Shape left[], Shape right[])
    {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize) 
        {
            if (left[i].compareTo(right[j]) >= 0) 
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

    /**
     * Merges two sorted arrays, left and right, into a single sorted array.
     * This method is used internally by the merge sort algorithm that sorts based on
     * the order induced by the specified Comparator.
     *
     * @param <Shape>         the type of objects in the arrays
     * @param unsortedArray   the initial array and used to hold the merged result
     * @param left            the left array to merge
     * @param right           the right array to merge
     * @param comparator      the comparator to determine the order of the elements
     */
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
            if (comparator.compare((Shape) left[i], (Shape) right[j]) >= 0) 
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
