package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         Code tham khảo trên internet
 *         <p>
 *         Đầu tiên ta tính tổng (sum) các số từ 1..N.
 *         Do ta sẽ chèn các dấu trừ trước số x để được tổng S nên tổng sum sẽ
 *         giảm đi 2x.
 *         Ta thấy sum - S = 2c luôn là số chẵn, trong đó c là tổng các số ta
 *         cần đặt dấu trừ trước nó.
 *         Thuật toán dùng 2 vòng for để duyệt, vòng for đầu để chọn điểm bắt
 *         đầu duyệt cho vòng for thứ 2.
 *         Xét từ j -> 2 nếu số nào c trừ được vẫn giữ cho không âm thì ta trừ
 *         thẳng.
 *         Đến lúc cuối nều c != 0 thì xem như không có cách.
 *         Ta dùng 1 mảng để lưu vị trí cần đặt dấu "-".
 *         <p>
 *         Độ phức tạp thuật toán: O(n^2)
 */
public class BLOPER {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int S = scanner.nextInt();
		boolean minus[] = new boolean[N + 1];
		int sum = N * (N + 1) / 2;
		int c = sum - S;
		if (c % 2 == 1) {
			System.out.print("Impossible");
		} else {
			c /= 2;
			for (int i = N; i >= 2; i--) {
				int temp = c;
				minus = new boolean[N + 1];
				for (int j = i; j >= 2; j--) {
					if (temp - j >= 0) {
						temp -= j;
						minus[j] = true;
					}
				}
				if (temp == 0) {
					c = 0;
					break;
				}
			}
			if (c != 0) {
				System.out.print("Impossible");
			} else {
				System.out.print(1);
				for (int i = 2; i <= N; i++) {
					if (minus[i]) {
						System.out.print("-");
					} else {
						System.out.print("+");
					}
					System.out.print(i);
				}
			}
		}
		scanner.close();
	}

}
