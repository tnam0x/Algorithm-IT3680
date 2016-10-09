package week_3;

import java.util.Scanner;

public class CombinationList {

	static int[] combination;
	static int n, m, k, index;

	static void TRY(int number) {
		for (int i = combination[number - 1] + 1; i <= n - m + number; i++) {
			combination[number] = i;
			if (number == m) {
				index++;
				if (k == index) {
					for (int j = 1; j <= m; j++) {
						System.out.print(combination[j] + " ");
					}
					System.exit(0);
				}
			} else {
				TRY(number + 1);
			}
		}
	}

	static void list() {
		combination = new int[m + 1];
		combination[0] = 0;
		TRY(1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		k = scanner.nextInt();
		scanner.close();
		list();
		System.out.println(-1);
	}
}
