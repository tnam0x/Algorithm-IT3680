package sorts;

/** Độ phức tạp thuật toán O(n2) */
public class CountingSort {

	public static void main(String[] args) {
		int a[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's' };
		sort(a);
		for (int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
	}

	static void sort(int[] a) {
		int n = a.length;

		// The output character array that will have sorted a
		int[] output = new int[n];
		// Create a count array to store count of inidividul
		// characters and initialize count array as 0
		int[] count = new int[256];
		for (int i = 0; i < 256; i++) {
			count[i] = 0;
		}
		// Store count of each character
		for (int i = 0; i < n; i++) {
			++count[a[i]];
		}

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; i++) {
			count[i] += count[i - 1];
		}

		// Build the output character array
		for (int i = 0; i < n; i++) {
			output[count[a[i]] - 1] = a[i];
			--count[a[i]];
		}

		// Copy the output array to a, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i) {
			a[i] = output[i];
		}
	}
}
