package week_7;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <p>
 *         Maximum Subsequence with Bounded Length
 *         <p>
 *         Sử dụng thuật toán qui hoạch động. Ta dùng 2 vòng for để duyệt.
 *         Vòng for đầu để lấy vị trí bắt đầu duyệt cho vòng for thứ 2.
 *         Ở vòng for thứ 2, ta dùng biến sum lưu tổng các phần tử, khi độ dài
 *         các phần tử đã duyệt >= L1,
 *         ta bắt đầu so sánh với biến max để tìm ra max của mảng con.
 *         <p>
 *         Độ phức tạp thuật toán: O(n^2)
 */
public class MSWBL {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int L1 = scanner.nextInt();
		int L2 = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		// Find max
		int max = 0;
		for (int i = 0; i < n - L2; i++) {
			int sum = 0;
			for (int j = i; j < i + L2; j++) {
				sum += a[j];
				if (j - i >= L1) {
					max = max > sum ? max : sum;
				}
			}
		}
		System.out.println(max);
		scanner.close();
	}

}
