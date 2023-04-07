// Author: Ian Kaiserman

public class LinkedList {
	
	// Node object class for Linked List objects
	private class Node {
		private Object data;   //Assume data implemented Comparable
		private Node next;
		private Node(Object data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	// Constructor for linked list with dummy head
	public LinkedList() {
		this.head = new Node(null, null );
		this.size = 0;
	}

	// Add the data element to the front of the Linked List
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head.next);
		this.head.next = nn;
		this.size++;
	}
	
	// Add the data element to the end of the Linked List
	public void addLast(Object data) {
		if(this.size == 0) {
			this.addFirst(data);
		}
		else {
			Node cur = this.head;
			while(cur.next != null) {
				cur = cur.next;
			}
			Node nn = new Node(data, null);
			cur.next = nn;
			this.size ++;
		}
	}
	
	// Override to convert Linked List to readable String
	@Override
	public String toString() {
		Node cur = this.head.next;
		String res = "" + cur.data;
		cur = cur.next;
		while(cur != null) {
			res += "," + cur.data;
			cur = cur.next;
		}
		return res;
	}

	// Return size of Linked List
	public int getSize() {
		return this.size;
	}

	// Return the first element of the Linked List
	public Object getFirst() {
		return this.head.next.data;
	}
	
	// Return the element of the Linked List at the given index (0-based indexing)
	public Object getAtIndex(int i) {
		Node cur = this.head;
		if(i >= 0 && i < this.size) {
			for(int j = 0; j <= i; j++) {
				cur = cur.next;
			}
			return cur.data;
		}
		else {
			System.out.println("Index not in list");
			return null;
		}
	}
	
}
