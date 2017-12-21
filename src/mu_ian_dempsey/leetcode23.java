	package mu_ian_dempsey;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 *Q23. Description: Merge k sorted linked lists and return it as one sorted list.
 *I can use merge sort to solve this problem. Just break down the big lists into its individual parts. 
 *Then can simply build it back up! Will need to mess with my own mergesort method though.
 *I can use the mergeTwoLists solution somewhat for the merging part, but it will be a little bit different. 
 *For efficiency check if the list given is null straight away. If not just call recMergeSort
 *Then continue like normal for mergeSort! 
 *@author Ian Dempsey
 *date 10/10/2017	
 *Pattern:Merge Sort
 *Time Analysis: O(nlogn) -> Using mergesort so it is going to be this complexity. 
 *Space Analysis: O(n) -> Depends on the size of the list given.  
*/
public class leetcode23 {

	    public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length ==0) {return null;}//Doing this check now means I do not need to do it later
	        return recMergeSort(lists,0,lists.length-1);
	    }
	    
	    	public ListNode recMergeSort(ListNode[] lists,int lowerBound,int upperBound) {
			if(lowerBound==upperBound) {
				return lists[lowerBound];
			}
				//find midpoint! -> used to split the work area into halves.
				int mid =(lowerBound+upperBound) /2;
				//use recursion here to split the halves into their single elements. 
				ListNode l1=recMergeSort(lists,lowerBound,mid);//split the lower half
				ListNode l2=recMergeSort(lists,mid+1,upperBound);//split the upper half
				//now merge them!-> in this method I actually will sort the values. 
				return merge(l1,l2);
		}
	    /**
	    I can use the solution I used for mergeTwoLists. #21.
	    But need to alter it a good bit. No need for the while loop, do it recursively. 
	    */
	    public ListNode merge(ListNode l1, ListNode l2) {
	    	//If either of the lists given are empty, then simply return the other one as it is obviously the lower value. 
	        if (l1 == null) return l2;
	        if (l2 == null) return l1;
	        //If they both have values, sort them out by checking the value of each, and choosing appropriately.
	        if (l1.val < l2.val) {
	        	//l1's next value is the merging of l1 and l2. 
	            l1.next = merge(l1.next, l2);
	            return l1;
	        }
	        //else the opposite is true, so l2 is the smaller node currently. 
	        l2.next = merge(l1, l2.next);
	        return l2;
	    }

}
