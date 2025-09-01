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
		
		if(index==0) {
			newNode.next=head;
			head=newNode;
			length++;
			return true;
				
		}
		else {
			Node prev=get(index-1);
			newNode.next=prev.next;
			prev.next=newNode;
			length++;
			return true;
		}
	}
	
	public Node get(int index){
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
		if(index<0 || index>=length) {
			return null;
		}
		
		if(index==0) {
			Node temp=head;
			head=head.next;
			temp.next=null;
			length--;
			return temp;	
		}
		else {
			Node prev=get(index-1);
			Node temp=prev.next;
			prev.next=temp.next;
			temp.next=null;
			length--;
			return temp;
			
		}
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
