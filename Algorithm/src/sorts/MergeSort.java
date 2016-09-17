package sorts;

/** Độ phức tạp thuật toán: trung bình O(nlogn) */
public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 4, 2, 5, 10, 7, 1, 15, 74, 13, 21 };
		sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
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

}
