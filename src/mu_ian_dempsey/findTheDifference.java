package mu_ian_dempsey;
/**
 * Leetcode Q:389
 Idea:
 convert both into charArrays. 
 Then create an int array which is going to be of size 25, this relates to the letters of the alphabet, including 0 index
 In this array i will increase the frequency of each character in the first string, by casting from the char in the first charArray to
 int. Then do the same for the second charArray. 
 All I have to do is then check for the odd one out in the second list by comparison of frequency.
 Then cast this int back to it's equivalent char!
 @author Ian Dempsey
 @date 5/10/17
 Time analysis: O(n) -> because I am only every traversing along the strings/charArrays. 
 Space Analysis: O(n) -> I have multiple arrays, but still remains as n
*/
public class findTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char answer = findTheDifference("aba","aabccccc");
		System.out.println("The added char is: " + answer);
	}
	 public static char findTheDifference(String s, String t) {
	        //a char to hold the answer in.
	        char answer=' ';
	        //convert both to charArrays
	        char[] first = s.toCharArray();
	        char[] second=t.toCharArray();
	        //the two arrays to hold frequencies
	        int[]firstArray = new int[256];//has to be 256 as it is converting into ASCII values
	        int[]secondArray=new int[256];
	        //now to put the frequencies into the above arrays
	        for(char c: first){
	            firstArray[(int)c]++;//increment the corresponding value in the array of integers. need to cast to int
	        }
	        for(char c: second){
	            secondArray[(int)c]++;//increment the corresponding value in the array of integers. need to cast to int
	        }
	        //now compare and find the unique odd one out. Can use a previous solution for this
	        for(int i =0; i< firstArray.length;i++){
	        	//this if stmt currently doesnt work for any case where string s has multiple of the same char, and
	        	//string t has even more chars of the same that was in s
	            if(firstArray[i] < secondArray[i]){//the firstArray has less frequency, 2nd has more freq,Found the odd one out
	                answer=(char)i;//so set the answer var to the char casted version of this i value of the secondArray
	            }
	        }
	        return answer;    
	    }
	}
