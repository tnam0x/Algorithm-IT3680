package crackingthecodinginterview;

import java.util.Scanner;

public class CountingInversions {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			System.out.println(sort(arr, 0, n - 1));
		}
		in.close();
	}

	static long sort(int array[], int start, int end) {
		long invCount = 0;
		if (start < end) {
			int middle = (start + end) / 2;
			invCount = sort(array, start, middle);
			invCount += sort(array, middle + 1, end);
			invCount += merge(array, start, middle, end);
		}
		return invCount;
	}

	static long merge(int a[], int start, int mid, int end) {
		long invCount = 0;
		int sizeL = mid - start + 1;
		int sizeR = end - mid;

		int[] left = new int[sizeL];
		int[] right = new int[sizeR];

		for (int i = 0; i < sizeL; i++) {
			left[i] = a[start + i];
		}
		for (int i = 0; i < sizeR; i++) {
			right[i] = a[mid + 1 + i];
		}

		int iLeft = 0, iRight = 0, i = start;
		while (iLeft < sizeL && iRight < sizeR) {
			if (left[iLeft] <= right[iRight]) {
				a[i++] = left[iLeft++];
			} else {
				a[i++] = right[iRight++];
				invCount += sizeL - iLeft;
			}
		}

		while (iLeft < sizeL)
			a[i++] = left[iLeft++];
		while (iRight < sizeR)
			a[i++] = right[iRight++];
		return invCount;
	}
}
