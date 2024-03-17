package section_25_recursiveBinarySearchTrees;

public class RecursiveBinarySearchTree {
	private Node root;
	
	public class Node{
		Node left; 
		Node right;
		int value;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	private boolean rContains(Node currentNode, int value) {
		if(currentNode==null) return false;
		if(currentNode.value==value) return true;
		if(value<currentNode.value) {
			return rContains(currentNode.left, value);
		}else {
			return rContains(currentNode.right, value);
		}
		
	}
	
	public boolean rContains(int value) {
		return rContains(root, value);
	}
	
	private Node rInsert(Node currentNode, int value) {
		if(currentNode==null) return new Node(value);
		if(value<currentNode.value) {
			currentNode.left=rInsert(currentNode.left, value);
		}else if(value > currentNode.value) {
			currentNode.right=rInsert(currentNode.right, value);
		}
		return currentNode;
	}
	
	public void rInsert(int value) {
		if(root==null) root=new Node(value);
		rInsert(root, value);
	}
	
	public int minValue(Node currentNode) {
		while(currentNode.left!=null) {
			currentNode=currentNode.left;
		}
		return currentNode.value;
	}
	
	private Node deleteNode(Node currentNode,int value) {
		if(currentNode==null) return null;
		if(value<currentNode.value) {
			currentNode.left=deleteNode(currentNode.left, value);
		}else if(value>currentNode.value) {
			currentNode.right=deleteNode(currentNode.right, value);
		}else {
			if(currentNode.left==null && currentNode.right==null) {
				return null;
			}
			else if(currentNode.left==null) {
				currentNode=currentNode.right;
			}
			else if(currentNode.right==null) {
				currentNode=currentNode.left;
			}
			else {
				int subTreeMin=minValue(currentNode.right);
				currentNode.value=subTreeMin;
				currentNode.right=deleteNode(currentNode.right, subTreeMin);
				}
		}
		return currentNode;
		
	}
	
	
	public void deleteNode(int value) {
		deleteNode(root,value);	
	}
	
	public static void main(String[] args) {
		//Contains method
//		RecursiveBinarySearchTree myBST=new RecursiveBinarySearchTree();
//		
//		myBST.rInsert(47);
//		myBST.rInsert(21);
//		myBST.rInsert(76);
//		myBST.rInsert(18);
//		myBST.rInsert(27);
//		myBST.rInsert(52);
//		myBST.rInsert(82);
//		
//		System.out.println("\nBST Contains 27:");
//		System.out.println(myBST.rContains(27));
//		
//		System.out.println("\nBST Contains 17:");
//		System.out.println(myBST.rContains(17));
		
		//Insert method
//		RecursiveBinarySearchTree myBST=new RecursiveBinarySearchTree();
//				
//		myBST.rInsert(2);
//		myBST.rInsert(1);
//		myBST.rInsert(3);
//		
//		System.out.println("\nRoot: "+myBST.root.value);
//		System.out.println("\nRoot->Left: "+myBST.root.left.value);
//		System.out.println("\nRoot->Right: "+myBST.root.right.value);

		//minValue
//		RecursiveBinarySearchTree myBST=new RecursiveBinarySearchTree();
//		
//		myBST.rInsert(47);
//		myBST.rInsert(21);
//		myBST.rInsert(76);
//		myBST.rInsert(18);
//		myBST.rInsert(27);
//		myBST.rInsert(52);
//		myBST.rInsert(82);
//		
//		System.out.println(myBST.minValue(myBST.root));
//		System.out.println(myBST.minValue(myBST.root.right));
		
		//Delete method
		RecursiveBinarySearchTree myBST=new RecursiveBinarySearchTree();
				
		myBST.rInsert(2);
		myBST.rInsert(1);
		myBST.rInsert(3);
		
		System.out.println("\nRoot: "+myBST.root.value);
		System.out.println("\nRoot->Left: "+myBST.root.left.value);
		System.out.println("\nRoot->Right: "+myBST.root.right.value);
		
		myBST.deleteNode(2);
		
		System.out.println("\nRoot: "+myBST.root.value);
		System.out.println("\nRoot->Left: "+myBST.root.left.value);
		System.out.println("\nRoot->Right: "+myBST.root.right);

	}
	
	

}
