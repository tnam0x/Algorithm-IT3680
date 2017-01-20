package daysofcode;

public class BST<E extends Comparable<E>> {
	E[] array;

	// Tim value roi tra ve vi tri trong mang
	// Neu ko tim duoc thi tra ve -1
	int binarySearchRecursive(E value, int index, int left, int right) {
		if (left <= right) {
			int midIndex = left + ((right - left) / 2);
			// value is found
			if (value.equals(array[midIndex]))
				index = midIndex;
			else {
				// search left
				if (value.compareTo(array[midIndex]) < 0) {
					right = midIndex - 1;
				}
				// search right
				else {
					left = midIndex + 1;
				}
				index = binarySearchRecursive(value, index, left, right);
			}
		}
		return index;
	}

	// Kiểm tra Binary Tree có là Binary Search Tree
	boolean isBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTUtil(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max);
	}
}
