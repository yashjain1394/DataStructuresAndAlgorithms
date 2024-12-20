package section_6_linkedListProblems;

import java.util.HashSet;

public class RemoveDuplicates {


    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public RemoveDuplicates(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }
    
    public void removeDuplicates() {
        HashSet<Integer> set=new HashSet<Integer>();
        Node prev=null;
        Node current=head;
        while(current!=null){
            if(set.contains(current.value)){
                prev.next=current.next;
                length-=1;
                
                
            }else{
                set.add(current.value);
                prev=current;
                
            }
            
            current=current.next;
            
        }
            
    }
    
//    Alternate approach
//    public void removeDuplicates() {
//        HashSet<Integer> set=new HashSet<Integer>();
//        Node current=head;
//        Node list=new Node(0);
//        Node listTail=list;
//        while(current!=null){
//        	if(set.add(current.value)) {
//        		listTail.next=current;
//        		listTail=current;
//        		
//        	}
//        	else{
//        	    length-=1;
//        	}
//        	current=current.next;
//        	
//        }
//        
//        listTail.next=null;
//        head=list.next;
//            
//    }
    


	public static void main(String[] args) {

		RemoveDuplicates myLinkedList = new RemoveDuplicates(1);

        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(4);

        myLinkedList.removeDuplicates();

        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            3
            4
            
        */
        
    }

}
