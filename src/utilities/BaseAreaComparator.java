package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 *  Comparator class used to compare shapes base areas in the array
 */
public class BaseAreaComparator  implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		if( o1.getBaseArea() > o2.getBaseArea()) {
			return 1;
		}
		else if(o1.getBaseArea() < o2.getBaseArea()) {
			return -1;
		}
		return 0;
	}

}