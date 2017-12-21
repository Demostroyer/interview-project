package mu_ian_dempsey;
/**
 * This is leetcode Question 387.
 * Find the first non repeating character in a given String.
 * My idea to find the first non repeating unique character is: Create an array of chars from the input String
 * then have a second int array that will store all of the frequencies of each letter in the array of chars. 
 * Go through the array of chars, and for each letter increment the corresponding position in the array of ints. 
 * Note: the array of ints is being used to represent the characters in their ASCII format, this means i must use the
 * int version of the chars. So use (int)c , meaning cast the char to it's int equivalent.
 * Finally go through the array of ints and find the first occurrence where the frequency is =1.   
 * If it is not found, return -1.
 * Analysis: Time Analysis: O(n) ->because it is only searching through the size of the arrays
 * Space analysis: O(n) -> 
 * @author Ian Dempsey
 *Pattern found in this Question: 
 */
public class uniqueChar387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String leetcode="iiaannppl";
		int index=firstUniqueChar(leetcode);
		System.out.println("The unique character first found was at index : "+index );
		char[]leetcode1=leetcode.toCharArray();
		try {
		System.out.println("This character was " + leetcode1[index] );
		}catch(IndexOutOfBoundsException e){
			System.out.println("There was no unique character.");
		}
	}
	
	public static int firstUniqueChar(String s) {
	     if(s.length() == 0) 
	    	 return -1;
	        int index = 0;
	        char[] arrChar = s.toCharArray();//an array of characters
	        int[] arrInt = new int[256];//every possible letter that could appear. -> in ASCII form!
	        for(char c : arrChar){//for every char in the array of characters
	            arrInt[(int)c]++;//increment the corresponding value in the array of integers. need to cast to int
	        }
	        //now simply go through the array of integer values, and see if it is = 1, if so break and return this value.
	        //NB: if the upperbound is set to arrInt, you go through the entire ASCII list. 
	        //this will then end up returning the index of the correct letter, but the index of this letter in the ASCII array
	        //this needs to be taken into account when doing the if statement. So check ONLY the values found in the charArray
	        //also I need to cast this charArray value to type int!!
	        for(int i = 0; i < arrChar.length; i++){
	            if(arrInt[(int)arrChar[i]] == 1){//only want to check the letters in the array of chars!
	                index = i;//set result to the index of this found letter.
	                //System.out.println("The index is: "+index+", the value of i is: "+i);
	                break;
	            }else
	            	index = -1;//else it was not found, so return -1.
	        }
	        return index;
	}

}