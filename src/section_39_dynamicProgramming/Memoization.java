package section_39_dynamicProgramming;

public class Memoization {
	
	/*
	 * 0	1	1	2	3	5	8	13
	 * 0	1	2	3	4	5	6	7
	 * 
	 * O(n)=O(2n-1)=O(2n)=O(n)
	 */
	static Integer[] memo=new Integer[100];
	static int counter=0;
	
	public static int fib(int n) {
		counter++;
		if(memo[n]!=null) {
			return memo[n];
		}
		if(n==0 || n==1) {
			return n;
		}
		memo[n]= fib(n-1)+fib(n-2);
		return memo[n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=40;
		
		System.out.println("\nFib of "+n+"="+fib(n));
		
		System.out.println("\nCounter: "+counter);


	}

}
