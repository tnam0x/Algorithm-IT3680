package week_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 *         <p>
 *         Dùng ma trận Nx2 để lưu các công việc, dùng Combsort sắp xếp theo
 *         chiều tăng dần của thời gian hoàn thành công việc.
 *         Dùng 1 biến lưu thời gian kết thúc công việc của việc được chọn.
 *         Sau đó dùng 1 vòng for duyệt từ 1..N, kiểm tra nếu thời gian bắt đầu
 *         công việc đang xét >= thời gian kết thúc công việc
 *         trước đó thì tăng biến count.
 *         <p>
 *         Độ phức tạp thuật toán: O(n^2logn)
 */
public class BUSYMAN {
	static int[][] activities;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine());
			activities = new int[N][2];
			for (int j = 0; j < N; j++) {
				String line[] = reader.readLine().split(" ");
				activities[j][0] = Integer.parseInt(line[0]);
				activities[j][1] = Integer.parseInt(line[1]);
			}
			sort(activities, N);
			int end = 0, count = 0;
			for (int j = 0; j < N; j++) {
				if (activities[j][0] >= end) {
					count++;
					end = activities[j][1];
				}
			}
			System.out.println(count);
		}
	}

	public static void sort(int[][] a, int n) {
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
				if (a[i][1] > a[i + gap][1]) {
					swap(i, i + gap);
					if (gap == 1) {
						sorted = false;
					}
				}
				i++;
			}
		}
	}

	static void swap(int i, int j) {
		int temp1 = activities[i][0];
		activities[i][0] = activities[j][0];
		activities[j][0] = temp1;
		int temp2 = activities[i][1];
		activities[i][1] = activities[j][1];
		activities[j][1] = temp2;
	}
}
