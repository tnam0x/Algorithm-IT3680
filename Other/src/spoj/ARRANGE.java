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
			sort(a, 0, amplifiers - 1);
			printf();
		}
	}

	public static void sort(int array[], int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;
			sort(array, first, middle);
			sort(array, middle + 1, last);
			merge(array, first, middle, last);
		}
	}

	static void merge(int array[], int first, int middle, int last) {
		int[] temp = new int[last + 1];
		int first1, last1, first2, last2;
		int index = first;

		first1 = first;
		last1 = middle;
		first2 = middle + 1;
		last2 = last;

		while ((first1 <= last1) && (first2 <= last2)) {
			if (array[first1] < array[first2]) {
				temp[index++] = array[first1++];
			} else {
				temp[index++] = array[first2++];
			}
		}

		while (first1 <= last1) {
			temp[index++] = array[first1++];
		}

		while (first2 <= last2) {
			temp[index++] = array[first2++];
		}

		for (index = first; index <= last; index++) {
			array[index] = temp[index];
		}
	}

	static void printf() {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 1 && a[i] != 2) {
				break;
			}
			System.out.print(a[i] + " ");
		}
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] == 1 || a[i] == 2) {
				break;
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
