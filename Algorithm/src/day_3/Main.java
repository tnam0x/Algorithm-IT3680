package day_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		float[] inp = new float[n];
		for (int i = 0; i < n; i++) {
			inp[i] = scanner.nextFloat();
		}
		scanner.close();

		sort(inp, inp.length);
		for (int i = 0; i < n; i++) {
			System.out.print(inp[i]);
			if (i != n - 1) {
				System.out.print(" ");
			}
		}
	}

	public static void sort(float[] a, int n) {
		int gap = n;
		float shrink = 1.3f;
		boolean sorted = false;

		while (gap > 1 || sorted == false) {
			// Update the gap value for a next comb
			gap = (int) (gap / shrink);
			if (gap < 1) {
				gap = 1;
			}
			int i = 0;
			if (gap == 1) {
				sorted = true;
			}

			// A single " comb " over the input list
			while (i + gap < n) {
				if (a[i] > a[i + gap]) {
					float temp = a[i];
					a[i] = a[i + gap];
					a[i + gap] = temp;
					if (gap == 1) {
						sorted = false;
					}
				}
				i++;
			}
		}
	}
}
