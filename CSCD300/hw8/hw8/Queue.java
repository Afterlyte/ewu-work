

public class Queue {

	private class Node {
		private Object data;
		private Node next;
		
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public Node(Object data) {
			this(data, null);
		}
	}
	
	private Node head, tail;
	private int size;
	
	public Queue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void enqueue(Object data) {
		Node nn = new Node(data);
		if(this.size == 0) {
			this.head = nn;
			this.tail = nn;
		}
		else {
			this.tail.next = nn;
			this.tail = this.tail.next;
		}
		this.size++;
	}
	
	public Object dequeue() throws Exception {
		if(this.size == 0) {
			throw new Exception("Queue is empty, cannot dequeue");
		}
		Object res = this.head.data;
		this.head = this.head.next;
		this.size--;
		if(this.size == 0) {
			this.tail = null;
		}
		return res;
	}
	
	public Object front() throws Exception {
		if(this.size == 0) {
			throw new Exception("Queue is empty, cannot return front value");
		}
		return this.head.data;
	}
	
	public int getSize() {
		return this.size;
	}
	
}
