package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * The BubbleSort class provides static methods to sort a Shape object array
 * using the bubble sort algorithm. It supports sorting arrays either using the
 * natural ordering of the elements, if they implement Comparable, or using a
 * specified Comparator.
 */
public class BubbleSort {
	
	/**
	 * Sorts the specified array of Shape objects in descending order, according
	 * to the natural ordering of its elements. All elements in the array must implement
	 * the Comparable interface.
	 *
	 * @param <Shape> the type of elements in the array, which must extend {@code Comparable}
	 * @param shapes the array to be sorted
	 * @throws ClassCastException if the array contains elements that are not mutually comparable
	 */
    public static void bubbleSort(Comparable<Shape> shapes[]) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < shapes.length - 1; i++) {
                // Compare adjacent elements
                if (shapes[i].compareTo((Shape) shapes[i + 1]) < 0) {
                    swapped = true;
                    // Swap shapes[i] and shapes[i + 1]
                    Shape temp = (Shape) shapes[i];
                    shapes[i] = shapes[i + 1];
                    shapes[i + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Sorts the specified array of Shape objects in descending order, according
     * to the order induced by the specified Comparator. All elements in the array
     * must be mutually comparable by the specified Comparator.
     *
     * @param shapes the array to be sorted
     * @param cmp the comparator to determine the order of the array
     * @throws ClassCastException if the array contains elements that are not mutually comparable
     *         using the specified comparator
     */
    public static void bubbleSort(Shape[] shapes, Comparator<? super Shape> cmp) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < shapes.length - 1; i++) {
                // Compare adjacent elements using the comparator
                if (cmp.compare(shapes[i], shapes[i + 1]) < 0) {
                    swapped = true;
                    // Swap shapes[i] and shapes[i + 1]
                    Shape temp = shapes[i];
                    shapes[i] = shapes[i + 1];
                    shapes[i + 1] = temp;
                }
            }
        }
    }
}
