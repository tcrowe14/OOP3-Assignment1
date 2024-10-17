package utilities;

import java.util.Comparator;

import shapes.Shape;

public class HeapSort {
	static void heapify(Comparable<Shape> shapes[], int length, int root) {
		int largest = root;
		int leftIndex = 2*root + 1;
		int rightIndex = 2*root+2;
		if(leftIndex < length && ((shapes[leftIndex]).compareTo((Shape)shapes[largest]) <= 0)) {
			largest = leftIndex;
		}
		if(rightIndex < length && ((shapes[rightIndex]).compareTo((Shape)shapes[largest]) <= 0)) {
			largest = rightIndex;
		}
		if(largest != root) {
			Comparable<Shape> temp = shapes[root];
			shapes[root] = shapes[largest];
			shapes[largest] =  temp;
			heapify(shapes, length, largest);
		}
	}
	public static void heapSort(Comparable<Shape> shapes[],  Comparator<? super Shape> cmp) {
		int length = shapes.length;
		for(int i = length/2 - 1;i >= 0;--i) {
			if(cmp == null) {
				heapify(shapes, length, i);
			}
			else {
				heapify(shapes, length, i, cmp);
			}

		}
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
	static void heapify(Comparable<Shape> shapes[], int length, int root,Comparator<? super Shape> cmp) {
		int largest = root;
		int leftIndex = 2*root + 1;
		int rightIndex = 2*root+2;
		if(leftIndex < length && (cmp.compare((Shape)shapes[leftIndex],(Shape)shapes[largest])) <= 0) {
			largest = leftIndex;
		}
		if(rightIndex < length && (cmp.compare((Shape)shapes[rightIndex],(Shape)shapes[largest])) <= 0) {
			largest = rightIndex;
		}
		if(largest != root) {
			Comparable<Shape> temp = shapes[root];
			shapes[root] = shapes[largest];
			shapes[largest] =  temp;
			heapify(shapes, length, largest, cmp);
		}
	}

}
