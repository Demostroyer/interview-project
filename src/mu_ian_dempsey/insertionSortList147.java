package mu_ian_dempsey;
/**
 * Q147. Description: Sort a linked list using insertion sort.
 *Check if is is empty, or one element only.
 * Need a helper method to perform the insertion part.
 *  1.Have current be a node that is th node to be inserted at first, also previous node that would be null initially.
 *  2.Then look for the position to insert the node into, use a while loop here, make sure current != null. Also the val check
 *  3.Once the while stops firing, the position to input is between previous node and current node. 
 *  4.Use an if else stmt, this allows checking of previous node !=null, if true then insertion is not at the head, so set next of previous 
 *  5.Else clause: it is at the head, so need to set the head to be this inserted node. Need global access to the head node. Or pass is in a parameter everytiime I call the method, which makes sense actually.
 *  6.Return head.next.
 * So this is the right idea, but it only works for lists of size 2. 
 * New idea:
 *1) Create an empty sorted (or result) list
 *2) Traverse the given list, do following for every node.
 * a) Insert current node in sorted way in sorted or result list.
 *3) Change head of given linked list to head of sorted (or result) list.
 *In my solution the new empty list is called temp.
 */
public class insertionSortList147 {
	
	public static void main(String...args) {
		ListNode list=new ListNode(3);
		ListNode list2=new ListNode(2);
		ListNode list3=new ListNode(1);
		list.next=list2;
		list.next.next=list3;
		System.out.println("Before sorting: ");
		list.printlist(list);
		System.out.println("\nAfter sorting: ");
		//list=insertionSortList(list);
		list.printlist(list);
		
	}	
	
    public ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		ListNode temp = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node to be inserted, it is initially the head of the list
		ListNode pre = temp; //insert node between pre and pre.next,could also be between pre and cur.
		ListNode next = null; //the next node to be inserted, tracks the value of the next node in the list
		//not the end of input list
		while( cur != null ){//this will fire as long as next is never null, which means that cur won't be null
			next = cur.next;//this will be used to track the next node to be inserted into it's correct position
			//find the right place to insert, similar to my previous solution
			while( pre.next != null && pre.next.val <= cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next, this is where the important steps happen
			cur.next = pre.next;//so the next value of cur will depend on how big pre is, pre being the SORTED list
			pre.next = cur;//we then set the next node in pre to be cur, this will always insert in the right place, as pre's value depends on the inner while loop above
			pre = temp;//reset the value of pre to temp, so it is back to 0 everytime.
			cur = next;//and update cur, so moving along in the list itself.
		}
		
		return temp.next;//return temp.next so to skip over the 0 which would be at the beginning of the temp list. 
	}
    
	/*
    public static ListNode insertionSortList(ListNode head) {

        if(head==null||head.next==null) return head;//it is already sorted if list is empty, or list has 1 element
        //break the list into 2 pieces: sorted and unsorted
        ListNode unsortedPart=head.next;
        //head.next=null;
        while(unsortedPart!=null){
            ListNode nodeToInsert = unsortedPart;
            unsortedPart=unsortedPart.next;//this line is an issue maybe
            head=insertInOrder(nodeToInsert,head);
        }
        //return the head.
        return head;
        
    }
    
    private static ListNode insertInOrder(ListNode nodeToInsert,ListNode head){
        ListNode current=head;
        ListNode prevNode =null;
        //locate insertion point, current must have a val, and also be less than the val of nodeToInsert
        while(current!=null && current.val <nodeToInsert.val){//think this is wrong, change to current.val from current.next.val
            prevNode=current;//move up one
            current=current.next;//move along one
        }//end while, once this doesn't fire, position to insert has been found
    
        //make insertion
        if(prevNode!=null){
            //insert between prevNode and current
            prevNode.next=nodeToInsert;
            nodeToInsert.next=current;
        }else{//insert at beginning, this is an issue, I do not have access to the head variable. 
        	head.next=null;//this will break if the list is more than 2 elements long. How do I get around this here. It has to be done though at certain points.
            nodeToInsert.next=head;//there is an infinite loop here, I have to set the next value of head to null here , then set nodeToInsert to head.?
            head=nodeToInsert;
        }//end if else
        return head;
    }//end the helper method insertInOrder
    */
	        
}

