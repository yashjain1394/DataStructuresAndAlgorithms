package section_4_linkedList;

public class LinkedListPractice {
	private Node head;
	private int length;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value=value;
			}
	}
	
	public LinkedListPractice(int value) {
		Node newNode=new Node(value);
		head=newNode;
		newNode.next=null;
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
	
	public void getLength() {
		System.out.println("Length:"+length);
	}
	
	public void append(int value) {
		Node newNode=new Node(value);
		Node temp=head;
		if(head==null) {
			head=newNode;
		}else {
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
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
	
	public Node get(int index) {
		Node temp=head;
		if(index<0 || index>=length) {
			return null;
		}
		else {
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
			return temp;
		}
		
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
		Node temp=get(index-1);
		newNode.next=temp.next;
		temp.next=newNode;
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
		Node temp=head;
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			head=null;
		}
		else {
			Node prev=temp;
			while(temp.next!=null) {
				prev=temp;
				temp=temp.next;
			}
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
		Node temp=head;
		Node before=null;
		Node after;
		while(temp!=null) {
			after=temp.next;
			temp.next=before;
			before=temp;
			temp=after;
		}
		head=before;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListPractice myLinkedList=new LinkedListPractice(1);
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
