package week_2;

import java.util.Scanner;

public class InversionCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCase = scanner.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			int size = scanner.nextInt();
			int[] a = new int[size];
			for (int j = 0; j < size; j++) {
				a[j] = scanner.nextInt();
			}
			long invCount = sort(a, 0, size - 1);
			System.out.println(invCount);
			scanner.nextLine();
		}
		scanner.close();
	}

	static long sort(int array[], int first, int last) {
		long invCount = 0;
		if (first < last) {
			int middle = (first + last) / 2;
			invCount = sort(array, first, middle);
			invCount += sort(array, middle + 1, last);
			invCount += merge(array, first, middle, last);
		}
		return invCount;
	}

	static long merge(int a[], int first, int mid, int last) {
		long invCount = 0;
		int sizeL = mid - first + 1;
		int sizeR = last - mid;

		int[] aL = new int[sizeL];
		int[] aR = new int[sizeR];

		for (int i = 0; i < sizeL; i++) {
			aL[i] = a[first + i];
		}
		for (int i = 0; i < sizeR; i++) {
			aR[i] = a[mid + 1 + i];
		}

		int idL = 0, idR = 0, id = first;
		while (idL < sizeL && idR < sizeR) {
			if (aL[idL] <= aR[idR]) {
				a[id++] = aL[idL++];
			} else {
				a[id++] = aR[idR++];
				invCount += sizeL - idL;
			}
		}

		while (idL < sizeL)
			a[id++] = aL[idL++];
		while (idR < sizeR)
			a[id++] = aR[idR++];
		return invCount;
	}
}
