package section_24_recursion;

public class Factorial {
	
	public static int factorial(int n) {
		if(n==1) return 1;
		return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myFac=factorial(4);
		System.out.println(myFac);

	}

}
