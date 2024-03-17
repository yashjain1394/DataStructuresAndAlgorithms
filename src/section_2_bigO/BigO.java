package section_2_bigO;

public class BigO {
	
	/* Time Complexity
	 * Space complexity
	 * 
	 * Best case: Ω (Omega)
	 * Average case: θ (Theta)
	 * Worst case: Ο (Omicron)
	 * 
	 * O(n)
	 * 
	 * n+n=2n
	 * Drop constant: O(2n)=O(n)
	 * 
	 * n*n=n^2
	 * O(n^2) grows much faster i.e. it is less efficient
	 * 
	 * Drop Non dominant term
	 * O(n^2+n)=O(n^2) (Drop n)
	 * 
	 * O(1)=As n grows, number of operations remain same
	 * n+n+n=O(2n)=O(1)
	 * O(1) is straight line. Hence, it is most efficient
	 * 
	 * O(log n) is more than O(1) but less than O(n)
	 * 
	 * O(n log n) is more than O(n) but less than O(n^2)
	 * 
	 * Different terms for input
	 * O(a)+O(b)=O(a+b)
	 * O(a)*O(b)=O(a*b)
	 * 
	 * Arraylist=[11,3,23,7] 
	 * Add & remove operation at the end don't need indexing -> O(1)
	 * Add & remove operation at the front need indexing -> O(n)
	 * Finding an item by value -> O(n)
	 * Finding an item by index -> O(1)
	 * 
	 * O(n^2)=Loop within a loop
	 * O(n)=Proportional
	 * O(log n)=Divide and conquer
	 * O(1)=Constant
	 * 
	 * Cheatsheet: https://www.bigocheatsheet.com/
	*/
	
	public static void printItems(int n) {
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.println(i+" "+j);
            }
      
        }
        for (int k=0;k<n;k++){
            System.out.println(k);
        }
    }



    // DO NOT CHANGE THE MAIN METHOD BELOW
    public static void main(String[] args) {
        printItems(10);
    }

}
