package daysofcode;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

}

class MyQueue<E> {
	Stack<E> stack1;
	Stack<E> stack2;

	public MyQueue() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	void enqueue(E n) {
		stack1.push(n);
	}

	void dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		stack2.pop();
	}

	E peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
}
