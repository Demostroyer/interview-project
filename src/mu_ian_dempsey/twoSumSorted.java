package mu_ian_dempsey;
/**
 * This is the twoSumSSorted Q on leetcode.com, number 167
 * This is very similar to the previously answered twoSum Q, 
 * main difference is that this one is not using zero-based indexing.
 * And also that this will be working on sorted arrays. 
 * @author Ian Dempsey
 * @date 19/09/17
 * Time analysis is: O(n) -> because this depends on the size of the String given
 * Space analysis is: O(n/2) ->because I am working on two elements at a given time. 
 * The pattern that I found in this question is the PALINDROME pattern. 
 */
public class twoSumSorted {

	public static void main(String[] args) {
		//a basic example
		int[] array= {1,2,3,4};
		int target=5;
		int[]pair=new int[2];
		pair=twoSum(array,target);
		//this is going to return a value that is 1 more than we are used to as it works on non-zero base
		System.out.println("index " +pair[0]+" "+ pair[1] );

	}
	//take out static when in leetcode.com
	 public static  int[] twoSum(int[] nums, int target) {
         //create upper and lower bounds.
		 int[]solution = new int[2];
		 int lowerBound = 0;
		 int upperBound = nums.length-1;
		 //so now we must go through the array, looping with pairs. Condition based on the two bounds crossing
		 while(lowerBound< upperBound) {
			 //sort the array in here, so that the unsorted array is still outside. and therefore we can pull the unsorted arrays index out
			 //as the answer
        
			 //if the total is bigger than target, move left
			 if(nums[lowerBound] + (nums[upperBound]) > target) {
				 upperBound--;
				 //if the total is smaller that then target, move right 	
			 }else if(nums[lowerBound] + (nums[upperBound]) <target) {
				 lowerBound++;
				 //it was found then.
			 }else {
				 solution[0]=lowerBound+1;
				 solution[1]=upperBound+1;
			//		System.out.println("The pair of numbers totalling your target is " + nums[lowerBound] + " + "+ nums[upperBound]);
      //      System.out.println("index" + lowerBound + " " + upperBound);
			break;
			 }
		 }
		 return solution;   
	 }

}
