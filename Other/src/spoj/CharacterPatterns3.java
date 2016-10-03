package spoj;

import java.util.Scanner;

public class CharacterPatterns3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCase = scanner.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			int row = scanner.nextInt() * 3 + 1;
			int col = scanner.nextInt() * 3 + 1;
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < col; k++) {
					if (j == 0 || j == row - 1 || j % 3 == 0) {
						System.out.print("*");
					} else {
						if (k == 0 || k == col - 1 || k % 3 == 0) {
							System.out.print("*");
						} else {
							System.out.print(".");
						}
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		scanner.close();
	}

}
