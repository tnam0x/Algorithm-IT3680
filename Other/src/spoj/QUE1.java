package spoj;

import java.util.Scanner;

/**
 * @author namtran
 */
public class QUE1 {
	static int[] heights, indexs;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCase = scanner.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			int people = scanner.nextInt(); // Tổng số người trong hàng
			heights = new int[people]; // Chiều cao
			indexs = new int[people]; // Chỉ số (số người cao hơn đứng trước họ)
			for (int j = 0; j < people; j++) {
				heights[j] = scanner.nextInt();
			}
			for (int j = 0; j < people; j++) {
				indexs[j] = scanner.nextInt();
			}
			sort(heights, people); // Sắp xếp giảm dần
			// Nếu chỉ số không đúng thì đổi chỗ
			for (int j = 0; j < people; j++) {
				if (indexs[j] != j) {
					// Đổi chỗ lần lượt từng phần tử từ k: j -> (index[j] + 1)
					for (int k = j; k > indexs[j]; k--) {
						int temp = heights[k];
						heights[k] = heights[k - 1];
						heights[k - 1] = temp;
					}
				}
			}
			// In ra màn hình
			for (int j = 0; j < people; j++) {
				System.out.print(heights[j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

	// Sắp xếp theo thứ tự giảm dần của chiều cao - đổi chỗ cả chỉ số
	static void sort(int[] a, int n) {
		int gap = n;
		float shrink = 1.3f;
		boolean sorted = false;

		while (gap > 1 || sorted == false) {
			// Update the gap value for a next comb
			gap = (int) (gap / shrink);
			if (gap < 1) {
				gap = 1;
			}
			int i = 0;
			if (gap == 1) {
				sorted = true;
			}

			// A single " comb " over the input list
			while (i + gap < n) {
				if (a[i] < a[i + gap]) {
					int temp1 = a[i];
					a[i] = a[i + gap];
					a[i + gap] = temp1;
					int temp2 = indexs[i];
					indexs[i] = indexs[i + gap];
					indexs[i + gap] = temp2;
					if (gap == 1) {
						sorted = false;
					}
				}
				i++;
			}
		}
	}
}
