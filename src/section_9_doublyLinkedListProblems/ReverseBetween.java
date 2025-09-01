package section_9_doublyLinkedListProblems;

public class ReverseBetween {


    private Node head;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public ReverseBetween(int value) {
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
 
     public void reverseBetween(int startIndex, int endIndex) {
        if(head==null || startIndex==endIndex){
            return;
        }
        Node dummyNode=new Node(0);
        dummyNode.next=head;
        head.prev=dummyNode;
        Node prevNode=dummyNode;
        
        for(int i=0;i<startIndex;i++){
            prevNode=prevNode.next;
            
        }
        
        Node current=prevNode.next;
        
        for(int i=0; i<endIndex-startIndex;i++){
            Node nodeToMove=current.next;
            current.next=nodeToMove.next;
            if(nodeToMove.next!=null){
                nodeToMove.next.prev=current;
                
            }
            
            nodeToMove.next=prevNode.next;
            prevNode.next.prev=nodeToMove;
            prevNode.next=nodeToMove;
            nodeToMove.prev=prevNode;
            
        }
        
        head=dummyNode.next;
        head.prev=null;
     
    }
    


     private static void printForward(ReverseBetween dll) {
         ReverseBetween.Node current = dll.getHead();
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

     private static void printBackward(ReverseBetween dll) {
         ReverseBetween.Node current = dll.getHead();
         if (current == null) {
             System.out.println("Backward: empty");
             return;
         }
         while (current.next != null) current = current.next;  // Go to tail
         System.out.print("Backward: ");
         while (current != null) {
             System.out.print(current.value);
             if (current.prev != null) System.out.print(" <-> ");
             current = current.prev;
         }
         System.out.println();
     }

     public static void main(String[] args) {
         ReverseBetween dll;
         
         // Explain why we do forward and backward prints
         System.out.println("We print each list forward and backward");
         System.out.println("to confirm BOTH next and prev pointers");
         System.out.println("are correct after reverseBetween.");
         System.out.println();

         // Test 1: Empty list
         System.out.println("Test 1: Empty List");
         dll = new ReverseBetween(1);
         dll.makeEmpty();
         dll.reverseBetween(0,0);
         System.out.println("Expected Forward: empty");
         System.out.println("Expected Backward: empty");
         printForward(dll);
         printBackward(dll);
         System.out.println();

         // Test 2: Single node
         System.out.println("Test 2: Single Node");
         dll = new ReverseBetween(10);
         dll.reverseBetween(0,0);
         System.out.println("Expected Forward: 10");
         System.out.println("Expected Backward: 10");
         printForward(dll);
         printBackward(dll);
         System.out.println();

         // Test 3: Reverse partial (middle)
         System.out.println("Test 3: Reverse Partial (Middle)");
         dll = new ReverseBetween(1);
         for (int i = 2; i <= 5; i++) dll.append(i);
         dll.reverseBetween(1,3);  // Reverse 2,3,4
         System.out.println("Expected Forward: 1 <-> 4 <-> 3 <-> 2 <-> 5");
         System.out.println("Expected Backward: 5 <-> 2 <-> 3 <-> 4 <-> 1");
         printForward(dll);
         printBackward(dll);
         System.out.println();

         // Test 4: Reverse from head
         System.out.println("Test 4: Reverse From Head");
         dll = new ReverseBetween(1);
         for (int i = 2; i <= 5; i++) dll.append(i);
         dll.reverseBetween(0,2);  // Reverse 1,2,3
         System.out.println("Expected Forward: 3 <-> 2 <-> 1 <-> 4 <-> 5");
         System.out.println("Expected Backward: 5 <-> 4 <-> 1 <-> 2 <-> 3");
         printForward(dll);
         printBackward(dll);
         System.out.println();

         // Test 5: Reverse to tail
         System.out.println("Test 5: Reverse To Tail");
         dll = new ReverseBetween(1);
         for (int i = 2; i <= 5; i++) dll.append(i);
         dll.reverseBetween(2,4);  // Reverse 3,4,5
         System.out.println("Expected Forward: 1 <-> 2 <-> 5 <-> 4 <-> 3");
         System.out.println("Expected Backward: 3 <-> 4 <-> 5 <-> 2 <-> 1");
         printForward(dll);
         printBackward(dll);
         System.out.println();

         // Test 6: Reverse entire list
         System.out.println("Test 6: Reverse Entire List");
         dll = new ReverseBetween(1);
         for (int i = 2; i <= 5; i++) dll.append(i);
         dll.reverseBetween(0,4);  // Reverse all
         System.out.println("Expected Forward: 5 <-> 4 <-> 3 <-> 2 <-> 1");
         System.out.println("Expected Backward: 1 <-> 2 <-> 3 <-> 4 <-> 5");
         printForward(dll);
         printBackward(dll);
         System.out.println();

         // Test 7: No change (start == end)
         System.out.println("Test 7: No Change (start == end)");
         dll = new ReverseBetween(1);
         for (int i = 2; i <= 5; i++) dll.append(i);
         dll.reverseBetween(3,3);  // No change
         System.out.println("Expected Forward: 1 <-> 2 <-> 3 <-> 4 <-> 5");
         System.out.println("Expected Backward: 5 <-> 4 <-> 3 <-> 2 <-> 1");
         printForward(dll);
         printBackward(dll);
         System.out.println();
     }
     



}
