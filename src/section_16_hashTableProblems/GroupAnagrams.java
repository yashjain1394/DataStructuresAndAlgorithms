package section_16_hashTableProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    
    public static List<List<String>> groupAnagrams(String[] strings) {
    	HashMap<String,List<String>> hashMap=new HashMap<>();
    	for(String s:strings) {
    		char[] charArr=s.toCharArray();
    		Arrays.sort(charArr);
    		String s1=new String(charArr);
    		if(hashMap.get(s1)==null) {
    			List<String> list1=new ArrayList<>();
    			list1.add(s);
    			hashMap.put(s1,list1);
    		}
    		else {
    			List<String> list2=hashMap.get(s1);
    			list2.add(s);
    			hashMap.put(s1, list2);
    		}
    	}
    	
    	List<List<String>> list=new ArrayList<>();
    	for(String s:hashMap.keySet()) {
    		list.add(hashMap.get(s));
    		
    	}
    	
    return list;
    }
    

    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */
        
    }
    


}
