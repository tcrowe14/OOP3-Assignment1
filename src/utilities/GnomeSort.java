package utilities;
import java.util.Comparator;

import shapes.Shape;
public class GnomeSort {
	//Get gnomed
	  public static void gnomeSort(Comparable<Shape> shapes[]) { 
	      int index = 0; 
	      int length = shapes.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          if (shapes[index].compareTo((Shape) shapes[index - 1]) < 0) 
	              index++; 
	          else { 
	        	  Shape temp; 
	              temp = (Shape) shapes[index]; 
	              shapes[index] = shapes[index - 1]; 
	              shapes[index - 1] = temp; 
	              index--; 
	          } 
	      } 
	  }
	public static void gnomeSort(Comparable <Shape> shapes[], Comparator<? super Shape> cmp) { 
	      int index = 0; 
	      int length = shapes.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          if (cmp.compare((Shape)shapes[index],(Shape)(shapes[index - 1])) <0) 
	              index++; 
	          else {
	        	  System.out.println(""+index);
	        	  Shape temp; 
	              temp = (Shape) shapes[index]; 
	              shapes[index] = shapes[index - 1]; 
	              shapes[index - 1] = temp; 
	              index--;
	          } 
	      } 
	  }
	
}