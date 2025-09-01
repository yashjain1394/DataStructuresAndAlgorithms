package section_9_doublyLinkedListProblems;

public class PartitionList {


    private Node head;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public PartitionList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
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
            newNode.prev = current;
        }
    }

    public void partitionList(int x) {
        if(head==null){
            return;
        }
        Node current=head;
        Node left=new Node(0);
        Node leftTail=left;
        Node right=new Node (0);
        Node rightTail=right;
        while(current!=null){
            if(current.value<x){
                leftTail.next=current;
                current.prev=leftTail;
                leftTail=current;
            }
            else{
                rightTail.next=current;
                current.prev=rightTail;
                rightTail=current;
                
            }
            current=current.next;
        }
        
        rightTail.next=null;
        leftTail.next=right.next;
        if(right.next!=null){
           right.next.prev=leftTail; 
        }
        head=left.next;
        if(head!=null){
            head.prev=null;
        }
        
        
        
        
        
        
    }
    
    




    private static void printForward(PartitionList dll) {
        PartitionList.Node current = dll.getHead();
        if (current == null) {
            System.out.println("Forward: empty");
            return;
        }
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }

    private static void printBackward(PartitionList dll) {
        PartitionList.Node current = dll.getHead();
        if (current == null) {
            System.out.println("Backward: empty");
            return;
        }
        while (current.next != null) current = current.next;  // move to tail
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.prev != null) System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PartitionList dll;
        
        // Explain why we do forward and backward prints
        System.out.println("We print each list forward and backward");
        System.out.println("to confirm BOTH next and prev pointers");
        System.out.println("are correct after reverseBetween.");
        System.out.println();

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        dll = new PartitionList(1);
        dll.makeEmpty();
        dll.partitionList(3);
        System.out.println("Expected Forward: empty");
        System.out.println("Expected Backward: empty");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 2: Single node (< x)
        System.out.println("Test 2: Single Node (< x)");
        dll = new PartitionList(1);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1");
        System.out.println("Expected Backward: 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 3: Single node (>= x)
        System.out.println("Test 3: Single Node (>= x)");
        dll = new PartitionList(9);
        dll.partitionList(5);
        System.out.println("Expected Forward: 9");
        System.out.println("Expected Backward: 9");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 4: All nodes < x
        System.out.println("Test 4: All Nodes < x");
        dll = new PartitionList(1);
        dll.append(2);
        dll.append(3);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1 <-> 2 <-> 3");
        System.out.println("Expected Backward: 3 <-> 2 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 5: All nodes >= x
        System.out.println("Test 5: All Nodes >= x");
        dll = new PartitionList(7);
        dll.append(8);
        dll.append(9);
        dll.partitionList(5);
        System.out.println("Expected Forward: 7 <-> 8 <-> 9");
        System.out.println("Expected Backward: 9 <-> 8 <-> 7");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 6: Mixed nodes
        System.out.println("Test 6: Mixed Nodes");
        dll = new PartitionList(3);
        dll.append(5);
        dll.append(8);
        dll.append(5);
        dll.append(10);
        dll.append(2);
        dll.append(1);
        dll.partitionList(5);
        System.out.println("Expected Forward: 3 <-> 2 <-> 1 <-> 5 <-> 8 <-> 5 <-> 10");
        System.out.println("Expected Backward: 10 <-> 5 <-> 8 <-> 5 <-> 1 <-> 2 <-> 3");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 7: Duplicates around pivot
        System.out.println("Test 7: Duplicates Around Pivot");
        dll = new PartitionList(5);
        dll.append(1);
        dll.append(5);
        dll.append(0);
        dll.append(5);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1 <-> 0 <-> 5 <-> 5 <-> 5");
        System.out.println("Expected Backward: 5 <-> 5 <-> 5 <-> 0 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();
    }
    


}
