package mu_ian_dempsey;
/**
*Leetcode Q72.
*This is the edit distance problem. A staple when learning Dynamic Programming.
*Description: 
*Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
*You have the following 3 operations permitted on a word:
*a) Insert a character
*b) Delete a character
*c) Replace a character
*Idea:
*There are many subproblems overlapping, so I do not want to use a recursive solution. Even using a top-down approach would be very slow.
*So use a bottom-up approach. Bottom-Up: Where you start at the smallest values and work towards the goal. 
*Idea here: Have a matrix store the results of calculating how many steps it takes to get from one word to the other.
*Go through this matrix, and fill it up starting at the bottom right corner. -> bottom-up style!
*Now some conditions that could be true of both strings:
*1.If the first string is empty, only option is to insert all character of the second string.
*2.If the second string is empty, only option is to remove all character of the first string.
*3.If the two last characters in each are equal, then ignore them and look at the remaining characters.
*4.Finally if the current characters are different, consider all possible options, inserting a character, deleting a character or replacing a character, and get the minimum of these 3. This is the value which gets inserted into this position of the matrix. 
*Insert is : i, -1. Inserting one thing into second string to make it longer
*Deletion: i-1, j. Deleting one thing in first string to make it the same as the second
*Replacing: i-1,j-1. Copying from one to the other. 
*@author Ian Dempsey
*date 13/11/2017
*Pattern: Dynamic Programming
*Time Analysis: O(n * m) -> the lengths of our input strings
*Space Analysis: O(n *m) -> the lengths of our input strings
*/
public class minDistance72 {
	
	public static void main(String...args) {
		String word1="horse";
		String word2="ros";
		System.out.println("Number of edits required: " + minDistance(word1,word2));
	}
	

	    public static int minDistance(String word1, String word2) {
	        int m = word1.length();
	        int n = word2.length();
	        // Create a table to store results of subproblems
	        int dp[][] = new int[m+1][n+1];
	      
	        // Fill d[][] in bottom up manner
	        for (int i=0; i<=m; i++)
	        {
	            for (int j=0; j<=n; j++)
	            {
	                // If first string is empty, only option is to
	                // insert all characters of second string, the size of the second string is the minimum number of ops needed
	                if (i==0){
	                    dp[i][j] = j;  
	                }
	                // If second string is empty, only option is to
	                // remove all characters of first string, the size of the first string is the minimum number of ops needed
	                else if (j==0){
	                    dp[i][j] = i;
	                }
	                // If last characters are same, ignore last char
	                // and recur for remaining string
	                else if (word1.charAt(i-1) == word2.charAt(j-1)){
	                    dp[i][j] = dp[i-1][j-1];
	                }
	                // If last character are different, consider all
	                // possibilities and find minimum
	                else{
	                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
	                                       dp[i-1][j],  // Remove
	                                       dp[i-1][j-1]); // Replace
	                }
	            }
	        }
	        return dp[m][n];
	    }
	    /**
	    *A helper method that returns the smallest number out of an input of 3 numbers.
	    */
	    private static int min(int x,int y,int z)
	    {
	        if (x <= y && x <= z) {return x;}
	        if (y <= x && y <= z) {return y;}
	        else return z;
	    }
	}