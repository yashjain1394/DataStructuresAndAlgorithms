package section_7_doublyLinkedList;

public class SimpleDoublyLinkedList {
	private Node head;
	private Node tail;
	
	class Node{
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public SimpleDoublyLinkedList(int value) {
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
	}
	
	public void printList() {
		Node current=head;
		while(current!=null) {
			System.out.print(current.value+"<->");
			current=current.next;
		}
		System.out.println();
	}
	
	public int getLength() {
		int length=0;
		Node current=head;
		while(current!=null) {
			current=current.next;
			length++;
		}
		return length;
	}
	
	public boolean insert(int index, int value) {
		if(index<0 || index>getLength()) {
			return false;
		}
		Node newNode=new Node(value);
		if(getLength()==0) {
			head=newNode;
			tail=newNode;
		}
		if(index==0) {
			newNode.next=head;
			head=newNode;
			return true;
		}
		if(index==getLength()) {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			return true;
		}
		Node before=get(index-1);
		Node after=before.next;
		newNode.prev=before;
		newNode.next=after;
		before.next=newNode;
		after.prev=newNode;
		return true;
		}
	
	public Node remove(int index) {
		Node temp;
		if(index<0 || index>=getLength()) {
			return null;
		}
		if(getLength()==0) {
			return null;
		}
		if(getLength()==1) {
			head=null;
			tail=null;
		}
		if(index==0) {
			temp=head;
			head=head.next;
			head.prev=null;
			temp.next=null;
			return temp;
			
		}
		if(index==getLength()-1) {
			temp=tail;
			tail=tail.prev;
			tail.next=null;
			temp.prev=null;
			return temp;
		}
		Node before=get(index-1);
		temp=before.next;
		Node after=temp.next;
		before.next=after;
		after.prev=before;
		temp.prev=null;
		temp.next=null;
		return temp;
	}
	
	public Node get(int index) {
		if(index<0 || index>=getLength()) {
			return null;
		}
		Node current;
		if(index<getLength()/2) {
			current=head;
			for(int i=0;i<index;i++) {
				current=current.next;
			}
			return current;
			
		}
		else {
			current=tail;
			for(int i=getLength()-1;i>=index;i--) {
				current=current.prev;
			}
			return current;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDoublyLinkedList myDoublyLinkedList=new SimpleDoublyLinkedList(1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(1,2);
		myDoublyLinkedList.insert(2,3);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(0,0);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(1,1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(0);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(3);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(1);
		myDoublyLinkedList.printList();

	}

}
