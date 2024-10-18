package utilities;

import java.util.Comparator;

import shapes.Shape;

/**
 * Heap sort is a sorting algorithm where the array is turned into a heap and then rearranged 
 * and the node on the heap is deleted from the heap so it can be sorted, in this sort, 
 * the smallest is put as the first found so it can be put at the end of the current position of the array
 * 
 */
public class HeapSort {
	/**
	 * Sorts the specified array of Shape objects in descending order, according
	 * to the natural ordering of its elements. All elements in the array must implement
	 * the Comparable interface.
	 * 
	 * @param shapes the array to be sorted
	 * @param length the size of the array being compared for the heap
	 * @param root the index of the array thats being checked with its children if it should be swapped
	 * @throws ClassCastException if the array contains elements that are not mutually comparable
	 */
	static void heapify(Comparable<Shape> shapes[], int length, int root) {
		//smallest is defaulted to the root, the children indexes of the root are calculated using the formulas in the variable
		int smallest = root;
		int leftIndex = 2*root + 1;
		int rightIndex = 2*root+2;
		//Check if the shape at the left index is smaller than the current shape in the smallest index, and swap if they are
		if(leftIndex < length && ((shapes[leftIndex]).compareTo((Shape)shapes[smallest]) <= 0)) {
			smallest = leftIndex;
		}
		//Check if the shape at the right index is smaller than the current shape in the smallest index, and swap if they are
		if(rightIndex < length && ((shapes[rightIndex]).compareTo((Shape)shapes[smallest]) <= 0)) {
			smallest = rightIndex;
		}
		//If smallest is not root, set the index to be the smallest and heapify again 
		if(smallest != root) {
			Comparable<Shape> temp = shapes[root];
			shapes[root] = shapes[smallest];
			shapes[smallest] =  temp;
			heapify(shapes, length, smallest);
		}
	}
	/**
	 * The entry to heapSort program, determined whether or not to use a heapify algorithm that contains a comparator
	 * Goes through every index in order to make the array a heap using heapify
	 * Then it one by one extracts the nodes from the heap
	 * 
	 * @param shapes the array to be sorted
     * @param cmp the comparator to determine the value being compared of the array
	 */
	public static void heapSort(Comparable<Shape> shapes[],  Comparator<? super Shape> cmp) {
		int length = shapes.length;
		// heapify the shapes array according to the called sort
		for(int i = length/2 - 1;i >= 0;--i) {
			if(cmp == null) {
				heapify(shapes, length, i);
			}
			else {
				heapify(shapes, length, i, cmp);
			}

		}
		//go through the heap from top to bottom, extract each element and put them at the current end of the unsorted array 
		//then heapify the next node with a reduced length
		for(int i= length -1;i>0;--i) {
			Comparable<Shape> temp = shapes[0];
			shapes[0] = shapes[i];
			shapes[i] = temp;
			if(cmp == null) {
				heapify(shapes, i, 0);
			}
			else {
				heapify(shapes, i, 0, cmp);
			}

			
		}
		
	}
	/**
	 * Sorts the specified array of Shape objects in descending order, according
	 * to the natural ordering of its elements. All elements in the array must implement
	 * the Comparable interface.
	 * 
	 * @param shapes the array to be sorted
	 * @param length the size of the array being compared for the heap
	 * @param root the index of the array thats being checked with its children if it should be swapped
     * @param cmp the comparator to determine the value being compared of the array
	 * @throws ClassCastException if the array contains elements that are not mutually comparable
	 */
	static void heapify(Comparable<Shape> shapes[], int length, int root,Comparator<? super Shape> cmp) {
		//smallest is defaulted to the root, the children indexes of the root are calculated using the formulas in the variable
		int smallest = root;
		int leftIndex = 2*root + 1;
		int rightIndex = 2*root+2;
		//Check if the shape at the left index is smaller than the current shape in the smallest index, and swap if they are
		if(leftIndex < length && (cmp.compare((Shape)shapes[leftIndex],(Shape)shapes[smallest])) <= 0) {
			smallest = leftIndex;
		}
		//Check if the shape at the right index is smaller than the current shape in the smallest index, and swap if they are
		if(rightIndex < length && (cmp.compare((Shape)shapes[rightIndex],(Shape)shapes[smallest])) <= 0) {
			smallest = rightIndex;
		}
		//If smallest is not root, set the index to be the smallest and heapify again 
		if(smallest != root) {
			Comparable<Shape> temp = shapes[root];
			shapes[root] = shapes[smallest];
			shapes[smallest] =  temp;
			heapify(shapes, length, smallest, cmp);
		}
	}

}
