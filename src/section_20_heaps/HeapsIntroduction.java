package section_20_heaps;

public class HeapsIntroduction {
	/*
	 * It is a binary tree.
	 * Each node has a value that is greater than its descendant.
	 * It should be complete.
	 * Complete tree is filled from left to right without any gap.
	 * We can have duplicates in heaps.
	 * Max heap: Max value is at the top.
	 * Min Heap: Min value is at the top.
	 * Difference between BST and heap is in its implementation.
	 * We will implement heap in a ArrayList.
	 * X | 99 | 72 | 61 | 58 | 55 | 27 | 18 |
	 * 0   1	2	 3    4	   5    6    7
	 * leftChild= 2 * parentIndex
	 * rightChild= 2 * parentIndex + 1
	 * In Insert method, we will add the new element at the end of the heap and keep on comparing and swapping it with its respective parent
	 * Priority queues are implemented using heaps.
	 * Height of the Heap/tree=log n
	 * Time complexity:
	 * insert and remove takes O(log n) in heap.
	 * Hence, it is used with priority queues.
	 * 	 
	 */

}
