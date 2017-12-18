package mu_ian_dempsey;
/**
 * This is the supporting ListNode class used in the mergeTwoLists class.
 * This is used in the Leetcode Q21. 
 * @author Ian Dempsey
 * @date 5/10/17
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {val=x;}
	
	/* Function to print linked list */
	void printlist(ListNode head) 
	{
		while (head != null) 
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
