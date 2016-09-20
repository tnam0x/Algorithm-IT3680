package sorts;

/**
 * Độ phức tạp thuật toán: trung bình O(nlogn) - xấu nhất: O(n^2)
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 13, 9, 31, 4 };
		sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void sort(int a[], int left, int right) {
		int i = left, j = right;
		int x = a[(left + right) / 2];
		do {
			// tìm phần tử sai vị trí
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			// Hoán đổi nếu i nằm trước j
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		} while (i < j);
		if (left < j) {
			sort(a, left, j);
		}
		if (right > i) {
			sort(a, i, right);
		}
	}
}
