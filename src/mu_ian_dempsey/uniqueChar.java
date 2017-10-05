package mu_ian_dempsey;
/**
 * This is leetcode Question 387.
 * My idea to find the first non repeating unique character is: Create an array of chars from the input String
 * then have a second int array that will store all of the frequencies of each letter in the array of chars. 
 * Go through the array of chars, and for each letter increment the corresponding position in the array of ints. 
 * Note: the array of ints is being used to represent the characters in their ASCII format, this means i must use the
 * int version of the chars. So use (int)c , meaning cast the char to it's int equivalent.
 * Finally go through the array of ints and find the first occurrence where the frequency is =1.   
 * If it is not found, return -1.
 * Analysis: T -> O(n) because it is only searching through the size of the arrays
 * S -> not sure, as I have two arrays being stored, which would still be n I believe. 
 * @author demps
 *Pattern found in this Question: 
 */
public class uniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String leetcode="iiaannp";
		System.out.println("The unique character first found was : "+ (char)firstUniqueChar(leetcode));

	}
	
	public static int firstUniqueChar(String s) {
		/*char[] letters = s.toCharArray();//change the string to a chararray, easy to parse
		char unique =letters[0];//set the unique var to be the first letter
		int j=1;//set j to be 1 more than unique, so it is always ahead of it.	
		for(int i = 1; i <letters.length;i++) {//go through the array, start off ahead of unique 
			int count=0;//need this to check if the current letter has been found more than once.
			if(unique==letters[i]) {//if the char c is equivalent to unique, then it is not unique!
				count++;//increment the count var, so I know that it is not unique!
			}
			if(count>1){//if there has been more than 1 occurrence of the char we are currently looking at
				j++;//move j up by one, this will allow me to set unique to the next var after current position.
				unique=letters[j];//move on unique!
			}else if(i<letters.length){//else count is not bigger than 1, so we either have not found a unique char, OR not finished
				continue;
			}else{//else we have reached the end of the search and not found it! So return -1
				return -1;
			}			
			//finally:we have reached the end, and we have found any unique char and we found a second copy of a char where 
			 //i moved the search forward , return unique at the current position!
			//need a way to check if it has gone the entire way through and not found it. set unique to -1. 
		} return unique;
		*/
	     if(s.length() == 0) {return -1;}
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
	            }else{index = -1;}//else it was not found, so return -1.
	        }
	        return index;
	}

}