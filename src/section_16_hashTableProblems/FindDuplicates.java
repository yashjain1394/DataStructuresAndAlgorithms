package section_16_hashTableProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicates {


    public static List<Integer> findDuplicates(int[] array1) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i : array1) {

            if(hashMap.get(i)==null) {
                hashMap.put(i,1);
            }
            else {
                hashMap.put(i, hashMap.get(i)+1);
            }

        }

        List<Integer> list = new ArrayList<>();

        for(Integer i : hashMap.keySet()) {
            if(hashMap.get(i) > 1) {
                list.add(i);
            }
        }

        return list;
    }
      

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates); 
        
        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */
        
    }



}
