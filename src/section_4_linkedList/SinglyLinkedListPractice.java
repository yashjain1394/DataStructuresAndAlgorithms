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
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.value+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public boolean insert(int index, int value) {
		Node newNode=new Node(value);
		if(index<0 || index>length) {
			return false;
		}
		if(length==0) {
			head=newNode;
			length++;
		}
		if(index==0) {
			newNode.next=head;
			head=newNode;
			length++;
		}
		else {
			Node before=get(index-1);
			newNode.next=before.next;
			before.next=newNode;
			length++;
		}
		return true;
	}
	
	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp;
	}
	
	public Node remove(int index) {
		Node temp=head;
		if(index<0 || index>=length) {
			return null;
		}
		if(length==0) {
			System.out.println("List is empty");
		}
		if(length==1) {
			head=temp;
			length--;
		}
		if(index==0) {
			head=head.next;
			temp.next=null;
			length--;	
		}
		else {
			Node before=get(index-1);
			temp=before.next;
			Node after=temp.next;
			before.next=after;
			temp.next=null;
			length--;
		}
		return temp;
	}
	
	public void reverse() {
		Node before=null;
		Node current=head;
		Node after=null;
		
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
