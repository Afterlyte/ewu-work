
public class LinkedStack<E extends Comparable<? super E>> {
	
	public Node top;
	public int size;
	
	private class Node {
		
		private E data;
		private Node next;
		
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public LinkedStack() {
		this.top = null;
		this.size = 0;
	}
	
	public E pop() {
		if(this.size == 0) {
			throw new EmptyStackException("Empty stack, cannot pop");
		}
		E res = this.top.data;
		this.top = this.top.next;
		this.size--;
		return res;
	}
	
	public void push(E data) {
		Node newT = new Node(data, this.top);
		this.top = newT;
		this.size++;
	}
	
	public E getTop() {
		return this.top.data;
	}
}
