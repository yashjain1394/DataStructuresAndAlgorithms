package section_29_basicSorts;

import java.util.Arrays;

public class MyBubbleSort {
	
	public static void bubbleSort(int[] array) {
		for(int i=array.length-1;i>0;i--) {
			for (int j=0;j<i;j++) {
				if(array[j+1]<array[j]) {
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray= {4,2,6,5,1,3};
		bubbleSort(myArray);
		System.out.println(Arrays.toString(myArray));

	}

}
