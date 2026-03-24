package section_10_stacksAndQueues;

public class QueuePractice {
	private Node first;
	private Node last;
	private int length;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public QueuePractice(int value) {
		Node newNode=new Node(value);
		first=newNode;
		last=newNode;
		length=1;
	}
	
	public void printQueue() {
		Node temp=first;
		System.out.print("first->");
		while(temp!=null) {
			System.out.print(temp.value+"->");
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
			System.out.println("Queue is empty");
			return null;
		}
		else if(length==1) {
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
		QueuePractice myQueue=new QueuePractice(1);
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
