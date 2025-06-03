package section_4_linkedList;

public class SinglyLinkedList {
	private Node head;
	
	class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public SinglyLinkedList(int value) {
		Node newNode=new Node(value);
		head=newNode;
	}
	
	public int getLength() {
		Node temp=head;
		int length=0;
		while(temp!=null) {
			length++;
			temp=temp.next;
		}
		return length;
	}
	
	public boolean insert(int index, int value) {
		Node newNode=new Node(value);
		int length=getLength();
		if(index<0 || index>length) {
			return false;
		}
		if(index==0) {
			if(length==0) {
				head=newNode;
				return true;
			}
			newNode.next=head;
			head=newNode;
			return true;
		}
		else {
			if(length==0) {
				head=newNode;
				return true;
			}
			Node prev=get(index-1);
			newNode.next=prev.next;
			prev.next=newNode;
			return true;
			
		}
	}
	
	public Node get(int index) {
		Node temp=head;
		if(index<0 || index>=getLength()) {
			return null;
		}
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp;
		
	}
	
	public void printList() {
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.value+"->");
			temp=temp.next;
			
		}
		System.out.println();
		
	}
	
	public Node remove(int index) {
		int length=getLength();
		Node temp;
		Node prev;
		if(index<0 || index>=length) {
			return null;
		}
		if(length==0) {
			return null;
		}
		if(length==1) {
			head=null;
		}
		if(index==0) {
			
			temp=head;
			head=head.next;
			temp.next=null;
			return temp;
		}
		if(index==length-1) {
			prev=get(index-1);
			temp=prev.next;
			prev.next=null;
			return temp;
		}
		else {
			prev=get(index-1);
			temp=prev.next;
			prev.next=temp.next;
			temp.next=null;
			return temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList myLinkedList=new SinglyLinkedList(1);
		myLinkedList.printList();
		myLinkedList.insert(1,2);
		myLinkedList.printList();
		myLinkedList.insert(2,3);
		myLinkedList.printList();
		myLinkedList.insert(3,4);
		myLinkedList.printList();
		myLinkedList.remove(3);
		myLinkedList.printList();
		myLinkedList.remove(0);
		myLinkedList.printList();
		myLinkedList.remove(1);
		myLinkedList.printList();

	}

}
