package section_10_stacksAndQueues;

public class Queue {
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

	public Queue(int value) {
		Node newNode=new Node(value);
		first=newNode;
		last=newNode;
		length=1;
	}

	public void getFirst() {
		System.out.println("First: "+first.value);
	}

	public void getLast() {
		System.out.println("Last: "+last.value);
	}

	public void getLength() {
		System.out.println("Length: "+length);
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

		}else {
			last.next=newNode;
			last=newNode;

		}
		length++;
	}

	public Node dequeue() {
		Node temp=first;
		if(length==0) {
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
		//		Constructor
		//		Queue myQueue=new Queue(7);
		//		myQueue.getFirst();
		//		myQueue.getLast();
		//		myQueue.getLength();
		//		myQueue.printQueue();

		//		enqueue method
		//				Queue myQueue=new Queue(1);
		//				myQueue.printQueue();
		//				myQueue.enqueue(2);
		//				myQueue.printQueue();

		//dequeue method
		Queue myQueue=new Queue(2);
		myQueue.enqueue(1);
		myQueue.printQueue();
		System.out.println(myQueue.dequeue().value);
		System.out.println(myQueue.dequeue().value);
		System.out.println(myQueue.dequeue());
		myQueue.printQueue();

	}

}
