

package utilities;

import java.util.Comparator;
import shapes.Shape;

public class InsertionSort {

    
    public static void insertionSort(Shape[] shapes) {
        for (int i = 1; i < shapes.length; i++) {
            Shape currentValue = shapes[i];
            int j = i - 1;

            // Change this to < 0 if you want descending order
            while (j >= 0 && shapes[j].compareTo(currentValue) < 0) { 
                shapes[j + 1] = shapes[j];
                j--;
            }

            shapes[j + 1] = currentValue;
        }
    }

    // Sort using a custom Comparator
    public static void insertionSort(Shape[] shapes, Comparator<? super Shape> cmp) {
        for (int i = 1; i < shapes.length; i++) {
            Shape currentValue = shapes[i];
            int j = i - 1;

            // Change this to < 0 if you want descending order
            while (j >= 0 && cmp.compare(shapes[j], currentValue) < 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }

            shapes[j + 1] = currentValue;
        }
    }
}

