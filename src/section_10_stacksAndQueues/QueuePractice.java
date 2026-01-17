package section_10_stacksAndQueues;

public class QueuePractice {
	private int length;
	private Node first;
	private Node last;
	
	public class Node {
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
		Node currentNode=first;
		System.out.print("first->");
		while(currentNode!=null) {
			System.out.print(currentNode.value+"->");
			currentNode=currentNode.next;
		}
		System.out.print("last");
		System.out.println();
	}
	
	public boolean enqueue(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			first=newNode;
			last=newNode;
		}
		else
		{
			last.next=newNode;
			last=newNode;
			
		}
		length++;
		return true;
	}
	
	public Node dequeue() {
		Node currentNode=first;
		if(length==0)
		{
			System.out.println("Queue is empty");
			return null;
		}
		if(length==1) {
			first=null;
			last=null;
		}
		else {
			first=first.next;
			currentNode.next=null;
			
		}
		length--;
		return currentNode;
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
