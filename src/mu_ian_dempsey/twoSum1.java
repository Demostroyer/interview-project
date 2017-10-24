package mu_ian_dempsey;

import java.util.Arrays;
/*
 * This is the twoSum problem on leetCode. it is leetcode Q1
 * I have planned out the following approach:
 * given an array and a sum target, find a pair of digits which will equal that sum
 * ie [1,2,3,4] sum = 6. We can't assume they are in order, so must take that into account.
 * so can use two for loops, but is really slow, O(N^2)
 * can maybe take one element, say 2, then we know we need a four to get to 6, so we search for a 4. 
 *  this is a binary search and is O(log)
 * best would be using bounds. so take most extreme as a pair, if total is bigger, then move in the 
 * right upperbound, if it is less, then move in the left upperbound. 
 * stop cond:if we find a pair equalling our target, or if they cross = not found
 *  NOTE: i have taken into account negative numbers, unsorted arrays(which i sort to solve the Q)
 * @author Ian Dempsey
 * @date 19/09/2017
 * @version 1.1
 * The pattern that I found in this question is the PALINDROME pattern. 
 * Time analysis is: O(n) -> because this depends on the size of the String given
 * Space analysis is: O(n/2) ->because I am working on two elements at a given time. 
 * I realise that i could use a simple hashmap and do this quicker, but this was my logical way. 
 */
public class twoSum1 {
	public static void main(String [] args) {
		//example input
		int[] numArray= {1,2,3,4,5};
		int target=7;
		int[] pair=new int[2];
		pair=twoSum(numArray,target);
		System.out.println("index " +pair[0]+" "+ pair[1] );
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
        //create upper and lower bounds.
		int[]solution = new int[2];
		int lowerBound = 0;
		int upperBound = nums.length-1;
        int[] num2= Arrays.copyOf(nums,nums.length);//this is unsorted 
		//so now we must go through the array, looping with pairs. Condition based on the two bounds crossing
		while(lowerBound< upperBound) {
            //sort the array in here, so that the unsorted array is still outside. and therefore we can pull the unsorted arrays index out
            //as the answer
            Arrays.sort(nums);//turns an array of say {3,2,4} into {2,3,4}, this sorted array is then checked.
			//if the total is bigger than target, move left
			if(nums[lowerBound] + (nums[upperBound]) > target) {
				upperBound--;
			//if the total is smaller that then target, move right 	
			}else if(nums[lowerBound] + (nums[upperBound]) <target) {
				lowerBound++;
			//it was found then.
			}else {
				solution[0]=lowerBound;
				solution[1]=upperBound;
		   //	System.out.println("The pair of numbers totalling your target is " + nums[lowerBound] + " + "+ nums[upperBound]);
          //      System.out.println("index" + lowerBound + " " + upperBound);
				break;
			}
		}
		//now just return the index of the unsorted array, this will not affect input which is sorted. 
        int count=0;
        //using the copy of original arry which is unsorted
        for(int i =0;i <num2.length;i++){
        	//if the unsorted array's value at index i = our sorted arrays value at lowerBound index
        	//& count==0, (this just stops the index being overwrritten, applies to unsorted arrays)
           if(num2[i]==nums[lowerBound] && count==0) {
       //     System.out.println("num2[0]" + num2[0]);
               solution[0]=i;//first index for solution pair
               count++;
            }
           //in the original unsorted array, if the array's val at index i= sorted array's val at upper
            else if(num2[i]==nums[upperBound]){
                solution[1]=i;//second index for soultion pair
            }
        }
    return solution;
    }
}
