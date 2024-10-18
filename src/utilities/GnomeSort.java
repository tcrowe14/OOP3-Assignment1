package utilities;
import java.util.Comparator;

import shapes.Shape;
/**Get gnomed
 * Gnome sort (originally known as stupid sort) is a sorting algorithm that functions similarly to insertion sort, 
 * its difference being is that it doesn't use nested loops.
 * 
 */
public class GnomeSort {

	/**
	 * Sorts the specified array of Shape objects in descending order, according
	 * to the natural ordering of its elements. All elements in the array must implement
	 * the Comparable interface.
	 * 
	 * @param shapes the array to be sorted
	 * @throws ClassCastException if the array contains elements that are not mutually comparable
	 */
	public static void gnomeSort(Comparable<Shape> shapes[]) { 
		//Index keeps track of the current position in the array
	      int index = 0; 
	      int length = shapes.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          //if a smaller number is not found, the index is incremented
	          if (shapes[index].compareTo((Shape) shapes[index - 1]) <= 0) 
	              index++; 
	          //if the number to the left is smaller, it is swapped with the current index, and the index is decreased to compare with the next  index to the left
	          else { 
	        	  Shape temp; 
	              temp = (Shape) shapes[index]; 
	              shapes[index] = shapes[index - 1]; 
	              shapes[index - 1] = temp; 
	              index--; 
	          } 
	      } 
	  }
    /**
     * Sorts the specified array of Shape objects in descending order, according
     * to the order induced by the specified Comparator. All elements in the array
     * must be mutually comparable by the specified Comparator.
     *
     * @param shapes the array to be sorted
     * @param cmp the comparator to determine the value being compared of the array
     * @throws ClassCastException if the array contains elements that are not mutually comparable
     *         using the specified comparator
     */
	public static void gnomeSort(Comparable <Shape> shapes[], Comparator<? super Shape> cmp) { 
			//Index keeps track of the current position in the array
	      int index = 0; 
	      int length = shapes.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          //if a smaller number is not found, the index is incremented
	          if (cmp.compare((Shape)shapes[index],(Shape)(shapes[index - 1])) <= 0) 
	              index++; 
	          //if the number to the left is smaller, it is swapped with the current index, and the index is decreased to compare with the next  index to the left
	          else {
	        	  Shape temp; 
	              temp = (Shape) shapes[index]; 
	              shapes[index] = shapes[index - 1]; 
	              shapes[index - 1] = temp; 
	              index--;
	          } 
	      } 
	  }
	
}