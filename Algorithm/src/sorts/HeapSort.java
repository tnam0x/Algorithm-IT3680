package sorts;

/** Độ phức tạp thuật toán O(nlogn) */
public class HeapSort {

	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 13, 9, 31, 4 };
		heapSort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static void heapSort(int a[], int n) {
		buildHeap(a, n);
		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i);
			heapify(a, i, 0);
		}
	}

	// Xây dựng Heap sao cho mọi nút cha luôn lớn hơn nút con trên cây
	static void buildHeap(int a[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(a, n, i);
		}
	}

	// Hoán vị nút cha thứ i phải lớn hơn nút con
	static void heapify(int a[], int n, int i) {
		int left = 2 * (i + 1) - 1;
		int right = 2 * (i + 1);
		int largest;
		if (left < n && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}
		if (right < n && a[right] > a[largest]) {
			largest = right;
		}
		if (i != largest) {
			swap(a, i, largest);
			heapify(a, n, largest);
		}
	}

	static void swap(int a[], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
