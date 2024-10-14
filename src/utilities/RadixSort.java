package utilities;

import java.util.Random;
import shapes.Shape;
public class RadixSort {
	public static void radixSort(Shape[] shapes) {
		//bigNum will hold the biggest number in the array, this is so we can determine how many digits need to be sorted for the algorithm
		double maxVolume= shapes[0].getVolume();
		int length = shapes.length;
		//Loop checks to find the biggest number
		for(int i = 1; i < length;i++) {
			if(shapes[i].getVolume() > maxVolume) {
				maxVolume = shapes[i].getVolume(); 
			}
		}
		//This for loop will go through each digit or base of of the numbers in the array
		//we start at the 1's digits, we loop through as long as the maxNum / digit position is greater than 0 (ints default to 0 when they are decimals-
		//So when digits gets bigger than maxNum, the result of maxNum/digit will be 0
		//We increment digit by base 10 to go through every set of digits in the array numbers
		for(int digit = 1; maxVolume / digit > 0; digit*=10) {
			//countingSort is used to sort each digit in the array, function is called for simplicity
			countingSort(shapes,digit,length);
		}		
	}
	//We implement counting sort to sort the array according to each digit, we take our array as the input and the digit position
	static void countingSort(Shape[] shapes, int digit, int length) {
		//result array will hold the sorted array according to digits, will use this at the end to apply to the original array
		//count will be used for holding the count of each digit
		Shape result[] = new Shape[length];
		int count[] = new int[10];
		//stores how often a digit occurs in count
		for(int i = 0; i < length;i++) {
			//we divide the number in our array by digit so we can get the proper position, and use  10 to get only the remaining digit we want
			//Then we increment the index of count at that point by 1 so that we can count the total occurrences of that digit
			count[(int) ((shapes[i].getVolume()/digit)%10)] += 1;
		}
		//we change count to contain the cumulative sum for itself
		for(int i = 1; i < 10;i++) {
			count[i] += count[i-1];
		}
		//We loop to sort our array into the results array, we start from the top of the stack or end of array to preserve the order of elements that are equal in the sort
		for(int i= length-1; i>=0; i--) {
			//we get the resulting index of a number from nums[i] getting the position of the digit from the count array
			result[count[(int) ((shapes[i].getVolume()/digit)%10)]-1] = shapes[i];
			//we take 1 out of the position of the count array since multiple numbers can have the same digits
			count[(int) ((shapes[i].getVolume()/digit)%10)] -=1;
		}
		//We apply the sorted results array to our original array to sort it for this set of digits
		for(int i =0; i< length; i++) {
			shapes[i] = result[i];
		}
	}

	public static final int SIZE = 1000000;
	public static final int UPPER_BOUND = 100000;

	public static void main( String[] args )
	{
		
		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();
		
		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
			System.out.println( nums[i] );
		}
        int n = nums.length;

        // Function Call
        //radixSort(nums);
    }
	
	
	
	
}