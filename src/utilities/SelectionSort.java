package utilities;
import java.util.Comparator;

import shapes.Shape;
public class SelectionSort {
	public static void selectionSort(Comparable<Shape> shapes[]) {
		//mindex will keep track of what the current minimum number at an index, through each step through the for loop
		int mindex;
		//current will keep the current number at the current index inside of it so it can be moved if needed
		Shape current;
		//Outer for loop goes through every element of the array, until all elements are appropriately sorted
		for(int i = 0; i < (shapes.length);i++) 
		{
			//minimum index is kept track of whatever position in the area the loop is on
			mindex = i;
			//Inner for loop checks the current minimum index against everything to the right of it
			for(int ui = i+1;ui<shapes.length;ui++) 
			{
				//if a smaller number is found, the index of it is recorded so they can be swapped
				if(shapes[ui].compareTo((Shape) shapes[mindex])==1) 
				{
					mindex = ui;
				}
			}
			//Switches numbers around to sort them, current holds what number at the current index at this point in the loop, then the number at that index is swapped
			// with the minimum at the index found on the inner for loop
			current = (Shape) shapes[i];
			shapes[i] = shapes[mindex];
			shapes[mindex] = current;
	}
}
	public static void selectionSort(Comparable<Shape> shapes[], Comparator<? super Shape> cmp) {
		//mindex will keep track of what the current minimum number at an index, through each step through the for loop
		int mindex;
		//current will keep the current number at the current index inside of it so it can be moved if needed
		Shape current;
		//Outer for loop goes through every element of the array, until all elements are appropriately sorted
		for(int i = 0; i < (shapes.length);i++) 
		{
			//minimum index is kept track of whatever position in the area the loop is on
			mindex = i;
			//Inner for loop checks the current minimum index against everything to the right of it
			for(int ui = i+1;ui<shapes.length;ui++) 
			{
				//if a smaller number is found, the index of it is recorded so they can be swapped
				if(cmp.compare((Shape)shapes[ui], (Shape) shapes[mindex])==1) 
				{
					mindex = ui;
				}
			}
			//Switches numbers around to sort them, current holds what number at the current index at this point in the loop, then the number at that index is swapped
			// with the minimum at the index found on the inner for loop
			current = (Shape) shapes[i];
			shapes[i] = shapes[mindex];
			shapes[mindex] = current;
		}
	}

}
