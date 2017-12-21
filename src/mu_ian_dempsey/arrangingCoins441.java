package mu_ian_dempsey;
/**
 * Q441. Description:
 * You have a total of n coins that you want to form in a staircase shape, 
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * I have two solutions listed below. The first uses basic Math. It utilises a pattern that I discovered
 * whilst I was studying the examples given for the question. 
 * The second solution uses Binary Search. I found a second solution for this as I was not happy with the 
 * speed of the first solution. I wanted a faster more optimized one. After some thought I had discovered
 * that I could use Binary Search for this. 
 * 
 * @author Ian Dempsey
 *@date: 28/11/17
 */

public class arrangingCoins441 {
    /*
    This is one solution, it is using Math to solve the solution. 
    I spotted that the relationship between the increasing number of stairs being printed and the number that it is able to printed of the number of n given is related. 
    This is, as the stairs increases by 1 everytime, the number n decreases by this new stair value. 
    Therefore, the math is as follows: 
        Increase a variable i 1 every iteration, this is our step. 
        Decrease n after the new step has been incremented, so n-=i;
        The check is that if i is ever bigger than n, we stop as there is no way to keep printing more steps as i will be bigger than the value that is left in n. 
        Time Analysis: O(1)
        Space Analysis: O(1)
        */
    /*
    public int arrangeCoins(int n) {
        int count=0;//the variable that keeps track of what we were adding to i. 
        for(int i =1; i <= n;i++){
            if(i>n){
                return i--;
            }
            n=n-i;//the update is that we take away each step from n.
            count=i;
        }
        return count;  
    }*/
    /*
    The second way to complete this is with Binary Search. 
    This took sometime to spot, but the following works. 
    It follows the same idea above, that we need to take into account the steps being taken from 
    the total allowed n. But we discount whole halves as we go, 
    until the lower bound is higher than the upper bound. 
    This is Binary Search. 
    Time Analysis: O(1)
    Space Analysis: O(1)
    */
    public static int arrangeCoins(int n){
        int low=1;
        int high=n;
        //This is being done iteratively
        while(low<=high){
            int mid= low+(high -low)/2;//Use this mid formula to avoid overflow!
            if(mid * (mid+1L) <=2L*n) low=mid+1;//The case were we need to discard the left hand side. 
            else high =mid-1;//The case where we need to discard the right hand side. 
        }
        return high;//Once low is bigger than/equal to high, we have found the number of steps possible, so return it. 
    }
    
    public static void main(String ...args) {
    	System.out.println("Answer is: " + arrangeCoins(8));
    }
}
