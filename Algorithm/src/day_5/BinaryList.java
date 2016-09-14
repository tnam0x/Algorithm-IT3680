package day_5;

import java.util.Scanner;

public class BinaryList {
	private static int[] binary;
	private static String token;
	private static int n, k, i, index = 0;
	private static boolean isSuccess = false;

	private static void TRY(int j) {
		for (int v = 0; v <= 1; v++) {
			binary[j] = v;
			if (j == n - 1) {
				boolean isAdd = true;
				boolean isReset = false;
				int numberOfZero = 0;
				token = "";
				for (int l = 0; l < n; l++) {
					token += String.valueOf(binary[l] + " ");
					if (binary[l] == 0) {
						if (isReset) {
							isReset = false;
							numberOfZero = 0;
						}
						numberOfZero++;
					} else {
						isReset = true;
					}
					if (numberOfZero == i) {
						isAdd = false;
						break;
					}
				}

				if (isAdd) {
					index++;
					if (k == index) {
						System.out.println(token);
						isSuccess = true;
						return;
					}
				}
			} else {
				if (isSuccess) {
					return;
				}
				TRY(j + 1);
			}
		}
	}

	private static void list() {
		binary = new int[n];
		TRY(0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		i = scanner.nextInt();
		if (n <= 10000 && k <= 10000 && i <= 10000) {
			list();
			if (!isSuccess) {
				System.out.println(-1);
			}
		}
		scanner.close();
	}

}
