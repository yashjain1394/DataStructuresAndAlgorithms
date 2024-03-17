package section_26_treeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {
	private Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
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
			}else {
				if(temp.right==null) {
					temp.right=newNode;
					return true;
				}
				temp=temp.right;
			}
		}
		
	}
	
	public boolean contains(int value) {
		if(root==null) {
			return false;
		}
		Node temp=root;
		while(temp!=null) {
			if(value<temp.value) {
				temp=temp.left;
			}
			else if(value>temp.value) {
				temp=temp.right;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	
	public ArrayList<Integer> BFS() {
		ArrayList<Integer> results=new ArrayList<Integer>();
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(queue.size()>0) {
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
		ArrayList<Integer> results=new ArrayList<Integer>();
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
		ArrayList<Integer> results=new ArrayList<Integer>();
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
		ArrayList<Integer> results=new ArrayList<Integer>();
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
