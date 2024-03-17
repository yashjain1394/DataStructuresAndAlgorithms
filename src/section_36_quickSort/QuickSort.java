package section_36_quickSort;

import java.util.Arrays;

public class QuickSort {
	/*
	 * We take a pivot element and place it such that all elements at the left are less than pivot and all elements at the right are more than pivot element.
	 * Big O:
	 * pivot method: O(n)
	 * quickSortHelper method: O(log n) due to recursion
	 * Total time complexity=O(n log n)
	 * Hence, it is more efficient than O(n^2).
	 * If the data is already sorted than time complexity becomes O(n^2).
	 */
	
	public static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp=array[firstIndex];
		array[firstIndex]=array[secondIndex];
		array[secondIndex]=temp;
	}
	/*
	 * Pivot method will swap the pivot element and return the index of swap element.
	 */
	
	public static int pivot(int[] array, int pivotIndex,int endIndex) {
		int swapIndex=pivotIndex;
		for(int i=pivotIndex+1;i<=endIndex;i++) {
			if(array[i]<array[pivotIndex]) {
				swapIndex++;
				swap(array, swapIndex, i);
				
			}
		}
		swap(array,pivotIndex,swapIndex);
		return swapIndex;
	}
	
	/*
	 * Quick sort method will run pivot method on elements that are left to the pivot index and elements that are right to the pivot index
	 */
	
	public static void quickSortHelper(int[] array, int left, int right) {
		if(left<right) {
		int pivotIndex=pivot(array,left,right);
		quickSortHelper(array, left, pivotIndex-1);
		quickSortHelper(array, pivotIndex+1, right);
		}
	}
	
	public static void quickSort(int[] array) {
		quickSortHelper(array, 0, array.length-1);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray= {4,6,1,7,3,2,5};
//		int returnedIndex=pivot(myArray, 0, 6);
//		System.out.println("Returned Index: "+returnedIndex);
//		System.out.println(Arrays.toString(myArray));
		
		quickSort(myArray);
		System.out.println(Arrays.toString(myArray));

	}

}
