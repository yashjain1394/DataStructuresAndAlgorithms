package section_9_doublyLinkedListProblems;

public class Reverse {


    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public Reverse(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

	public void reverse(){
	    Node temp=head;
	    head=tail;
	    tail=temp;
	    Node before=null;
	    Node current=tail;
	    Node after;
	    for(int i=0;i<length;i++){
	        after=current.next;
	        current.next=before;
	        current.prev=after;
	        before=current;
	        current=after;
	        
	        
	    }
	    
	    
	}





    public static void main(String[] args) {

    	Reverse myDLL = new Reverse(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);
        
        System.out.println("DLL before reverse:");
        myDLL.printList();
        
        myDLL.reverse();
        
        System.out.println("\nDLL after reverse:");
        myDLL.printList();
        
        
        /*
       		EXPECTED OUTPUT:
        	----------------
            DLL before reverse:
            1
            2
            3
            4
            5
            
            DLL after reverse:
            5
            4
            3
            2
            1
        
     	*/

    }
    


}
