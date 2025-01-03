package section_15_hashTable;

import java.util.ArrayList;

public class HashTable {

	private int size=7;
	private Node[] dataMap;


	public class Node{
		private String key;
		private int value;
		private Node next;

		public Node(String key, int value) {
			this.key=key;
			this.value=value;
		}
	}

	public HashTable() {
		dataMap=new Node[size];
	}

	public void printTable() {
		for(int i=0;i<dataMap.length;i++) {
			System.out.print(i+":");
			Node temp=dataMap[i];
			while(temp!=null) {
				System.out.print(" {"+temp.key+"="+temp.value+"} "+"->");
				temp=temp.next;
			}
			System.out.println();
		}
	}

	private int hash(String key) {
		int hash=0;
		char[] keyChars=key.toCharArray();
		for(int i=0;i<keyChars.length;i++) {
			int asciiValue=keyChars[i];
			hash=(hash+asciiValue*23)%dataMap.length;
		}
		return hash;
	}

	public void set(String key,int value) {
		int index=hash(key);
		Node newNode=new Node(key,value);
		if(dataMap[index]==null) {
			dataMap[index]=newNode;
		}
		else {
			Node temp=dataMap[index];
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
	}

	public int get(String key) {
		int index=hash(key);
		Node temp=dataMap[index];
		while(temp!=null) {
			if(temp.key==key) {
				return temp.value;
			}
			temp=temp.next;
		}
		return 0;
	}

	public ArrayList keys() {
		ArrayList<String> allKeys=new ArrayList<>();
		for(int i=0;i<dataMap.length;i++) {
			Node temp=dataMap[i];
			while(temp!=null) {
				allKeys.add(temp.key);
				temp=temp.next;
			}

		}

		return allKeys;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Constructor
		//		HashTable myHashTable=new HashTable();
		//		myHashTable.printTable();

		//		set method
		//		HashTable myHashTable=new HashTable();
		//		myHashTable.set("nails", 100);
		//		myHashTable.set("tile", 50);
		//		myHashTable.set("lumber", 80);
		//		myHashTable.set("bolts", 200);
		//		myHashTable.set("screws", 140);	
		//		myHashTable.printTable();

		//		get method
		//		HashTable myHashTable=new HashTable();
		//		myHashTable.set("nails", 100);
		//		myHashTable.set("tile", 50);
		//		myHashTable.set("lumber", 80);
		//		myHashTable.printTable();
		//		System.out.println(myHashTable.get("lumber"));
		//		System.out.println(myHashTable.get("bolts"));

		//		keys method
		HashTable myHashTable=new HashTable();
		myHashTable.set("nails", 100);
		myHashTable.set("tile", 50);
		myHashTable.set("lumber", 80);
		myHashTable.set("bolts", 40);
		myHashTable.set("paint", 20);	
		myHashTable.printTable();
		System.out.println(myHashTable.keys());


	}

}
