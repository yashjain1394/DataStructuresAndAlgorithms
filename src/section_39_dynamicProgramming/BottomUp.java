package section_39_dynamicProgramming;

public class BottomUp {
	/*
	 * When we do DP iteratively, it is called bottom up.
	 * O(n)=O(n-1)=O(n)
	 */
	static int counter=0;
	public static int fib(int n) {
		int[] fibList=new int[n+1];
		fibList[0]=0;
		fibList[1]=1;
		
		for(int index=2;index<=n;index++) {
			counter++;
			fibList[index]=fibList[index-1]+fibList[index-2];
		}
		
		return fibList[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=40;
		
		System.out.println("\nFib of "+n+"="+fib(n));
		
		System.out.println("\nCounter: "+counter);

	}

}
