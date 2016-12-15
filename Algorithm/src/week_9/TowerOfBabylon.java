package week_9;

import java.util.Scanner;

/**
 * @author namtran
 *         <p>
 *         Code tham khảo trên mạng
 *         <p>
 *         Độp phức tạp thuật toán: O(n^2)
 *         <p>
 *         Sử dụng thuật toán qui hoạch động.
 *         Dùng 3 mảng x, y, z để lưu độ dài các cạnh của khối.
 *         Ta hoán đổi các cạnh để được 1 khối khác sao cho không trùng cạnh
 *         (x-y-z thì ko được dùng x-z-y dp trùng x).
 *         Khi đó, từ 1 khối ta có thể tạo ra 3 khối. Sắp xếp theo thứ tự tăng
 *         dần sao cho x[j] < x[i] && y[j] < y[i] hoặc y[j] < x[i] && x[j] <
 *         y[i]. Sau đó kiểm tra nếu thỏa mãn điều kiện khối trên có x và y nhỏ
 *         hơn khối dưới thì cộng chiều cao lại, sau đó tìm max.
 */
public class TowerOfBabylon {
	static int x[], y[], z[], dp[];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int testCase = 1;
		while (n > 0) {
			// Khởi tạo mảng
			int N = 3 * n;
			x = new int[N];
			y = new int[N];
			z = new int[N];
			dp = new int[N]; // Mảng lưu độ cao của tòa tháp với đáy tại vị trí i
			// Đọc dữ liệu
			for (int i = 0; i < n; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				int j = 3 * i;
				// Loại 1
				x[j] = a;
				y[j] = b;
				z[j] = c;
				// Loại 2
				x[j + 1] = b;
				y[j + 1] = c;
				z[j + 1] = a;
				// Loại 3
				x[j + 2] = c;
				y[j + 2] = a;
				z[j + 2] = b;
			}
			// Sắp xếp x, y, z theo thứ tự tăng dần của kích thước 2 cạnh đáy
			sort(N);
			// Tìm độ cao của tòa tháp cao nhất
			int max = 0;
			for (int i = 0; i < N; i++) {
				dp[i] = z[i];
				for (int j = 0; j < i; j++) {
					// Nếu 2 cạnh khối trên (khối j) nhỏ hơn 2 cạnh của khối dưới cùng (khối i)
					if ((x[j] < x[i] && y[j] < y[i]) || (y[j] < x[i] && x[j] < y[i])) {
						// Cập nhật độ cao lớn nhất của tòa tháp với đáy tại vị trí i
						dp[i] = dp[i] > (dp[j] + z[i]) ? dp[i] : (dp[j] + z[i]);
					}
				}
				// Cập nhật độ cao lớn nhất của tòa tháp
				max = max > dp[i] ? max : dp[i];
			}
			System.out.println("Case " + (testCase++) + ": maximum height = " + max);
			n = scanner.nextInt();
		}
		scanner.close();
	}

	static void sort(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// Phần tử sau có x,y nhỏ hơn phần tử trước thì đổi chỗ
				if ((x[j] < x[i] && y[j] < y[i]) || y[j] < x[i] && x[j] < y[i]) {
					swap(i, j);
				}
			}
		}
	}

	static void swap(int i, int j) {
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
		temp = y[i];
		y[i] = y[j];
		y[j] = temp;
		temp = z[i];
		z[i] = z[j];
		z[j] = temp;
	}
}
