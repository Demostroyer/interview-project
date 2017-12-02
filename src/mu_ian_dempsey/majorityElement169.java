package mu_ian_dempsey;
/*
*Idea: Have a counter. Like the one on unique character. 
*But it will have atleast the first element as the majority one.
*So set it to that, then go through the rest of the array, and just increment a temp var, 
*that is checking the frequency of the current one we are looking at. 
*Have a way to move onto a different element. Could be done with some form of frequency array, 
*this would work by incrementing the respective var found in the original array.
*@author: Ian Dempsey
*date: 25/11/17
*Time Analysis: O(n) -> size of array given affects the time for output. 
*Space Analysis: O(n) -> size of array given.
*/

public class majorityElement169 {

	    public int majorityElement(int[] num) {
	    	//major is first element to begin with. Count is 1 at first as the first element has a count of 1.
	        int major=num[0], count = 1;
	        for(int i=1; i<num.length;i++){
	            if(count==0){//if we ever reach 0, then it was not in it more than n/2.
	                count++;//add one to count to restart
	                major=num[i];//restart with the current element found at index i.
	            }else if(major==num[i]){
	                count++;//if we found the same element, ++.
	            }else count--;//else we didn't find it, so --.
	            
	        }
	        return major;
	    }
}