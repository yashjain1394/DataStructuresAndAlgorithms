package section_10_stacksAndQueues;

public class MyQueue {
	private Node first;
	private Node last;
	private int length;
	
	
	class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value=value;
		}
		
	}
	
	public MyQueue(int value) {
		Node newNode=new Node(value);
		first=newNode;
		last=newNode;
		length=1;
	}
	
	public void getFirst() {
		System.out.println("First:"+first.value);
	}
	
	public void getLast() {
		System.out.println("Last:"+last.value);
	}
	
	public void getLength() {
		System.out.println("Length:"+length);
	}
	
	public void printQueue() {
		Node temp=first;
		System.out.print("first"+"\t");
		while(temp!=null) {
			System.out.print(temp.value+"\t");
			temp=temp.next;
		}
		System.out.print("last");
		System.out.println();
	}
	
	public void enqueue(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			first=newNode;
			last=newNode;
		}
		else {
			last.next=newNode;
			last=newNode;
			
		}
		length++;
	}
	
	public Node dequeue() {
		Node temp=first;
		if(length==0) {
			System.out.println("Queue is empty");
			return null;
		}
		if(length==1) {
			first=null;
			last=null;
		}
		else {
			first=first.next;
			temp.next=null;
			
		}
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue myQueue=new MyQueue(1);
		myQueue.printQueue();
		myQueue.enqueue(2);
		myQueue.printQueue();
		myQueue.enqueue(3);
		myQueue.printQueue();
		myQueue.enqueue(4);
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
	}

}
