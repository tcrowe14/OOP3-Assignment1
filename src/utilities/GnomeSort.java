package utilities;
import java.util.Comparator;

import shapes.Shape;
public class GnomeSort {
	//Get gnomed
	  public static void gnomeSort(Shape shapes[]) 
	  { 
	      int index = 0; 
	      int length = shapes.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          if (shapes[index].compareTo(shapes[index - 1]) < 0) 
	              index++; 
	          else { 
	        	  Shape temp; 
	              temp = shapes[index]; 
	              shapes[index] = shapes[index - 1]; 
	              shapes[index - 1] = temp; 
	              index--; 
	          } 
	      } 
	  }
	public static void gnomeSort(Shape shapes[], Comparator<? super Shape> cmp) 
	  { 
	      int index = 0; 
	      int length = shapes.length;
	      while (index < length) { 
	          if (index == 0) 
	              index++; 
	          if (cmp.compare(shapes[index],(shapes[index - 1])) <0) 
	              index++; 
	          else { 
	        	  Shape temp; 
	              temp = shapes[index]; 
	              shapes[index] = shapes[index - 1]; 
	              shapes[index - 1] = temp; 
	              index--;
	          } 
	      } 
	  }

}
