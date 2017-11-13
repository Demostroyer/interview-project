package mu_ian_dempsey;

import java.util.HashMap;
import java.util.Map;

/*
Idea: Take in the pattern and get the length of it. If the length of it does not equal number of words in str, false.
Assign the parts of the pattern to the relevant areas of the str, this would mean checking if the current element of the str is assigned to a part of the pattern var. If so then check against the pattern if it is meant to be at that part of the pattern. If so continue onto the next part of the str, if not return false. 
I think this could be done using a HashMap of some sort. 
A HashMap could be used to store the pattern at each char, and then the index it was found. 
Compare to the equivalent position in the str(maybe use an array so it is easy to index!),
 and see if they are equivalent.  
If pattern is empty, and str !=empty then false. Visa versa.
Need to make i Integer, this was found out from a lot of trial and error. 
@author: Ian Dempsey
Pattern found: No real pattern in it.
Time Analysis: O(n * m)-> depends on the input given
Space Analysis: O() - > check with Hao
*/
public class wordPattern290 {
	    public boolean wordPattern(String pattern, String str) {
	        if(pattern == null && str == null) return true;//this should be allowed by definition
	        //get the number if words inside the str, and construct an array out of this splitting
	        String[] words = str.split(" ");//make an array of the str given where it splits on " ".
	        if(pattern.length() != words.length) return false;//if the pattern is a different size to the number of words inside the str it is false
	        Map map = new HashMap();
	        //now to assign the elements in the pattern to a slot in the Map!
	        for(Integer i =0;i<words.length; ++i){// NOTE: Needs to be Integer I, this is for boxing reasons.
	            if(map.put(pattern.charAt(i),i) != map.put(words[i],i)){
	                return false;
	            }
	        }
	        return true;
	    }
}

