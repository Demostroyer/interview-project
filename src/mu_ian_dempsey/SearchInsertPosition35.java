package mu_ian_dempsey;
/** Leetcode number 35
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
Basic Idea, search straight through for the target, but whilst doing this keep track of current index. 
As it is a sorted array, we just perform a check of the current index+1 in comparison to the target. if it is bigger, we stop!
and we return the current index of index, this current index is where we should put the value in if it would be inserted
If the comparison returns that it is equal, we simply return this value!
@author Ian Dempsey
@date 11/10/17
Time Analysis: O(n) -> depends on the size of the array
Space Analysis: O(n) -> depends on the size of the array
Pattern found: Basic linear search   
*/
public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        int index=0;
       int i=0;
        while(i<nums.length){
            index=i;
            //if the current index is the target, return it!
            if(nums[i]==target){
                return i;
            }
            //else it was not it!
            //now check if the next index is bigger than the target
            if(nums[i]>target){
                return i;//so return the index in which it would go if it was to be sorted.
            }
             i++;//so increase i
        }
        return i;   
    }
}
