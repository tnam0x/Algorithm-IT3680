package daysofcode;

public class Node {
	Node left, right;
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		left = right = null;
		next = null;
	}

	int getHeight(Node root) {
		if (root == null) {
			return -1;
		}
		int leftDepth = getHeight(root.left);
		int rightDepth = getHeight(root.right);

		return Math.max(leftDepth, rightDepth) + 1;

	}
}
