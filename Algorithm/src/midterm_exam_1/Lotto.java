package midterm_exam_1;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class Lotto {
	static int n, s[], out[];
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		s = new int[n];
		out = new int[6];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			s[i] = scanner.nextInt();
		}
		sort(s, n);
		TRY(0, 0);
		scanner.close();
	}

	static void TRY(int k, int previous) {
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (previous < s[i]) {
					out[k] = s[i];
					previous = out[k];
					if (k == 5) {
						for (int j = 0; j < 6; j++) {
							System.out.print(out[j] + " ");
						}
						System.out.println();
					} else {
						TRY(k + 1, previous);
					}
				}
				visited[i] = false;
			}
		}
	}

	// Sắp xếp tăng dần
	public static void sort(int[] a, int n) {
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
					int temp = a[i];
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
