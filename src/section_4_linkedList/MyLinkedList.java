package section_4_linkedList;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	public class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public MyLinkedList(int value) {
		Node newNode=new Node(value);
		head=newNode;
		tail=newNode;
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
		}
		else {
			newNode.next=head;
			head=newNode;
			
		}
		length++;
	}
	
	public Node get(int index) {
		if(index<0 || index>length) {
			return null;
		}
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp;
	}
	
	public boolean insert(int index,int value) {
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
		Node newNode=new Node(value);
		Node temp=get(index-1);
		newNode.next=temp.next;
		temp.next=newNode;
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
			temp.next=null;
			
		}
		length--;
		return temp;
		
	}
	
	public Node removeLast() {
		Node temp=head;
		Node pre=head;
		if(length==0) {
			return null;
		}
		if(length==1) {
			head=null;
			tail=null;
		}
		else {
			while(temp.next!=null) {
				pre=temp;
				temp=temp.next;
			}
			pre.next=null;
			tail=pre;
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
		Node pre=get(index-1);
		Node temp=pre.next;
		pre.next=temp.next;
		temp.next=null;
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
			before=temp;
			temp=after;
			}
		}
	
	public static void main(String args[]) {
		MyLinkedList myLinkedList=new MyLinkedList(1);
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
