package section_7_doublyLinkedList;

public class MyDoublyLinkedList {
	private Node head;
	private Node tail;
	private  int length;
	
	class Node{
		int value;
		Node next;
		Node prev;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public MyDoublyLinkedList(int value) {
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
		length=1;
	}
	
	public void printList() {
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.value+"<->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public void getHead() {
		System.out.println("Head:"+head.value);
	}

	public void getTail() {
		System.out.println("Tail:"+tail.value);
	}

	public void getLength() {
		System.out.println("Length:"+length);
	}
	
	public void append(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		}
		else {
			newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
		}
		length++;
	}
	
	public void prepend(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		}else {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			
		}
		length++;
	}
	
	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node temp=head;
		if(index<length/2) {
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}
		else {
			temp=tail;
			for(int j=length-1;j>index;j--) {
				temp=temp.prev;
				}
			}
		return temp;

	}
	
	public boolean insert(int index,int value) {
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
		Node before=get(index-1);
		Node after=before.next;
		newNode.next=after;
		newNode.prev=before;
		after.prev=newNode;
		before.next=newNode;
		length++;
		return true;
		
	}
	
	
	public Node removeFirst() {
		Node temp=head;
		if(length==0) {
			return null;
		}
		if(length==1) {
			head=null;
			tail=null;
		}
		else {
			head=head.next;
			head.prev=null;
			temp.next=null;
			
		}
		length--;
		return temp;
	}
	
	public Node removeLast() {
		Node temp=tail;
		if(length==0) {
			return null;
		}
		if(length==1) {
			head=null;
			tail=null;
		}
		else {
			tail=tail.prev;
			tail.next=null;
			temp.prev=null;
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
		Node temp=get(index);
		Node before=temp.prev;
		Node after=temp.next;
		before.next=after;
		after.prev=before;
		temp.next=null;
		temp.prev=null;
		length--;
		return temp;
	}
	
	public boolean set(int index,int value) {
		Node temp=get(index);
		if(temp!=null) {
			temp.value=value;
			return true;
		}
		return false;
	}
	
	public void reverse() {
		Node temp=head;
		head=tail;
		tail=temp;
		Node before=null;
		Node after=temp.next;
		for(int i=0;i<length;i++) {
			after=temp.next;
			temp.next=before;
			temp.prev=after;
			before=temp;
			temp=after;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDoublyLinkedList myDoublyLinkedList=new MyDoublyLinkedList(1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.append(2);
		myDoublyLinkedList.append(3);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.prepend(0);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.insert(1,1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.removeFirst();
		myDoublyLinkedList.printList();
		myDoublyLinkedList.removeLast();
		myDoublyLinkedList.printList();
		myDoublyLinkedList.remove(1);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.set(1,5);
		myDoublyLinkedList.printList();
		myDoublyLinkedList.reverse();
		myDoublyLinkedList.printList();

	}

}
