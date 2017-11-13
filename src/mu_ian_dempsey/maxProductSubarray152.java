package mu_ian_dempsey;

/**
* Leetcode Q152.
* Find the contiguous subarray within an array (containing at least one number) which has the largest product.
* For example, given the array [2,3,-2,4],the contiguous subarray [2,3] has the largest product = 6.
* Idea: Will need some vars to store the result, current max. Note, also need min.
* Go through the entire array. Note. need a temp var now because max will be overwritten before use in min.
* max must be updated as a result of getting the max of itself * nums[i] and nums[i]. 
* We then see where the max is, if the first is bigger then we know we are still in a contiguous array. 
* If the second, then a single digit is biggest, so update max to be the single digit value.
* Repeat this for min value. 
* Check if the value of max is bigger than stored result so far, if it is then update result. 
* @author Ian Dempsey
* Pattern found: Array traversal. Linear search perhaps
* Time Analyis: O(n) -> one search through the array
* Space Analysis0 O(n) -> the 3 created ints have little impact on the space required.
*
*/
public class maxProductSubarray152 {
		public static void main(String...args) {
			
		int[] arr = {2,3,3,-2,4};
		System.out.println("Answer: "+maxProduct(arr));
		}
		
	    public static int maxProduct(int[] nums) {
	        int result=nums[0];//create the vars holding the product, and the max, min total found from the subarray when multiplying
		    int max=nums[0];
	        int min=nums[0];
	        //now go through the array, always start at 1, as the single number alone is the greatest we have seen so far
		       for(int i=1;i<nums.length;i++){
	               int temp =max;//needed for the min check later
	               /*Update max to be the max of : itself * current index i in nums and the current min * current index in i. 
	                *Then must check if this returned max is bigger than the single digit at index i in nums.
	                *This line will take into account if a number breaks the subarray, and will then allow us to search for another 
	                *Update min to be min of: temp * current index i in nums and itself * current index i in nums. Then check to see if this multiplied value is smaller than the single digit at current index i in nums.   
	                */
		           max=Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]); 
	               min = Math.min(Math.min(temp * nums[i],min*nums[i]),nums[i]);
	               /*simply check if the max returned is bigger than the current result. 
	               	*If it is this means we are still going along good in the subarray, so update result.
	               	*If it is not, that means this single digit is bigger, and then must keep result as is.
	                */
	               if(max > result) result=max;
		       }
		       return result;//after going through the entire array, return the result.
	    }
}