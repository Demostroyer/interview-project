package mu_ian_dempsey;
/**
 * This is question 344 on leetcode.com
 * The question requires me to reverse a string.
 * My idea: change the string into a charArray, this will then be easy to work with, 
 * I will use a loop to go through the now charArray. I think swapping the elements will be easiest.
 * So have an element, i, as the start of the array, then j as the last element. Just swap them
 * Then decrement/increment the correct j,i respectively. 
 * To swap I will need a temp variable to hold one of the elements or else I will be just setting it to itself
 * and to return the string just cast to charArray to a String
 * Time analysis is: O(n) -> because this depends on the size of the String given
 * Space analysis is: O(n/2) ->because I am working on two elements at a given time. 
 * The pattern that I found in this question is the PALINDROME pattern. 
 * 
 * @author Ian Dempsey
 * @date 30/09/2017
 */
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}

	
	public static String reverseString (String s) {
        char[] word = s.toCharArray();//cast the string to a charArray
        int i = 0;//beginning index 
        int j = s.length() - 1;//the last index of the array
        while (i < j) {//this will stop when the two are equal
            char temp = word[i];//make a temp char to hold the first element
            word[i] = word[j];//now set first element to the last element
            word[j] = temp;//now set the last element to the first element by using the temp
            i++;//move up the i
            j--;//move down the j
        }
        return new String(word);//and cast it again to a String
	}
}
