package daysofcode;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		try {
			int n = Integer.parseInt(S);
			System.out.println(n);
		} catch (Exception e) {
			System.out.println("Bad String");
		}
		in.close();
	}
}
