package section_4_linkedList;

public class LinkedListPracticeLatest {
	private Node head;
	private int length;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value=value;
		}
		
	}
	
	public LinkedListPracticeLatest(int value) {
		Node newNode=new Node(value);
		head=newNode;
		length=1;
	}
	
	public void getLength() {
		System.out.println("Length:"+length);
		
	}
	
	public void getHead() {
		System.out.println("Head:"+head.value);
		
	}
	
	public void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.value+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public Node get(int index) {
		Node current=head;
		if(index<0 || index>=length) {
			return null;
		}
		for(int i=0;i<index;i++) {
			current=current.next;
		}
		return current;
	}
	
	public void append(int value) {
		Node newNode=new Node(value);
		if(head==null) {
			head=newNode;
			
		}
		else {
			Node tail=get(length-1);
			tail.next=newNode;
			newNode.next=null;
			
		}
		length++;
	}
	
	public void prepend(int value) {
		Node newNode=new Node(value);
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.next=head;
			head=newNode;
		}
		length++;
	}
	
	public boolean insert(int index, int value) {
		Node newNode=new Node(value);
		if(index<0 || index>length) {
			return false;
		}
		if(index==0) {
		 prepend(value);
		 return true;
		}
		if(index==length) {
		 append(value);
		 return true;
		}
		
		Node prev=get(index-1);
		newNode.next=prev.next;
		prev.next=newNode;
		length++;
		return true;	
	}
	
	public Node removeFirst() {
		Node temp=head;
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			head=null;
		}
		else {
			head=head.next;
			temp.next=null;
		}
		length--;
		return temp;
	}
	
	public Node removeLast() {
		Node prev=get(length-2);
		Node temp=prev.next;
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			head=null;
			
		}
		else {
			prev.next=null;
		}
		length--;
		return temp;
		
	}
	
	public Node remove(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		if(index==0) {
			return removeFirst();
		}
		if(index==length-1) {
			return removeLast();
		}
		Node prev=get(index-1);
		Node temp=prev.next;
		prev.next=temp.next;
		temp.next=null;
		length--;
		return temp;	
	}
	
	public boolean set(int index, int value) {
		Node temp=get(index);
		if(temp!=null) {
			temp.value=value;
			return true;
		}
		return false;
	}
	
	public void reverse() {
		Node before=null;
		Node current=head;
		Node after=current.next;
		
		while(current!=null){
			after=current.next;
			current.next=before;
			before=current;
			current=after;
		}
		head=before;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListPracticeLatest myLinkedList=new LinkedListPracticeLatest(1);
		myLinkedList.printList();
		myLinkedList.append(2);
		myLinkedList.printList();
		myLinkedList.append(3);
		myLinkedList.printList();
		myLinkedList.prepend(0);
		myLinkedList.printList();
		myLinkedList.insert(1, 1);
		myLinkedList.printList();
		myLinkedList.removeFirst();
		myLinkedList.printList();
		myLinkedList.removeLast();
		myLinkedList.printList();
		myLinkedList.remove(1);
		myLinkedList.printList();
		myLinkedList.set(1, 5);
		myLinkedList.printList();
		myLinkedList.reverse();
		myLinkedList.printList();
		
		
	

	}

}
