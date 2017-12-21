package mu_ian_dempsey;
/**
 * This is the main class for leetcode Q 21. Description:
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * My idea: create the third node. Then have a while loop that will check if one of the lists is empty
 * Inside this have a few conditionals, so say if the first list is empty, then add second list to the new list
 * Don't forget to move on the second list then. Repeat this for the opposite case. 
 * Another conditional would be if the value of first link is < second list val. Then insert that into the new list
 * again must then move on first list to the next node. Repeat this for opposite case.
 * I need to do head=head.next inside this while loop but after the conditionals. Not sure why, must look into it more
 * Return the results next val.
 * @author Ian Dempsey
 * @date 5/10/17
 * Time analysis: O(n*m) because this is only dependant on how many elements are in the lists.
 */
public class mergeTwoLists21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);//create a new head node
        ListNode result = head;
        //whilst one of the list has elements still in them 
        while(l1!=null || l2!=null){
            if(l1==null){//so l1 is empty, use l2 in the above head ListNode
                head.next=l2;//set head's next link
                l2=l2.next;//move on l2
            }else if(l2==null){//so l2 is empty, use l1 in the head ListNode
                head.next=l1;//set head's next link
                l1=l1.next;//move on l1
            }else if(l1.val < l2.val){//else both have elements, and l1's val is bigger than l2's
                head.next=l1;//this keeps the list completely ordered!
                l1=l1.next;//again move on to l1's next node
            }else{//else l2 is the smaller
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        return result.next;
	}
}