package mu_ian_dempsey;
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Idea: note need to trim the string straight away, it causes error if not done. Even when splitting on ' '
 * Create a word array which is the input s split on ' '. 
 * Create a String that is the last word.
 * Return the length of this String
 * @author Ian Dempsey
 * Pattern: String/array manipulation.
 * Time analysis: O(n) -> depends on the input given
 * Space analysis: O(n)-> creating the array has little impact as the size of the array depends on input
 */

public class lengthOfLastWord58 {
	
	public static void main(String ...args) {
		String s = "Hi how are you today";
		System.out.println("Answer is: " + lengthOfLastWord(s));
	}

    public static int lengthOfLastWord(String s) {
        s=s.trim();
        String[] words = s.split(" ");//create an array where it is split on all spaces
        String last=words[words.length-1];//create a string to hold the last word.
        return last.length(); //return its length
    }
}
