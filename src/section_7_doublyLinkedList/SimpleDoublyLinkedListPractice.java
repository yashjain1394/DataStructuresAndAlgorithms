package section_7_doublyLinkedList;

public class SimpleDoublyLinkedListPractice {
	private Node head;
	private int length;
	private Node tail;
	
	public class Node{
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int value){
			this.value=value;	
		}
		
	}
	
	public SimpleDoublyLinkedListPractice(int value) {
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
		length=1;
		
	}
	
	public void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.value+"<->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public boolean insert(int index, int value) {
		if(index<0 || index>length) {
			return false;
		}
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		}
		else if(index==0) {
			newNode.next=head;
			newNode.prev=null;
			head.prev=newNode;
			head=newNode;
			
		}else if(index==length) {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			
		}
		else {
			Node before=get(index-1);
			Node after=before.next;
			newNode.prev=before;
			newNode.next=after;
			before.next=newNode;
			after.prev=newNode;
			
		}
		length++;
		return true;
	}
	
	public Node get(int index) {
		if (index<0 || index>=length) {
			return null;
		}
		Node temp=head;
		if(index<length/2) {
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
			return temp;
		}else {
			temp=tail;
			for(int i=length-1;i>index;i--) {
				temp=temp.prev;
			}
			return temp;
		}
	}
	
	public Node remove(int index) {
		
		if(index<0 || index>=length) {
			return null;
		}
		
		Node temp=head;
		if(length==0) {
			return null;
		}
		else if(length==1) {
			head=null;
			tail=null;
			length--;
			return temp;
		}
		else if(index==0) {
			temp=head;
			head=head.next;
			head.prev=null;
			temp.next=null;
		}
		
		else if(index==length-1) {
			temp=tail;
			tail=tail.prev;
			tail.next=null;
			temp.prev=null;
			
		}
		
		else {
			temp=get(index);
			Node before=temp.prev;
			Node after=temp.next;
			before.next=after;
			after.prev=before;
			temp.next=null;
			temp.prev=null;
		}
			length--;
			return temp;
	}
	
	public void reverse() {
		Node before=null;
		Node current=head;
		Node after;
		
		while(current!=null) {
			after=current.next;
			current.next=before;
			current.prev=after;
			before=current;
			current=after;
		}
		
		Node temp=head;
		head=tail;
		tail=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDoublyLinkedListPractice myDoublyLinkedList=new SimpleDoublyLinkedListPractice(1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(1,2);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(2,3);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(0,0);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(1,1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.reverse();
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(0);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(3);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(1);
		myDoublyLinkedList.printList();
		

	}

}
