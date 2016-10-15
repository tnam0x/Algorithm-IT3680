package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class ATMWithdrawal {

	static int[][] base = { { 1, 1 }, { 1, 1 }, { 1, 1 }, { 2, 2 }, { 1, 1 }, { 2, 2 }, { 2, 1 }, { 2, 1 }, { 3, 3 } };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			// input
			long W = scanner.nextLong(); // Số tiền cần rút
			int c = scanner.nextInt(); // Số mũ để tính ra bộ các loại tiền
			// set of currency
			int length = 4 * (c + 1);
			int[] currency = new int[length];
			int j = length - 1;
			int k = c;
			while (k >= 0) {
				currency[j--] = (int) (5000 * Math.pow(10, c));
				currency[j--] = (int) (3000 * Math.pow(10, c));
				currency[j--] = (int) (2000 * Math.pow(10, c));
				currency[j--] = (int) (1000 * Math.pow(10, c));
				k--;
			}

			long N = 0; // Số loại tiền rút
			int S = 0; // Số cách rút mà cho N ít nhất
			if (W / currency[length - 1] >= 10) {
				if (W % currency[length - 1] == 0) {
					N = W / currency[length - 1];
					S = 1;
				} else {
					long div = W / currency[length - 1], W1, W2;
					if (div % 2 == 0) {
						W1 = div * currency[length - 1];
						W2 = W - W1;
					} else {
						W1 = (div - 1) * currency[length - 1];
						W2 = W - W1;
					}
					N += W1 / currency[length - 1];
					int pos = (int) (W2 / (1000 * Math.pow(10, c)) - 1);
					N += base[pos][0];
					S += base[pos][1];
				}
			} else {
				if (W % currency[length - 1] == 0) {
					N = W / currency[length - 1];
					S = 1;
				} else {
					if (W / currency[length - 1] < 2) {
						int pos = (int) (W / (1000 * Math.pow(10, c)) - 1);
						N += base[pos][0];
						S += base[pos][1];
					} else {
						long W1 = (long) (W / (1000 * Math.pow(10, c + 1)));
						W1 = (long) (W1 * (1000 * Math.pow(10, c + 1)));
						long W2 = W - W1;
						N += W1 / currency[length - 1];
						int pos = (int) (W2 / (1000 * Math.pow(10, c)) - 1);
						N += base[pos][0];
						S += base[pos][1];
					}
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
