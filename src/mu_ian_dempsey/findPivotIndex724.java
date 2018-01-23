package mu_ian_dempsey;
/*
*So I need to get the left sum of the index, and the right sum of it and compare. The index is not taken into account.
*If I knew the total sum of the input array, and then found the left halfs total, 
*I would be able to get the right half by getting the difference. 
*Then it is a matter of comparing the two totals and if they are equal return the index we are currently at. 
*If not, return -1.
*@author: Ian Dempsey
*date 23/01/18
*Pattern: No real pattern really.
*/
public class findPivotIndex724 {
	
	public static int pivotIndex(int[] nums) {
        int sum=0;
        int left=0;
        //for my own sanity I am changing this back to he version which did not work.
        for(int i = 0; i <nums.length;i++)
        	sum+=nums[i];
        //for(int i: nums) sum+=i;//getting the total sum!-> this works
        //something wrong with the loop, in the case of [1,7,3,6,5,6] I get total as 21, not 28.
        //Changing it to a for each loop.
        System.out.println("Value of sum : "+ sum);
        
        //now to get the left half's total.
        //i is our current index of the potential pivot.
        for(int i =0;i<nums.length;i++){
            //Here is the check, so if the value of the left half equals the result of getting the difference between the total and left
            //then we have a pivot index.
            //Error: I need to ALSO take away the current index value, or else I will never get the correct total for the right. 
            //As we are not counting the index value as part of the two halves.
            if(left == sum-left-nums[i]) return i;
            //How about instead of looping before checking, we check first, then add the most recent index to the value. 
            //This will make it faster, and also allow us to run only necessary parts.
            left+=nums[i];
        }
        
        return -1;//case it was not a pivot index.
    }
	
	public static void main(String...args) {
		int[]test= {1,7,3,6,5,6};
		System.out.println(pivotIndex(test));
		
	}

}
