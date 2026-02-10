package section_15_hashTable;

import java.util.ArrayList;

public class HashTablePractice {
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
	
	public HashTablePractice(int size) {
		dataMap=new Node[size];
	}
	
	public int hash(String key) {
		int hash=0;
		char[] keyChar=key.toCharArray();
		for(int i=0;i<keyChar.length;i++) {
			int asciiCode=keyChar[i];
			hash=(hash+asciiCode*23)%dataMap.length;
		}
		return hash;
	}
	
	public void set(String key,int value) {
		int index=hash(key);
		Node newNode=new Node(key, value);
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
		if(temp.key!=key) {
			temp=temp.next;
		}else {
			return temp.value;
		}
		return 0;
	}
	
	public ArrayList<String> keys(){
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
	
	public void printHashTable() {
		for(int i=0;i<dataMap.length;i++) {
			Node temp=dataMap[i];
			System.out.println(i+":");
			while(temp!=null) {
				System.out.print("{key:"+temp.key+", value:"+temp.value+"}->");
				temp=temp.next;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable myHashTable=new MyHashTable(7);
		myHashTable.set("nails", 100);
		myHashTable.set("tile", 50);
		myHashTable.set("lumber", 80);
		myHashTable.set("bolts", 40);
		myHashTable.set("paint", 20);	
		myHashTable.printTable();
		System.out.println(myHashTable.get("nails"));
		System.out.println(myHashTable.get("tile"));
		System.out.println(myHashTable.get("lumber"));
		System.out.println(myHashTable.get("bolts"));
		System.out.println(myHashTable.get("paint"));
		System.out.println(myHashTable.keys());

	}

}
