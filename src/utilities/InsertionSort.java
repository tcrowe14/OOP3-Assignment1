package utilities;

public class InsertionSort {
	
	public static void insertionSort( Integer[] nums) {
		
		for (int i = 1; i < nums.length; i++) {
			int currentValue = nums [i];
			int j = i - 1;
			
			while(j >= 0 && nums[j] > currentValue) {
				nums[j+1] = nums[j];
				j--;
			}
			
		nums[j+1] = currentValue;
		
		}	
		
	}

}

