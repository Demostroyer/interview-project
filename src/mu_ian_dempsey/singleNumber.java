package mu_ian_dempsey;

import java.util.Arrays;

/**
 * This is a problem on leetcode, number 136.. 
 * Given an array of integers, every element appears twice, EXCEPT for one. Find this single integer. 
 * Idea: Sort the array first, as this will allow me to quickly check. The paired nums will be next to eachother then
 * Then go through this new sorted array, comparing adjacent values. Ifthe adjacent elements are the same, skip.
 * Skip is done by somply performing a second i++; 
 * Else,the two adjacent values are not equal, so we have found the single number! Return this number!
 * Time analysis is: O(n) -> because I am simply searching the array once.
 * Space analysis is: O(n) -> I believe because it is only storing the contents of the array once.
 * @author demps
 * The pattern in this is: 	
 */
public class singleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {12,23,45,3,12,23,5,45, 3,5,16};
		System.out.println("The unique number is: " + singleNumber(array));

	}
	
	public static int singleNumber(int[] nums) {
		// Sort the array.
		 Arrays.sort(nums);
		 int singleNum = 0;
 
		// Cycle through array comparing adjacent values.
		for(int i = 0; i < nums.length; i++){
		    // If the adjacent elements are the same, skip foward. 
		    if(i < nums.length-1 && nums[i] == nums[i+1]) {
		        i ++;
		}else {
		        // Otherwise, you found the single number.
		        singleNum = nums[i];
		    }
		}
		return singleNum;
	}

}
