package section_4_linkedList;

public class SinglyLinkedListPractice {
	private Node head;
	private int length;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value=value;
		}
		
	}
	
	public SinglyLinkedListPractice(int value) {
		Node newNode=new Node(value);
		head=newNode;
		length=1;
		
	}
	
	public void printList() {
		Node current=head;
		while(current!=null) {
			System.out.print(current.value+"->");
			current=current.next;
		}
		System.out.println();
	}
	
	public boolean insert(int index,int value) {
		if(index<0 || index>length) {
			return false;
		}
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			length++;
		}
		else if(index==0) {
			newNode.next=head;
			head=head.next;
			length++;
		}
		else {
			Node prevNode=get(index-1);
			newNode.next=prevNode.next;
			prevNode.next=newNode;
			length++;
		}
		return true;
	}
	
	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node current=head;
		for(int i=0;i<index;i++) {
			current=current.next;
		}
		return current;
	}
	
	public Node remove(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		if(length==0) {
			return null;
		}
		Node current=head;
		if(length==1) {
			head=null;
			length--;
		}
		else if(index==0) {
			head=head.next;
			current.next=null;
			length--;
			
		}
		else {
			Node prevNode=get(index-1);
			current=prevNode.next;
			prevNode.next=current.next;
			current.next=null;
			length--;
		}
		
		return current;
	}
	
	public void reverse() {
		Node before=null;
		Node current=head;
		Node after;
		while(current!=null) {
			after=current.next;
			current.next=before;
			before=current;
			current=after;
		}
		head=before;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedListPractice myLinkedList=new SinglyLinkedListPractice(1);
		myLinkedList.printList();
		myLinkedList.insert(1,2);
		myLinkedList.printList();
		myLinkedList.insert(2,3);
		myLinkedList.printList();
		myLinkedList.insert(3,4);
		myLinkedList.printList();
		myLinkedList.reverse();
		myLinkedList.printList();
		myLinkedList.remove(3);
		myLinkedList.printList();
		myLinkedList.remove(0);
		myLinkedList.printList();
		myLinkedList.remove(1);
		myLinkedList.printList();
		

	}

}
