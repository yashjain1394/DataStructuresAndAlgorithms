package section_16_hashTableProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    
    public static int[] twoSum(int[] array, int sum) {
    	HashMap<Integer,List<Integer>> hashMap=new HashMap<>();
    	for(int i=0;i<array.length;i++) {
    		for(int j=i+1;j<array.length;j++) {
    			if(array[i]+array[j]==sum) {
    				if(hashMap.get(sum)==null){
    					List<Integer> list1=new ArrayList<>();
    					list1.add(i);
    					list1.add(j);
        				hashMap.put(sum,list1);
    				}
    				else {
    					List<Integer> list2=hashMap.get(sum);
    					list2.add(i);
    					list2.add(j);
    					hashMap.put(sum, list2);
    					
    				}
    			}
    		}
    	}
    	int[] results;
    	List<Integer> list=hashMap.get(sum);
    	if(list!=null) {
    	results=new int[list.size()];
    	for(int i=0;i<list.size();i++) {
    		results[i]=list.get(i);
    	}
    	}
    	else {
    		return new int[] {};
    	}
    	return results;
    }

    

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */
        
    }



}
