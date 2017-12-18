package mu_ian_dempsey;

import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode Q336: Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]].The palindromes are ["battab", "tabbat"]
 * Idea: Go through the input, and for every word in it, try to see if it is a palindrome when you add it to 
 * a word which follows it in the input. 
 * Will need 2 for loops for this, one for the base word, and the second for the word we are trying to join it to. 
 * Then we check if these make a palindrome, call the helper method. 
 * This helper method just concatenates the two strings, and then runs through them checking if they are a palindrome. 
 * If they return true, then we need to create a list of the indices of the palindrome, and add into the result List. 
 * Need to check both ways to see if the palindrome is created by adding them together in both directions.
 * After we have gone through the entire way , just return the result list.
 * @author Ian Dempsey
 * @date: 12/11/2017
 * Pattern : Palindrome
 * Time ANalysis: O(n^2) - > two loops
 * Space Analysis: O(n)
 *
 */
public class palindromePairs336 {
	
	public List<List<Integer>> palindromePairs(String[] words) {
        //base check, if words is empty, return null
		if(words.length==0) 
			return null;
        //storing the solution pairs
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    	//go through the array. Have j be 1 ahead of i to start
    	for(int i =0; i <words.length;i++){
        	//always have j 1 ahead, so when we move i ahead, j moves too. As no need to check if the previous words before i are a pair with it, as thye would have alraedy been tested!
        	for(int j =i+1; j<words.length;j++ ){
            	//now check if these 2 words make a palindrome, if so need to make a list out of them, and then add into result.
            	if(palindromeCheck(words[i],words[j])){
                	List<Integer> pals = new ArrayList<Integer>();//need to recreate it everytime so only 2 are in it when adding into result
                	pals.add(i);//make sure ot add in the correct way, NOTE adding in the indices, not the words themselves
                	pals.add(j);
                	//now add into result
                	result.add(pals);
            	} 
            	if(palindromeCheck(words[j],words[i])){//checking the other way to pair just in case
            		List<Integer> pals = new ArrayList<Integer>();//need to recreate it everytime so only 2 are in it when adding into result
                	pals.add(j);//make sure to add in the correct way, but it is opposite this time
                	pals.add(i); //NOTE adding in the indices, not the words themselves
                	//now add into result
                	result.add(pals);
            	}
        	}
    	}//once i have gone through all of the words, just return the result list
    	return result;
	}
	//the private helper method: it checks if something is a palindrome	
	private boolean palindromeCheck(String words,String words2){
		//first concatenate them 
		String tester = words+words2;
		int lower =0 ;//start at beginning
		int upper = tester.length()-1;//start at end        
		while(lower<upper){//now go thru and test if it is a palindrome, condition: if they cross then we have a palindrome!
			if(tester.charAt(lower) != tester.charAt(upper)){//if they are ever notequal, then it is not a palindrome
				return false;//return false
			}else{//else they two were equal, and keep moving closer
				lower++;
				upper--;
			}
		}
		return true;//if we make it out of the while loop, then we know it is a palindrome! So return it to the main method above
	}

}
