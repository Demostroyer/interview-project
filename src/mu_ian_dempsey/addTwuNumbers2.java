package mu_ian_dempsey;
/**
 * Leetcode Q 2. 
 * Description: You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *Basic idea: Go through each list, checking if the current node isn't null. If so, add it to the answer. 
 *Perform this inside a while loop, which checks if either list is empty. Use || check. 
 *Need to keep an eye on the issue of where the summation of the two vals from the lists is a double digit. 
 *So need to perform some modding by 10, to get it back down to a single digit for that columns.
 *Then need to add the remainder (which will never be bigger than ,as 9+9, 9 is the biggest single digit) to 
 *the variable which is performing the summation of values. 
 *I need to return a ListNode, so i need to make a listNode which will store the correct value for it's column
 *Then have a link to the next column storing the next integer. 
 * @author Ian Dempsey
 *
 */
public class addTwuNumbers2 {
    
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
       ListNode l3, temp = new ListNode(0);
       l3 = temp;
       while (l1 != null || l2 != null || carry != 0) {
        if (l1 != null) {
           carry += l1.val;
           l1 = l1.next;
           }
        if (l2 != null) {
           carry += l2.val;
           l2 = l2.next;
        }
           //this is done in the case where a number is bigger than the other. the biggest pair would be 9+9, 
           //so mod by 10, leaving 8, this 8 is put in at the respected position in the list. 
           //Then carry the 1 forward to the next bases
        l3.next = new ListNode(carry%10);
           //this is the equivalent of doing carry/10
       if(carry >=10){
           carry=1;
       }else{
           carry=0;
       }
       //mpve on l3 so i am not overwriting the values in the same node!
       l3 = l3.next;
   }
       //just keep returning the variable holding the values. 
   return temp.next;

   }
}
