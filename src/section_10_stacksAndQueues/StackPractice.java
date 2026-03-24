package section_10_stacksAndQueues;

public class StackPractice {
	private Node top;
	private int height;
	public class Node{
		private Node next;
		private int value;
		
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
		Node temp=top;
		System.out.println("\t"+"top"+"\t");
		while(temp!=null){
			System.out.println("\t|"+temp.value+"|\t");
			temp=temp.next;
		}
		System.out.println();
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
			System.out.println("Stack is empty");
			return null;
		}
		else if(height==1) {
			top=null;
			
		}
		else {
			top=top.next;
			temp.next=null;
		}
		height--;
		return temp;
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
