package day_4;

import java.util.Scanner;

public class InversionCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCase = scanner.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			int size = scanner.nextInt();
			if (size <= 200000) {
				int[] a = new int[size];
				for (int j = 0; j < size; j++) {
					a[j] = scanner.nextInt();
					if (a[j] > 10000000) {
						break;
					}
				}
				System.out.println(sort(a, 0, size - 1));
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	public static int sort(int array[], int first, int last) {
		int invCount = 0;
		if (first < last) {
			int middle = (first + last) / 2;
			invCount = sort(array, first, middle);
			invCount += sort(array, middle + 1, last);
			invCount += merge(array, first, middle, last);
		}
		return invCount;
	}

	static int merge(int array[], int first, int middle, int last) {
		int[] temp = new int[last + 1];
		int first1, last1, first2, last2;
		int index = first;
		int invCount = 0;

		first1 = first;
		last1 = middle;
		first2 = middle + 1;
		last2 = last;

		while ((first1 <= last1) && (first2 <= last2)) {
			if (array[first1] < array[first2]) {
				temp[index++] = array[first1++];
			} else {
				temp[index++] = array[first2++];
				invCount += (last1 - first1 + 1);
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
		return invCount;
	}
}
