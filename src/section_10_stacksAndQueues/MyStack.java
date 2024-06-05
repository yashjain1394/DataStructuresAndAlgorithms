package section_10_stacksAndQueues;

public class MyStack {
	public Node top;
	public int height;
	
	public class Node{
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public MyStack(int value) {
		Node newNode=new Node(value);
		top=newNode;
		height=1;
	}
	
	public void printStack() {
		Node temp=top;
		System.out.println("\t|"+"top"+"|\t");
		while(temp!=null) {
			System.out.println("\t|"+temp.value+"|\t");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public void getTop() {
		System.out.println("Top:"+top.value);
	}
	
	public void getHeight() {
		System.out.println("Height:"+height);
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
		if(height==1) {
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
		MyStack myStack=new MyStack(1);
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
