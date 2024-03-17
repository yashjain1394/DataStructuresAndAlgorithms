package section_33_mergeSort;

import java.util.Arrays;

public class MergeSort {
	/*
	 * Break the list in half until the list contain the single element
	 * The single item is sorted
	 * Combine the list in sorted order
	 * Keep on combining the lists
	 * 
	 * Big O:
	 * Space complexity:O(n) because array is broken down into n arrays
	 * Time complexity: 
	 * Merge sort method:O(log n)
	 * Merge method: O(n) 
	 * Total time complexity=O(n log n)
	 * Hence it is better than insertion, selection & bubble sort with O(n^2).
	 */

	/*
	 * Merge method will merge the two arrays in sorted order
	 */
	public static int[] merge(int[] array1, int[] array2) {
		int[] combined=new int[array1.length+array2.length];
		int index=0;
		int i=0;
		int j=0;
		
		while(i<array1.length && j<array2.length) {
			if(array1[i]<array2[j]) {
				combined[index]=array1[i];
				index++;
				i++;
			}
			else {
				combined[index]=array2[j];
				index++;
				j++;
			}
		}
		while(i<array1.length) {
			combined[index]=array1[i];
			index++;
			i++;
		}
		
		while(j<array2.length) {
			combined[index]=array2[j];
			index++;
			j++;
		}
		
		return combined;
		
	}
	
	/*
	 * Merge sort method:
	 * 1) Breaks lists in half
	 * 2) Base case: when len(the_list) is 1
	 * 3) Uses merge() to put lists together
	 */
	
	public static int[] mergeSort(int[] array) {
		if(array.length==1) {
			return array;
		}
		int midIndex=array.length/2;
		int[] left=mergeSort(Arrays.copyOfRange(array, 0, midIndex));
		int[] right=mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
		
		return merge(left,right);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array1= {1,3,7,8};
//		int[] array2= {2,4,5,6};
//		System.out.println(Arrays.toString(merge(array1,array2)));

		int[] originalArray= {3,1,4,2};
		int[] sortedArray=mergeSort(originalArray);
		
		System.out.println("\nOriginal Array: "+Arrays.toString(originalArray));
		System.out.println("\nSorted Array: "+Arrays.toString(sortedArray));
	}

}
