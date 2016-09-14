package day_5;

import java.util.Scanner;

public class BinaryList {
	private static int[] a;
	private static String[] items;
	private static String token;
	private static int n, k, i, index = 0;

	private static void TRY(int j) {
		for (int v = 0; v <= 1; v++) {
			a[j] = v;
			if (j == n - 1) {
				int numberOfZero = 1;
				token = String.valueOf(a[0]);
				for (int l = 1; l < n; l++) {
					if (a[l - 1] == 0 && a[l] == 0) {
						numberOfZero++;
						token += a[l];
					}
				}
				if (numberOfZero < i) {
					items[index++] = token;
				}
				System.out.println(token);
			} else {
				TRY(j + 1);
			}
		}
	}

	private static void list(int n) {
		BinaryList.n = n;
		a = new int[n];
		items = new String[(int) Math.pow(2, n)];
		TRY(0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		k = scanner.nextInt();
		i = scanner.nextInt();
		list(n);
		if (items.length < k) {
			System.out.println(-1);
		} else {
			System.out.println(items[k]);
		}
		scanner.close();
	}

}
