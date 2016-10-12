package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class ATMWithdrawal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			// input
			int W = scanner.nextInt(); // Số tiền cần rút
			int c = scanner.nextInt(); // Số mũ để tính ra bộ các loại tiền
			// set of currency
			int length = 4 * (c + 1);
			int[] currency = new int[length];
			int j = length - 1;
			while (c >= 0) {
				currency[j--] = (int) (5000 * Math.pow(10, c));
				currency[j--] = (int) (3000 * Math.pow(10, c));
				currency[j--] = (int) (2000 * Math.pow(10, c));
				currency[j--] = (int) (1000 * Math.pow(10, c));
				c--;
			}
			// Tìm vị trí bắt đầu duyệt
			int start = 0;
			for (int l = length - 1; l >= 0; l--) {
				if (currency[l] <= W) {
					start = l;
					break;
				}
			}

			int N = Integer.MAX_VALUE; // Số loại tiền rút
			int S = 0; // Số cách rút mà cho N ít nhất
			for (int k2 = start; k2 >= 0; k2--) {
				int k = k2;
				int count = 0, money = W;
				while (money > 0) {
					if (currency[k] <= money) {
						count += money / currency[k];
						money = money % currency[k];
					}
					k--;
				}
				if (count < N) {
					N = count;
					S = 1;
				} else if (count == N) {
					S++;
				}
			}
			// output
			if (S == 0) {
				System.out.println(0);
			} else {
				System.out.println(N + " " + S);
			}
		}
		scanner.close();
	}

}
