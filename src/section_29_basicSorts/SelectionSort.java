package section_29_basicSorts;

import java.util.Arrays;

public class SelectionSort {
	/*
	 * minIndex is used for sorting
	 * 
	 */
	
	public static void selectionSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			int minIndex=i;
			for(int j=i+1;j<array.length;j++) {
				if(array[j]<array[minIndex]) {
					minIndex=j;
				}
			}
			if(minIndex!=i) {
				int temp=array[i];
				array[i]=array[minIndex];
				array[minIndex]=temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray= {4,2,6,5,1,3};
		selectionSort(myArray);
		System.out.println(Arrays.toString(myArray));

	}

}
