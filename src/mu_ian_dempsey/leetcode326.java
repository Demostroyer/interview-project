package mu_ian_dempsey;
/**
 * Given an integer, write a function to determine if it is a power of three.
 * Idea: Check first if n is 0 or negative, if so return false
 * Then the main idea is to: check if n is actually a number that has 3 as a factor, ie: 1,3,9,27,81 
 * are correct answers as 3^0,3^1,3^2,3^3,3^4 are these numbers respectfully. 
 * Then try to see if 3 divides into the n with no remainder(this means that 3 is a factor of it)
 * The true case is that the remainder is 1, as we eventually get down to 3/3=1 in the above loop, then guard asks:
 *1%3==0? returns false, so we have reached 1! And we know intuitively that 1 is a result of 3^0.       
 * @author Ian Dempsey
 *Time Complexity: O(logn) ->Number of divisions is given by the log 
  Space Complexity: O(1) -> no extra memory needed
  Pattern in this Q is: 
 */
public class leetcode326 {
	public static void main(String [] args) {
		for(int i =50; i<=81;i++) {
		System.out.println("Test with i: " + i);
		System.out.println("Result with isPowerOfThree "+isPowerOfThree(i));
		System.out.println("");
		}
	}
	
	 public static boolean isPowerOfThree(int n) {
	        if(n<1){return false;}//negative numbers are not allowed
	        //want to check if n is actually a number that has 3 as a factor, ie: 1,3,9,27,81 are correct answers as 3^0,3^1,3^2,3^3,3^4 are these
	            //numbers respectfully. 
	            //main idea then is to try to see if 3 divides into the n with no remainder(this means that 3 is a factor of it)
	            while(n %3==0){//whilst n mod 3 is 0
	                //now need to get closer to 3! So divide n by 3
	                n/=3;
	            }
	            //the true case is that the remainder is 1, as we eventually get down to 3/3=1 in the above loop, then guard asks:
	            //1%3==0? returns false, so we have reached 1! And we know intuitively that 1 is a result of 3^0. 
	            if(n==1){
	                return true;
	            }
	            return false;//finally it is not.
	   }
}
