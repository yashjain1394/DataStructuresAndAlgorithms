package section_12_stacksAndQueuesProblems;

public class SortStack {

    
    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> additionalStack = new Stack<>();
        while(!stack.isEmpty()){
            int temp=stack.pop();
            while(!additionalStack.isEmpty() && additionalStack.peek()>temp){
                stack.push(additionalStack.pop());
            }
            additionalStack.push(temp);
        }
        
        while(!additionalStack.isEmpty()){
            stack.push(additionalStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack;

        System.out.println("These tests confirm sortStack sorts");
        System.out.println("the stack so the TOP is the LOWEST value.");
        System.out.println("printStack() shows the stack from top");
        System.out.println("to bottom (smallest to largest).");
        System.out.println();

        // Test 1: Empty stack
        System.out.println("Test 1: Empty Stack");
        stack = new Stack<>();
        sortStack(stack);
        System.out.println("Expected (top to bottom): empty");
        stack.printStack();
        System.out.println();

        // Test 2: Single element
        System.out.println("Test 2: Single Element");
        stack = new Stack<>();
        stack.push(5);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 5");
        stack.printStack();
        System.out.println();

        // Test 3: Unsorted stack
        System.out.println("Test 3: Unsorted Stack");
        stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        stack.printStack();
        System.out.println();

        // Test 4: Already sorted
        System.out.println("Test 4: Already Sorted Stack");
        stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        stack.printStack();
        System.out.println();

        // Test 5: Reverse sorted
        System.out.println("Test 5: Reverse Sorted Stack");
        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        stack.printStack();
        System.out.println();

        // Test 6: With duplicates
        System.out.println("Test 6: With Duplicates");
        stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 1, 2, 3, 3");
        stack.printStack();
        System.out.println();

        // Test 7: With negatives
        System.out.println("Test 7: With Negatives");
        stack = new Stack<>();
        stack.push(-1);
        stack.push(3);
        stack.push(-5);
        stack.push(2);
        sortStack(stack);
        System.out.println("Expected (top to bottom): -5, -1, 2, 3");
        stack.printStack();
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm sortStack sorts
            the stack so the TOP is the LOWEST value.
            printStack() shows the stack from top
            to bottom (smallest to largest).

            Test 1: Empty Stack
            Expected (top to bottom): empty

            Test 2: Single Element
            Expected (top to bottom): 5
            5

            Test 3: Unsorted Stack
            Expected (top to bottom): 1, 2, 3, 4
            1
            2
            3
            4

            Test 4: Already Sorted Stack
            Expected (top to bottom): 1, 2, 3, 4
            1
            2
            3
            4

            Test 5: Reverse Sorted Stack
            Expected (top to bottom): 1, 2, 3, 4
            1
            2
            3
            4

            Test 6: With Duplicates
            Expected (top to bottom): 1, 1, 2, 3, 3
            1
            1
            2
            3
            3

            Test 7: With Negatives
            Expected (top to bottom): -5, -1, 2, 3
            -5
            -1
            2
            3
        */
        
    }
    


}
