package utilities;

import java.util.Comparator;
import shapes.Shape;

public class VolumeComparator implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		if( o1.getVolume() > o2.getVolume()) {
			return 1;
		}
		else if(o1.getVolume() < o2.getVolume()) {
			return -1;
		}
		return 0;
	}

}
