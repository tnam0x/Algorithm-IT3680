package day_2;

import java.util.Scanner;

public class Add {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = Integer.parseInt(scanner.nextLine());
		int b = Integer.parseInt(scanner.nextLine());
		if (a <= 200 && b <= 200) {
			System.out.println(a + b);
		}
		scanner.close();
	}
}
