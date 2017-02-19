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
			merge(array, first, last);
		}
	}

	static void merge(int array[], int start, int end) {
		int[] temp = new int[end + 1];
		int middle = (start + end) / 2;
		int i, j;
		int index = start;

		i = start;
		j = middle + 1;

		while ((i <= middle) && (j <= end)) {
			if (array[i] <= array[j]) {
				temp[index++] = array[i++];
			} else {
				temp[index++] = array[j++];
			}
		}

		while (i <= middle) {
			temp[index++] = array[i++];
		}

		while (j <= end) {
			temp[index++] = array[j++];
		}

		for (index = start; index <= end; index++) {
			array[index] = temp[index];
		}
	}

}
