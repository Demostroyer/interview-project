package mu_ian_dempsey;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode Q205.
*Using a map is really useful here. -> Allows only one mapping between letters. 
*If another tries to exist with either the key or value mapping to some other, then it is not an isomorphic pair of words.
*Use it to store the value associated between the two strings, String s is our keys, String t is our values. 
*Can check if they are already in the map.
*If so we then check if the current key from s, is equal to the value we are currently looking at in t.
*if they are equal, then we just keep looping through the two strings. 
*if it is not equal then we return false. As this shows they are not isomorphic.
*If the current key has not been inserted into the map yet, then we have to insert it. 
*Note: check if the value from t is in the map already, if so return false. 
*else just use .put(s,t).
*@author Ian Dempsey
*Pattern here: Map manipulation
*Time Anaylsis: O(n) -> it depends on the size of the input. 
*Space Analysis: O(n) -> defined by the size of the input for the size of the Map.
*/

public class isomorphicStrings205 {
	       public boolean isIsomorphic(String s, String t) {
	        if(s == null || s.length() <= 1) return true;//some base cases to take care of
	            //map to store them as <K,V> pairs. 
	        Map<Character, Character> myMap = new HashMap<Character, Character>();
	        for(int i = 0 ; i< s.length(); i++){//loop through and text
	            char key = s.charAt(i);//getting the character for key and value. These will be inserted and checked in the map
	            char val = t.charAt(i);
	            if(myMap.containsKey(key)){//if the key has already been inserted
	                // then we need to check if the key's value, is the same as what we are trying to insert into the map as value
	                //if it is the same, then just continue
	                 if(myMap.get(key).equals(val)) continue;
	                else return false;//else it is not the same as what is already in the map, and therefore is false.
	            }else{//if the key is not in the map yet
	                //Check if the value is already in the map, if not we have not got this Key Value pair yet, so add it in
	                if(!myMap.containsValue(val)) myMap.put(key,val);
	                else return false;//else th value exisits in it, but for another key, so we have return false.
	            }
	        }//if this runs through with no fail, return true.
	        return true;
	    }
	}