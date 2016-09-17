package sorts;

import java.util.Arrays;

/** Độ phức tạp thuật toán O(n) */
public class RaddixSort {

	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 13, 9, 31, 4 };
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static void sort(int[] a) {
		int m = getMax(a);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(a, a.length, exp);
		}
	}

	// A function to do counting sort of a[] according to
    // the digit represented by exp.
	static void countSort(int[] a, int n, int exp) {
		int[] output = new int[n]; // output array
		int i;
		int[] count = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++) {
			count[(a[i] / exp) % 10]++;
		}

		// Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(a[i] / exp) % 10] - 1] = a[i];
			count[(a[i] / exp % 10)]--;
		}

		// Copy the output array to a[], so that a[] now
        // contains sorted numbers according to curent digit
		for (i = 0; i < n; i++) {
			a[i] = output[i];
		}
	}

	// Tìm giá trị lớn nhất của mảng
	static int getMax(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
}
