package day_5;

import java.util.Scanner;

public class BinaryList {
	static int[] binary;
	static int n, k, i, index, numberOfZero;
	static boolean isValid = true;

	static void TRY(int number) {
		System.out.println(number);
		for (int b = 0; b <= 1; b++) {
			binary[number] = b;
//			if (b == 0) {
//				numberOfZero++;
//				if (numberOfZero == i) {
//					isValid = false;
//				}
//			} else {
//				numberOfZero = 0;
//			}
			if (number == n - 1) {
				if (isValid) {
					index++;
//					if (index == k) {
						for (int m = 0; m < n; m++) {
							System.out.print(binary[m] + " ");
						}
						System.out.println();
//						System.exit(0);
//					}
				}
			} else {
				TRY(number + 1);
			}
		}
	}

	static void list() {
		binary = new int[n];
		TRY(0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		i = scanner.nextInt();
		scanner.close();
		list();
		System.out.println(-1);
	}

}
