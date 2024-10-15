package utilities;
import java.util.Comparator;

import shapes.Shape;
public class GnomeSort {
	//Get gnomed
	  public static void gnomeSort(Comparable<Shape> arr[]) 
	  { 
	      int index = 0; 
	      int length = arr.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          if (arr[index].compareTo( (Shape) arr[index - 1]) < 0) 
	              index++; 
	          else { 
	        	  Comparable<Shape> temp; 
	              temp = arr[index]; 
	              arr[index] = arr[index - 1]; 
	              arr[index - 1] = temp; 
	              index--; 
	          } 
	      } 
	  }
	public static void gnomeSort(Comparable<Shape> arr[], Comparator<? super Shape> cmp) 
	  { 
	      int index = 0; 
	      int length = arr.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          if (cmp.compare((Shape) arr[index],( (Shape) arr[index - 1])) == -1) 
	              index++; 
	          else { 
	        	  Comparable<Shape> temp; 
	              temp = arr[index]; 
	              arr[index] = arr[index - 1]; 
	              arr[index - 1] = temp; 
	              index--; 
	          } 
	      } 
	  }

}
