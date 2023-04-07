
public class Main {

	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	};
	
	static void print(Node parent) {
		Node curr = parent;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(18);
		root.left = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(12);
		root.left.right.left = new Node(8);
		root.left.right.left.left = new Node(6);
		root.left.right.left.right = new Node(9);
		root.left.right.right = new Node(14);
		root.right = new Node(21);
		print(traverse(root));
		System.out.println("\nFinished");
	}
	
	static Node cur, prev, smallest;
	private static Node traverse(Node root) {
		if(root == null) {
			return null;
		}
		traverse(root.left);
		prev = cur;
		cur = root;
		if(prev != null) {
			prev.right = cur;
			cur.left = prev;
		} else {
			smallest = cur;
		}
		traverse(root.right);
		return smallest;
	}

}
