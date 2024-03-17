package section_13_trees;

public class MyBinarySearchTree {
	Node root;

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
			if(temp.value==newNode.value) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBinarySearchTree myBinarySearchTree=new MyBinarySearchTree();
		myBinarySearchTree.insert(1);
		myBinarySearchTree.insert(2);
		myBinarySearchTree.insert(3);
		myBinarySearchTree.insert(4);
		myBinarySearchTree.insert(5);
		myBinarySearchTree.insert(6);
		myBinarySearchTree.insert(7);
		myBinarySearchTree.insert(8);
		myBinarySearchTree.insert(9);
		myBinarySearchTree.insert(10);

		System.out.println(myBinarySearchTree.contains(11));
		System.out.println(myBinarySearchTree.contains(5));




	}

}
