package section_16_hashTableProblems;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    
	   public static Character firstNonRepeatingChar(String s) {
		   HashMap<Character, Integer> hashMap=new HashMap<>();
		   char[] charArr=s.toCharArray();
		   for(char c:charArr) {
			   if(hashMap.get(c)==null) {
				   hashMap.put(c, 1);
			   }
			   else {
				   hashMap.put(c, hashMap.get(c)+1);
			   }
		   }
		   
		   for(Character c:charArr) {
			   if(hashMap.get(c)==1) {
				   return c;
			   }
		   }
		   
		   return null;
		   
	   }

	    public static void main(String[] args) {
	        System.out.println(firstNonRepeatingChar("leetcode"));
	        System.out.println(firstNonRepeatingChar("hello"));
	        System.out.println(firstNonRepeatingChar("aabbcc"));
	        
	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            l
	            h
	            null

	        */
	        
	    }
	    

}
