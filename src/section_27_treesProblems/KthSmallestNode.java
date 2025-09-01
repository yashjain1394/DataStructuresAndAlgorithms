package section_27_treesProblems;

import java.util.ArrayList;

public class KthSmallestNode {


    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
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
    
    public Integer kthSmallest(int k){
        ArrayList<Integer> results=DFSInOrder();
        if(k<1 || k>results.size()){
            return null;
        }
        return results.get(k-1);
        
    }
    
    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> results=new ArrayList<>();
        class Traverse{
            public Traverse(Node currentNode){
                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right!=null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }
    

    

    
    public static void main(String[] args) {
        
    	KthSmallestNode bst = new KthSmallestNode();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1));  // Expected output: 2
        System.out.println(bst.kthSmallest(3));  // Expected output: 4
        System.out.println(bst.kthSmallest(6));  // Expected output: 7
        
    }
    

    


}
