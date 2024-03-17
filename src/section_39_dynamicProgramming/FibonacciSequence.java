package section_39_dynamicProgramming;

public class FibonacciSequence {
	/*
	 * O(n)=O(2^n)
	 */
	static int counter=0;
	public static int fib(int n) {
		counter++;
		if(n==0 || n==1) {
			return n;
		}
		return fib(n-1)+fib(n-2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=40;
		
		System.out.println("\nFib of "+n+"="+fib(n));
		
		System.out.println("\nCounter: "+counter);

	}

}
