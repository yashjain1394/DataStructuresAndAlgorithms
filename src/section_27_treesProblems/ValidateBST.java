package section_27_treesProblems;

import java.util.ArrayList;

public class ValidateBST {


    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

	public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        
        new Traverse(root);
        return results;
    }
    
    public boolean isValidBST(){
        ArrayList<Integer> al=DFSInOrder();
        for(int i=1;i<al.size();i++){
            if(al.get(i-1)>al.get(i)){
                return false;
            }
        }
        return true;
    }


    
    public static void main(String[] args) {
        testSingleNodeTree();
        testValidBST();
        testValidBSTWithDeepLeftSubtree();
        testValidBSTWithDeepRightSubtree();
        testBalancedBST();
    }

    private static void testSingleNodeTree() {
        System.out.println("\n----- Test: Single Node Tree -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        printIsValidBST(bst);
    }

    private static void testValidBST() {
        System.out.println("\n----- Test: Valid BST -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepLeftSubtree() {
        System.out.println("\n----- Test: BST With Deep Left Subtree -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepRightSubtree() {
        System.out.println("\n----- Test: BST With Deep Right Subtree -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(12);
        bst.insert(14);
        bst.insert(16);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void testBalancedBST() {
        System.out.println("\n----- Test: Balanced BST -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void printIsValidBST(ValidateBST bst) {
        System.out.println("Is valid BST: " + bst.isValidBST());
    }
    


}
