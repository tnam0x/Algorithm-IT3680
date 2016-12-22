package daysofcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Detect a cycle in a linked list. Note that the head pointer may be 'null'
 * if the list is empty.
 * A Node is defined as:
 */
public class HasCycle {

	class Node {
		int data;
		Node next;
	}

	/**
	 * If a loop exists, then the fast pointer will eventually end up behind the
	 * slow pointer. The fast pointer will then catch up to the slow pointer,
	 * detecting the loop. This will always happen, no matter the size of the
	 * loop.
	 */
	boolean hasCycle(Node head) {
		if (head == null)
			return false;
		Node slow = head;
		Node fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	boolean hasCycle1(Node head) {
		Set<Node> seen = new HashSet<>();
		while (head != null) {
			seen.add(head);
			head = head.next;
			if (seen.contains(head)) {
				return true;
			}
		}
		return false;
	}

}
