package section_3_pointers;

import java.util.HashMap;

public class Pointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=11;
		int num2=num1;
		
		num1=22;
		
		System.out.println("num1:"+num1);
		System.out.println("num2:"+num2);
		
		
		/*
		 * map1={"value"=11}
		 * map2=map1
		 */
		
		HashMap<String, Integer> map1=new HashMap<>();
		HashMap<String, Integer> map2=new HashMap<>();
		
		map1.put("value", 11);
		map2=map1;
		
		map1.put("value", 22);
		
		System.out.println(map1);
		System.out.println(map2);
	}

}
