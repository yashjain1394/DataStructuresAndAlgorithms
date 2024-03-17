package section_15_hashTable;

public class HashTableIntroduction {
	
	/*
	 * Key value pair
	 * {"nails"=1000}
	 * Hash method will give the address.
	 * Hash method is one-way.
	 * Hash method is deterministic.
	 * Example:
	 * 0->
	 * 1->
	 * 2->{"nails"=1000} {"nuts"=1200}
	 * 3->
	 * 4->{"bolts"=1400}
	 * 5->
	 * 6->{"screws"=800}
	 * 7->
	 * 
	 * Collisions:
	 * Separate chaining: Add key value pair at the same address.
	 * Linear Probing (open addressing): Go to next open spot and place the item there.
	 * We will be using separate chaining by putting multiple items in the linked list at the same address.
	 * 
	 * BigO:
	 * Hash method: O(1)
	 * set method: O(1)
	 * get method: O(1)
	 * 
	 * 
	 * 
	 * 
	 */

}
