package section_15_hashTable;

import java.util.HashMap;

public class ItemInCommon {
	
//	O(n^2) approach without hashmap
	public static boolean itemInCommonWithoutHashmap(int[] array1, int[] array2) {
		for(int i:array1) {
			for(int j:array2) {
				if(i==j) {
					return true;
				}
			}
		}
		return false;
	}
	
//	O(n) approach with hashmap
	public static boolean itemInCommonWithHashmap(int[] array1, int[] array2) {
		HashMap<Integer, Boolean> myHashMap=new HashMap<>();
		for(int i:array1) {
			myHashMap.put(i, true);
		}
		for(int j:array2) {
			if(myHashMap.get(j)!=null) {
				return true;
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1= {1,3,5};
		int[] array2= {2,4,5};
		
		System.out.println(itemInCommonWithoutHashmap(array1, array2));
		System.out.println(itemInCommonWithHashmap(array1, array2));
		

	}

}
