package section_10_stacksAndQueues;

public class StackPractice {
	private Node top;
	private int height;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public StackPractice(int value) {
		Node newNode=new Node(value);
		top=newNode;
		height=1;
		
	}
	
	public void printStack() {
		Node currentNode=top;
		System.out.println("\t"+"top"+"\t");
		while(currentNode!=null) {
			System.out.println("\t|"+currentNode.value+"|\t");
			currentNode=currentNode.next;
		}
		System.out.println();
	}
	
	public boolean push(int value) {
		Node newNode=new Node(value);
		if(height==0) {
			top=newNode;
		}
		else {
			newNode.next=top;
			top=newNode;
		}
		height++;
		return true;
	}
	
	public Node pop() {
		Node currentNode=top;
		if(height==0) {
			System.out.println("Stack is empty");
			return null;
		}
		if(height==1) {
			top=null;
		}
		else {
			top=top.next;
			currentNode.next=null;
		}
		height--;
		return currentNode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackPractice myStack=new StackPractice(1);
		myStack.printStack();
		myStack.push(2);
		myStack.printStack();
		myStack.push(3);
		myStack.printStack();
		myStack.pop();
		myStack.printStack();
		myStack.push(4);
		myStack.printStack();
		myStack.pop();
		myStack.printStack();
		myStack.pop();
		myStack.printStack();
		myStack.pop();
		myStack.printStack();
		myStack.pop();
		myStack.printStack();

	}

}
