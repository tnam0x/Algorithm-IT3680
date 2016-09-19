package kattis;

import java.util.Scanner;

public class Trik {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		boolean[] a = { true, false, false };
		boolean temp;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == 'A') {
				temp = a[0];
				a[0] = a[1];
				a[1] = temp;
			} else if (c == 'B') {
				temp = a[1];
				a[1] = a[2];
				a[2] = temp;
			} else {
				temp = a[0];
				a[0] = a[2];
				a[2] = temp;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (a[i]) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}
