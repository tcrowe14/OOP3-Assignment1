package utilities;

	public class BubbleSort {
		
		public static void bubbleSort( Integer[] nums) {
			boolean swapped = true;
				
			while (swapped) {
				
				swapped = false;
				for (int i = 0; i < nums.length - 1; i++) {
					if (nums [i] > nums [i+1]) {
						swapped = true;
						int temp = nums [i];
						nums [i] = nums [i+1];
						nums [i+1] = temp;
					}
				}
			}
		}
}

