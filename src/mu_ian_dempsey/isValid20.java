package mu_ian_dempsey;
/**
*Using a stack is the best way to do this
*Pattern here will be some form of palindrome.
*Idea is simple:
*Scan through the input string, ignore all characters which are NOT a  (){}[]
*Everytime come across an open bracket, push it onto the stack. Everytime you come across a closing bracket, pop
*off of the stack and compare the two brackets. If they are equal, keep moving on. 
*If they are not equal, then set a boolean bariable to false and return it.
*I can have a helper method that is called isPaired(). It takes in the two potential matching brackets. 
*Then just returns if the stmt of say: open==( && close == ), is true. Repeat for all 3 types. 
*@author Ian Dempsey
*@Date 06/11/17
*Pattern: Stack manipulation. Palindrome possibly. 
*Time Analysis: O(n)->because the insertion and removal off of the stack is fast.  
*Space Analysis: Depends on the string inputted, so it is O(n).
* 
*/

import java.util.Stack;

public class isValid20 {
	
	    public boolean isValid(String s) {
	        Stack st = new Stack();
	        int charCount = s.length();
	        
	        boolean isBalanced = true;//used for return stmt
	        int index=0;
	        char nextChar = ' ';
	        //note, no declaration of the indexer needed.
	        for(; isBalanced && (index < charCount);index++){
	            nextChar = s.charAt(index);
	            
	            //now this is where the main stuff happens. SO skip over any chars which are not {}[]()
	            //for every opening bracket, PUSH onto the stack, then when there is a closing bracket, pop off the stack, then compare what 
	            //was popped off with what we are currently indexed at. If they are the same, keep going. If nto the same return false!
	            
	            switch(nextChar){
	                case '(' : case '[' : case '{':
	                    st.push(new Character(nextChar));//just casting to Char so can do easy comparison later
	                    break;
	                    
	                case ')' : case ']' :case'}':
	                //now check if this is equal to the top of the stack
	                    if(st.isEmpty()) {isBalanced=false;}
	                    else{
	                        Character open = (char)st.pop();
	                        char openBrack = open.charValue();
	                        isBalanced = isPaired(openBrack,nextChar);//helper function. Comparing if the value on the stack is the same as the current value we are at in the string
	                    }//end ifelse
	                    break;
	                    
	                default:break;
	            }//end switch
	        }//end for
	        
	        if(!st.isEmpty()){isBalanced=false;}//if after everything the stack has stuff on it still, then it is false as missing brackets
	        
	        return isBalanced;
	    }//end isValid
	    
	    private boolean isPaired(char open, char close){
	        return (open=='(' && close == ')') ||
	               (open=='{' && close == '}') ||
	               (open=='[' && close == ']');
	    }//end ispPaired
	}//end Solution class