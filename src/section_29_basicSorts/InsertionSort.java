package section_29_basicSorts;

import java.util.Arrays;

public class InsertionSort {
	/*
	 * Insert each number to its sorted position
	 * Starts with the second element of array at index 1
	 * 
	 */
	
	public static void insertionSort(int[] array) {
		for(int i=1;i<array.length;i++) {
			int temp=array[i];
			int j=i-1;
			while(j>=0 && array[j]>temp) {
				array[j+1]=array[j];
				array[j]=temp;
				j--;
				
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray= {4,2,6,5,1,3};
		insertionSort(myArray);
		System.out.println(Arrays.toString(myArray));

	}

}
