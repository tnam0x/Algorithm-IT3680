package midterm_exam_3;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class Expr {
	static int n, b, count;
	static int[] a;
	static long bound[];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		b = scanner.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		bound = new long[n];
		bound[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			bound[i] = bound[i + 1] + a[i];
		}
		Try(1, a[0]);
		System.out.println(count % 1000000007);
		scanner.close();
	}

	static void Try(int i, int total) {
		if (total + bound[i] < b) {
			return;
		}
		if (total - bound[i] > b) {
			return;
		}
		for (int v = 0; v <= 1; v++) {
			if (v == 0)
				total -= a[i];
			else
				total += a[i];
			if (i == n - 1) {
				if (total == b) {
					count++;
				}
			} else
				Try(i + 1, total);
			if (v == 0)
				total += a[i];
			else
				total -= a[i];

		}
	}
}
