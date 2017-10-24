package mu_ian_dempsey;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * This is leetcode Q 690. 
 * I believe it can be solved with some form of BFS. Where I must check the subordinates, which are just on
 * the lower level than the leader. This is exactly like a BFS problem. As I work down and across the tree 
 * Issue here is how to use the List data type itself, so I can access the correct information. 
 * Idea: Check if the List is empty, if id < 0 
 * Otherwise all good. So main part:
 * Create a queue q system as in BFS. Add in the id we are given( this is not the actual employee yet though!)
 * Them whilst q is not empty:
 * 		remove the head of q, put into temp. 
 * 		Next get the relevant employee. (Will need to look into this!)
 * 		Then enqueue all the relevant subordinates underneath the leader onto the q. 
 * 		Add the importance val to the total of the current employee in temp to the answer
 *  	Then start again, BUT do not add in the subordinates of the subordinates. (As far as I understand anyways!, will figure this out when I have built it for one level only.)
 *  	Finally once q is empty, return answer. 
 * Pattern here is BFS
 * 
 * @author Ian Dempsey
 *
 */
public class employeeImportance690 {
	/**
	 * Supplied by user on leetcode.com
	 * @author fallcreek 
	 *
	 */
	private class Employee{
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	}
	
    public int getImportance(List<Employee> employees, int id) {
        int total=0;
        //Base cases to terminate
        if(employees==null  || id<0) { return 0;}
        //the queue for the system of FIFO
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(id);//start off with something in the queue.
        while(!q.isEmpty()) {
        	//get the Id that is at the head of the queue. This is the one given as input: leader we work down from
        	int getCurrId = q.poll();
        	//to access the correct Employee. Must use a method in List class.
        	//best would be a getter. 
        	//get the corresponding employee at the relevant index supplied. 
        	Employee e = employees.get(getCurrId);//the temp Employee to hold the current employee off of the queue q
        	
        }
        return total;
    }

}
