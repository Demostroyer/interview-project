package mu_ian_dempsey;
/**
 * Leetcode Q: 70
 * What I noticed is that it is somewhat similar to fibonacci! Which is what I studied for DP, 
 * as: numWays(n) = numWays(n-1) + numWays(n-2);
 * At every step, you either can choose to take 1 or 2 steps.
 * so taking 1 step means we calculate the number of ways to complete n-1 steps +1.
 * Taking 2 steps means we calculate the number of ways to complete n-2 steps +1.
 * This comes from: 
 * number of ways to complete n steps = No of ways to complete (n-1)steps + No of ways to complete (n-2)steps
 * But note: values of numWays(n) = fibonacci(n+1); 
 * I could try to do a Top-Down + memoization approach. 
 * Storing every calculated result into an array! at position i. start i at 2. Similar to Fibonacci approach
 * @author Ian Dempsey
 * @date 20/11/17
 * Pattern is Dynamic Programming
 * Time Analysis: O(n)-> As we only go down to the base case (n steps away) once!
 * Space Analysis: O(n) -> we need to create an array of size n+1, but we drop the non-dominating values(1)
 *
 */
public class climbingStairs70 {
	
    public static int climbStairs(int n) {
        int []nums=new int[n+1];
        if(n <= 1) 
        	return 1;
        nums[0]=1;//base cases of the normal fibonacci
        nums[1]=1;
        for(int i =2;i< n +1;i++){//now start at the next empty slot(2 here) and figure it out with its predecessors.
            nums[i] = nums[i-1] + nums[i-2];//getting its value
        }
        return nums[n];
    }
    
    public static void main(String...args) {
    	int a = climbStairs(10);
    	System.out.println("Stairs with 10: " + a);
    }
}
