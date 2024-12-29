package section_9_doublyLinkedListProblems;

public class SwapNodesInPairs {


    private Node head;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public SwapNodesInPairs(int value) {
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
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(output.toString());
    }
    
    public void makeEmpty() {
        head = null;
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        length++;
    }

    public void swapPairs(){
        
        if(head==null || length<2){
            return;
        }
            Node dummyNode=new Node(0);
            dummyNode.next=head;
            head.prev=dummyNode;
            Node previousNode=dummyNode;
            
        
            for(int i=0;i<length/2;i++){
                Node firstNode=head;
                Node secondNode=head.next;
                Node afterNode=secondNode.next;
                firstNode.next=afterNode;
                if(afterNode!=null){
                afterNode.prev=firstNode;
                }
                secondNode.prev=previousNode;
                previousNode.next=secondNode;
                secondNode.next=firstNode;
                firstNode.prev=secondNode;
                previousNode=firstNode;
                head=firstNode.next;
                
            }
            
        head=dummyNode.next;
        head.prev=null;
        
    }
    


    public static void main(String[] args) {
        
    	SwapNodesInPairs myDll = new SwapNodesInPairs(1);
        myDll.append(2);
        myDll.append(3);
        myDll.append(4);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            myDll before swapPairs:
            1 <-> 2 <-> 3 <-> 4
            
            myDll after swapPairs:
            2 <-> 1 <-> 4 <-> 3

        */

    }


    


}
