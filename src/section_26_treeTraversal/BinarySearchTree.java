package section_26_treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	/*
	 * insert() method:
	 * create newNode
	 * if root==null then root=newNode
	 * temp=root
	 * while loop
	 * 	if newNode==temp return false
	 * 	if < left else > right
	 * 	if null insert newNode else move to next
	 */
	
	public boolean insert(int value) {
		Node newNode=new Node(value);
		if(root==null) {
			root=newNode;
			return true;
		}
		Node temp=root;
		while(true) {
			if(newNode.value==temp.value) {
				return false;
			}
			if(newNode.value<temp.value) {
				if(temp.left==null) {
					temp.left=newNode;
					return true;
				}
				temp=temp.left;
			}
			else {
				if(temp.right==null) {
					temp.right=newNode;
					return true;
				}
				temp=temp.right;
			}
		}
	}
	
	/*
	 * contains() method:
	 * if root==null return false
	 * temp=root
	 * while temp!=null
	 * 	if < left
	 * 	else if > right
	 * 	else == return true
	 * return false
	 * 
	 */
	
	public boolean contains(int value) {
		if(root==null) {
			return false;
		}
		Node temp=root;
		while(temp!=null) {
			if(value<temp.value) {
				temp=temp.left;
			}
			else if(value > temp.value) {
				temp=temp.right;
				
			}else {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Integer> BFS(){
		Node currentNode=root;
		Queue<Node> queue=new LinkedList<>();
		ArrayList<Integer> results=new ArrayList<>();
		queue.add(currentNode);
		while(queue.size()>0) {
			currentNode=queue.remove();
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Constructor
//		BinarySearchTree myBST=new BinarySearchTree();
//		System.out.println("root= "+myBST.root);
		
//		insert() method
//		BinarySearchTree myBST=new BinarySearchTree();
//		myBST.insert(47);
//		myBST.insert(21);
//		myBST.insert(76);
//		myBST.insert(18);
//		myBST.insert(52);
//		myBST.insert(82);
//		
//		myBST.insert(27);
//		
//		System.out.println(myBST.root.left.right.value);
		
//		contains() method
//		BinarySearchTree myBST=new BinarySearchTree();
//		
//		myBST.insert(47);
//		myBST.insert(21);
//		myBST.insert(76);
//		myBST.insert(18);
//		myBST.insert(27);
//		myBST.insert(52);
//		myBST.insert(82);
//		
//		System.out.println(myBST.contains(27));
//		
//		System.out.println(myBST.contains(17));
		
//		BFS & DFS
		BinarySearchTree myBST=new BinarySearchTree();
		
		myBST.insert(47);
		myBST.insert(21);
		myBST.insert(76);
		myBST.insert(18);
		myBST.insert(27);
		myBST.insert(52);
		myBST.insert(82);
		
		System.out.println(myBST.BFS());
		System.out.println(myBST.DFSPreOrder());
		System.out.println(myBST.DFSPostOrder());
		System.out.println(myBST.DFSInOrder());

	}

}
