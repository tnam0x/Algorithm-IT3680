package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author namtran
 *
 */
public class ARRANGE {

	static int[] a;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			int amplifiers = Integer.parseInt(reader.readLine());
			a = new int[amplifiers];
			String[] line = reader.readLine().split(" ");
			for (int j = 0; j < amplifiers; j++) {
				a[j] = Integer.parseInt(line[j]);
			}
			sort(a);
			printf();
		}
	}

	static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > 0; j--) {
				if (a[j] > a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}

	static void printf() {
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != 1 && a[i] != 2) {
				break;
			}
			System.out.print(a[i] + " ");
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1 || a[i] == 2) {
				break;
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
