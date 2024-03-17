package section_24_recursion;

public class CallStack {
	
	/*
	 * Recursion uses the concept of Call stack
	 */
	
	public static void methodOne() {
		methodTwo();
		System.out.println("One");
	}
	
	public static void methodTwo() {
		methodThree();
		System.out.println("Two");
	}
	
	public static void methodThree() {
		System.out.println("Three");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		methodOne();

	}

}
