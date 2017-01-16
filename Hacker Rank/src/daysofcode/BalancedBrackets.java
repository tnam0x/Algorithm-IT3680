package daysofcode;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
		Stack<Character> openingBrackets = new Stack<>();
		for (char c : expression.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				openingBrackets.push(c);
			} else {
				if (openingBrackets.size() == 0 || !isMatched(openingBrackets.pop(), c)) {
					return false;
				}
			}
		}
		return openingBrackets.isEmpty();
	}

	static boolean isMatched(char open, char close) {
		if (open == '(') {
			if (close == ')') {
				return true;
			}
		} else if (open == '[') {
			if (close == ']') {
				return true;
			}
		} else if (open == '{') {
			if (close == '}') {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
		in.close();
	}

}
