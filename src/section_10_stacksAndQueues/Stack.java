package section_10_stacksAndQueues;

public class Stack {
	private Node top;
	private int height;

	class Node{
		int value;
		Node next;

		public Node(int value) {
			this.value=value;

		}
	}

	public Stack(int value) {
		Node newNode=new Node(value);
		top=newNode;
		height=1;
	}

	public void printStack() {
		Node temp=top;
		System.out.print("top"+"\t");
		while(temp!=null) {
			System.out.print(temp.value+"\t");
			temp=temp.next;
		}
		System.out.println();
	}

	public void getTop() {
		System.out.println("Top: "+top.value);
	}

	public void getHeight() {
		System.out.println("Height: "+height);
	}

	public void push(int value) {
		Node newNode=new Node(value);
		if(height==0) {
			top=newNode;
		}
		else {
			newNode.next=top;
			top=newNode;
		}
		height++;
	}

	public Node pop() {
		Node temp=top;
		if(height==0) {
			return null;
		}
		top=top.next;
		temp.next=null;
		height--;
		return temp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Constructor
		//		Stack myStack=new Stack(4);
		//		myStack.getTop();
		//		myStack.getHeight();
		//		myStack.printStack();

		//		push method
		//		Stack myStack=new Stack(2);
		//		myStack.printStack();
		//		myStack.push(1);
		//		myStack.printStack();

		//		pop method
		Stack myStack=new Stack(7);
		myStack.push(23);
		myStack.push(3);
		myStack.push(11);
		myStack.printStack();
		myStack.pop();
		myStack.printStack();

	}

}
