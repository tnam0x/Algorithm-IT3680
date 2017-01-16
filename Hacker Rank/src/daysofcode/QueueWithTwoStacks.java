package daysofcode;

import java.util.Stack;

public class QueueWithTwoStacks<E> {
	Stack<E> stack1;
	Stack<E> stack2;

	public QueueWithTwoStacks() {
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
