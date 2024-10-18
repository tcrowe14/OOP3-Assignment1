package utilities;
import java.util.Comparator;

import shapes.Shape;
/**
 * Selection sort takes the largest element in the array and swaps it with the first element.
 * Doing so each pass taking the next largest and placing it in the next index location until
 * all elements are sorted in descending order.
 */
public class SelectionSort {
	/**
	 * Sorts the specified array of Shape objects in descending order, according
	 * to the natural ordering of its elements. All elements in the array must implement
	 * the Comparable interface.
	 *
	 * @param shapes the array to be sorted
	 * @throws ClassCastException if the array contains elements that are not mutually comparable
	 */
	public static void selectionSort(Comparable<Shape> shapes[]) {
		//maxdex will keep track of what the current max number at an index, through each step through the for loop
		int maxdex;
		//current will keep the current number at the current index inside of it so it can be moved if needed
		Shape current;
		//Outer for loop goes through every element of the array, until all elements are appropriately sorted
		for(int i = 0; i < (shapes.length);i++) 
		{
			//max index is kept track of whatever position in the area the loop is on
			maxdex = i;
			//Inner for loop checks the current max index against everything to the right of it
			for(int ui = i+1;ui<shapes.length;ui++) 
			{
				//if a larger number is found, the index of it is recorded so they can be swapped
				if(shapes[ui].compareTo((Shape) shapes[maxdex])>=0) 
				{
					maxdex = ui;
				}
			}
			//Switches numbers around to sort them, current holds what number at the current index at this point in the loop, then the number at that index is swapped
			// with the  at the index found on the inner for loop
			current = (Shape) shapes[i];
			shapes[i] = shapes[maxdex];
			shapes[maxdex] = current;
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
	public static void selectionSort(Comparable<Shape> shapes[], Comparator<? super Shape> cmp) {
		//maxdex will keep track of what the current max number at an index, through each step through the for loop
		int maxdex;
		//current will keep the current number at the current index inside of it so it can be moved if needed
		Shape current;
		//Outer for loop goes through every element of the array, until all elements are appropriately sorted
		for(int i = 0; i < (shapes.length);i++) 
		{
			//max index is kept track of whatever position in the area the loop is on
			maxdex = i;
			//Inner for loop checks the current max index against everything to the right of it
			for(int ui = i+1;ui<shapes.length;ui++) 
			{
				//if a bigger number is found, the index of it is recorded so they can be swapped
				if(cmp.compare((Shape)shapes[ui], (Shape) shapes[maxdex])>=0) 
				{
					maxdex = ui;
				}
			}
			//Switches numbers around to sort them, current holds what number at the current index at this point in the loop, then the number at that index is swapped
			// with the max at the index found on the inner for loop
			current = (Shape) shapes[i];
			shapes[i] = shapes[maxdex];
			shapes[maxdex] = current;
		}
	}

}
