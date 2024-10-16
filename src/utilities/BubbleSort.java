package utilities;

import java.util.Comparator;
import shapes.Shape;

public class BubbleSort {

    public static void bubbleSort(Shape[] shapes) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < shapes.length - 1; i++) {
                // Compare adjacent elements
                if (shapes[i].compareTo(shapes[i + 1]) < 0) {
                    swapped = true;
                    // Swap shapes[i] and shapes[i + 1]
                    Shape temp = shapes[i];
                    shapes[i] = shapes[i + 1];
                    shapes[i + 1] = temp;
                }
            }
        }
    }

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

