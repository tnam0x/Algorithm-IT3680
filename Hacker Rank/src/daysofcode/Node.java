package daysofcode;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	Node left, right;
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		left = right = null;
		next = null;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		Node current;
		if (data <= root.data) {
			current = insert(root.left, data);
			root.left = current;
		} else {
			current = insert(root.right, data);
			root.right = current;
		}
		return root;
	}

	public static Node removeDuplicates(Node head) {
		//Write your code here
		Node current = head;
		while (current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	// left - root - right
	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	// left - right - root
	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	// root - left - right
	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	// level - by - level or breadth - first - search (BFS)
	public static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			System.out.print(current.data + " ");
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
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
