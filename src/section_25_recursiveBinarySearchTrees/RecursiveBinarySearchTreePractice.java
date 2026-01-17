package section_25_recursiveBinarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RecursiveBinarySearchTreePractice {
	private Node root;
	
	public class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	public void rInsert(int value) {
		Node newNode=new Node(value);
		if(root==null) {
			root=newNode;
		}
		rInsert(root, value);
	}
	
	public Node rInsert(Node currentNode, int value) {
		if(currentNode==null) {
			return new Node(value);
		}
		if(value==currentNode.value) {
			return null;
		}
		if(value<currentNode.value) {
			currentNode.left=rInsert(currentNode.left, value);
		}
		else if(value>currentNode.value) {
			currentNode.right=rInsert(currentNode.right, value);
		}
		
		 return currentNode;
	}
	
	public boolean rContains(int value){
		if(root ==null) {
			return false;
		}
		return rContains(root, value);
		
	}
	
	public boolean rContains(Node currentNode, int value) {
		if(value==currentNode.value) {
			return true;
		}
		if(value<currentNode.value) {
			return rContains(currentNode.left,value);
		}
		else if(value>currentNode.value) {
			return rContains(currentNode.right,value);
		}
		return false;	
	}
	
	public void rDelete(int value) {
		if(root==null) {
			System.out.println("BST is empty");
		}
		rDelete(root,value);
	}
	
	public Node rDelete(Node currentNode,int value) {
		if(currentNode==null) {
			return null;
		}
		if(value<currentNode.value) {
			currentNode.left=rDelete(currentNode.left,value);
		}
		else if(value>currentNode.value) {
			currentNode.right=rDelete(currentNode.right,value);
		}
		else {
			if(currentNode.left==null && currentNode.right==null) {
				return null;
			}
			else if(currentNode.left!=null && currentNode.right==null) {
				currentNode=currentNode.left;
			}
			else if(currentNode.left==null && currentNode.right!=null) {
				currentNode=currentNode.right;
			}
			else {
				int subTreeMin=minValue(currentNode.right);
				currentNode.value=subTreeMin;
				currentNode.right=rDelete(currentNode.right,subTreeMin);
				
			}
		}
		return currentNode;
	}
	
	public int minValue(Node currentNode) {
		while(currentNode.left!=null) {
			currentNode=currentNode.left;
		}
		return currentNode.value;
	}
	
	public ArrayList<Integer> BFS(){
		ArrayList<Integer> results=new ArrayList<>();
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(queue.size()!=0) {
			Node currentNode=queue.remove();
			results.add(currentNode.value);
			if(currentNode.left!=null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right!=null) {
				queue.add(currentNode.right);
			}
		}
		return results;
	}
	
	public ArrayList<Integer> DFSPreOrder(){
		ArrayList<Integer> results=new ArrayList<>();
		class Traverse{
			public Traverse(Node currentNode) {
				results.add(currentNode.value);
				if(currentNode.left!=null) {
					new Traverse(currentNode.left);
				}
				if(currentNode.right!=null) {
				   new Traverse(currentNode.right);
				}
			}
			
		}
		new Traverse(root);
		return results;
	}
	
	public ArrayList<Integer> DFSInOrder(){
		ArrayList<Integer> results=new ArrayList<>();
		class Traverse{
			public Traverse(Node currentNode) {
				if(currentNode.left!=null) {
					new Traverse(currentNode.left);
				}
				results.add(currentNode.value);
				if(currentNode.right!=null) {
					new Traverse(currentNode.right);
				}
			}
		}
		new Traverse(root);
		return results;
		
	}
	
	public ArrayList<Integer> DFSPostOrder(){
		ArrayList<Integer> results=new ArrayList<>();
		class Traverse{
			public Traverse(Node currentNode) {
				if(currentNode.left!=null) {
					new Traverse(currentNode.left);
				}
				if(currentNode.right!=null) {
					new Traverse(currentNode.right);
				}
				results.add(currentNode.value);
			}
			
		}
		new Traverse(root);
		return results;
	}
	

	public static void main(String[] args) {
		RecursiveBinarySearchTreePractice myBST=new RecursiveBinarySearchTreePractice();
		
		myBST.rInsert(47);
		myBST.rInsert(21);
		myBST.rInsert(76);
		myBST.rInsert(18);
		myBST.rInsert(27);
		myBST.rInsert(52);
		myBST.rInsert(82);
		
		System.out.println("\nRoot: "+myBST.root.value);
		System.out.println("\nRoot->Left: "+myBST.root.left.value);
		System.out.println("\nRoot->Right: "+myBST.root.right.value);
		
		myBST.rDelete(2);
		
		System.out.println("\nRoot: "+myBST.root.value);
		System.out.println("\nRoot->Left: "+myBST.root.left.value);
		System.out.println("\nRoot->Right: "+myBST.root.right.value);
		
		System.out.println(myBST.BFS());
		System.out.println(myBST.DFSPreOrder());
		System.out.println(myBST.DFSPostOrder());
		System.out.println(myBST.DFSInOrder());

	}

}
