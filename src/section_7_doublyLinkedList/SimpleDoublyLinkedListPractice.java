package section_7_doublyLinkedList;

public class SimpleDoublyLinkedListPractice {
	private Node head;
	private Node tail;
	private int length;
	
	public class Node{
		private Node next;
		private Node prev;
		private int value;
		
		public Node(int value) {
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
		Node current=head;
		while(current!=null) {
			System.out.print(current.value+"<->");
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
			tail=newNode;
		}
		else if(index==0) {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			}
		else if(index==length) {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		else {
			Node beforeNode=get(index-1);
			Node afterNode=beforeNode.next;
			newNode.prev=beforeNode;
			newNode.next=afterNode;
			beforeNode.next=newNode;
			afterNode.prev=newNode;
		}
		length++;
		return true;
	}
	
	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node currentNode;
		if(index<length/2) {
			currentNode=head;
			for(int i=0;i<index;i++) {
				currentNode=currentNode.next;
			}
			
		}
		else {
			currentNode=tail;
			for(int i=length-1;i>index;i--) {
				currentNode=currentNode.prev;
			}
		}
		return currentNode;
	}
	
	public Node remove(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node currentNode=head;
		if(length==0) {
			return null;
		}
		if(length==1) {
			head=null;
			tail=null;
		}
		else if(index==0){
			head=head.next;
			currentNode.next=null;
			currentNode.prev=null;
		}
		else if(index==length-1) {
			currentNode=tail;
			tail=tail.prev;
			tail.next=null;
			currentNode.prev=null;
		}
		else {
			Node beforeNode=get(index-1);
			currentNode=beforeNode.next;
			Node afterNode=currentNode.next;
			beforeNode.next=afterNode;
			afterNode.prev=beforeNode;
			currentNode.next=null;
			currentNode.prev=null;
		}
		
		length--;
		return currentNode;
	}
	
	public void reverse() {
		Node beforeNode=null;
		Node currentNode=head;
		Node afterNode;
		while(currentNode!=null) {
			afterNode=currentNode.next;
			currentNode.next=beforeNode;
			currentNode.prev=afterNode;
			beforeNode=currentNode;
			currentNode=afterNode;
			
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
