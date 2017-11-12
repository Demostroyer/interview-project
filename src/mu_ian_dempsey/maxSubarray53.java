package mu_ian_dempsey;

/**
*Leetcode Q 53. 
*Idea: have two vars to store to the current sum, and the max number. 
*Loop through the entire array A. 
*sum is the returned value after calling max on, sum+A[i] -> so the sum plus the current index in A, and A[i -> just the value in A alone. 
*The max will be chosen, and a new subarray would be created if the second number, A[i], was chosen as this single number is bigger than the previous subarray
*Then we set the max to be the Math.max out of the old value for max, and the chosen answer for sum from before. 
*This will run for all values in the array A. Then just returning the value that is stored in max.
*@
*/
public class maxSubarray53 {

	     public int maxSubArray(int[] A) {
	       int newsum=A[0];//create the two vars holding the sum, and the max total found from the subarray
	       int max=A[0];
	       for(int i=1;i<A.length;i++){//go thru the array A
	           //the newsum is the result of getting the max between the old sum + the current number in A, and the single value in A itself.
	           //if the second is chosen, then the old subarray is overwritten and a single number is the biggest total so far
	           newsum=Math.max(newsum+A[i],A[i]); 
	           //now get the max between this chosen biggest number, and compare to the old max.
	           max= Math.max(max, newsum);
	       }
	       return max;
	    }
}