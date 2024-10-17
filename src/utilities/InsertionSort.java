ackage utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * The InsertionSort class provides static methods to sort a Shape object array
 * using the insertion sort algorithm. It supports sorting arrays either using the
 * natural ordering of the elements, if they implement Comparable, or using a
 * specified Comparator.
 */
public class InsertionSort {

	/**
	 * Sorts the specified array of Shape objects in descending order, according
	 * to the natural ordering of its elements. All elements in the array must implement
	 * the Comparable interface.
	 *
	 * @param <Shape> the type of elements in the array, which must extend {@code Comparable}
	 * @param shapes the array to be sorted
	 * @throws ClassCastException if the array contains elements that are not mutually comparable
	 */
    public static void insertionSort(Comparable<Shape> shapes[]) {
        for (int i = 1; i < shapes.length; i++) {
            Shape currentValue = (Shape) shapes[i];
            int j = i - 1;

            while (j >= 0 && shapes[j].compareTo(currentValue) < 0) { 
                shapes[j + 1] = shapes[j];
                j--;
            }

            shapes[j + 1] = currentValue;
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
    public static void insertionSort(Shape[] shapes, Comparator<? super Shape> cmp) {
        for (int i = 1; i < shapes.length; i++) {
            Shape currentValue = shapes[i];
            int j = i - 1;

            while (j >= 0 && cmp.compare(shapes[j], currentValue) < 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }

            shapes[j + 1] = currentValue;
        }
    }
}

