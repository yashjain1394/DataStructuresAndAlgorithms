package section_7_doublyLinkedList;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int length;

	class Node{
		int value;
		Node next;
		Node prev;

		public Node(int value){
			this.value=value;

		}
	}

	public DoublyLinkedList(int value) {
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
		else{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		length++;
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

	public void prepend(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		}
		else {
			newNode.next=head;
			head.prev=newNode;
			head=newNode;

		}
		length++;

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

	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node temp=head;
		if(index<length/2) {
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}else {
			temp=tail;
			for(int i=length-1;i>index;i--) {
				temp=temp.prev;
			}
		}
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

	public boolean insert(int index, int value) {
		if(index<1 || index>length) {
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
		Node before=get(index-1);
		Node after=before.next;
		newNode.prev=before;
		newNode.next=after;
		before.next=newNode;
		after.prev=newNode;
		length++;
		return true;


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
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		temp.next=null;
		temp.prev=null;
		length--;
		return temp;

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

		//		Constructor
		//		DoublyLinkedList myDLL=new DoublyLinkedList(7);
		//		myDLL.getHead();
		//		myDLL.getTail();
		//		myDLL.getLength();
		//		myDLL.printList();

		//		append method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(1);
		//		myDLL.printList();
		//		myDLL.append(2);
		//		myDLL.printList();

		//		removelast method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(1);
		//		myDLL.append(2);
		//		myDLL.printList();
		//		System.out.println(myDLL.removeLast().value);
		//		System.out.println(myDLL.removeLast().value);
		//		System.out.println(myDLL.removeLast());

		//		prepend method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(2);
		//		myDLL.append(3);
		//		myDLL.printList();
		//		myDLL.prepend(1);
		//		myDLL.printList();

		//		removeFirst method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(2);
		//		myDLL.append(1);
		//		myDLL.printList();
		//		System.out.println(myDLL.removeFirst().value);
		//		System.out.println(myDLL.removeFirst().value);
		//		System.out.println(myDLL.removeFirst());

		//		get method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(0);
		//		myDLL.append(1);
		//		myDLL.append(2);
		//		myDLL.append(3);
		//		myDLL.printList();
		//		System.out.println(myDLL.get(1).value);
		//		System.out.println(myDLL.get(2).value+"\n");
		//		myDLL.printList();

		//		set method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(11);
		//		myDLL.append(3);
		//		myDLL.append(23);
		//		myDLL.append(7);
		//		myDLL.printList();
		//		myDLL.set(1, 4);
		//		myDLL.printList();

		//insert method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(1);
		//		myDLL.append(3);
		//		myDLL.printList();
		//		myDLL.insert(1, 2);
		//		myDLL.printList();

		//remove method
		//		DoublyLinkedList myDLL=new DoublyLinkedList(0);
		//		myDLL.append(1);
		//		myDLL.append(2);
		//		myDLL.printList();
		//		myDLL.remove(1);
		//		myDLL.printList();

		//		reverse method
		DoublyLinkedList myDLL=new DoublyLinkedList(0);
		myDLL.append(1);
		myDLL.append(2);
		myDLL.append(3);
		myDLL.printList();
		myDLL.reverse();
		myDLL.printList();







	}

}
