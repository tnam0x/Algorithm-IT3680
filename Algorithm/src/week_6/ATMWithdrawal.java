package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <p>
 *         Đầu tiên kiểm tra số tiền cần rút, nếu ko là bội của 1000 thì ko cần
 *         tính, nếu là bội của 1000 thì
 *         ta xét các trường hợp:
 *         Nếu chia hết số maxCurrency thì tính được số tiền cần rút và số cách
 *         là 1.
 *         Nếu chia cho maxCurrency < 2 thì ta tách từng số ra rồi so với ma
 *         trận base để xác định số tờ tiền cần rút và số cách.
 *         Trường hợp khác, ta tách thành 2 phần: W = part1 + part2 sao cho
 *         part2 > maxCurrency, part1 chia hết cho maxCurrency,
 *         part2 ta tách như trường hợp trên.
 *         <p>
 *         Độ phức tạp thuật toán: O(W)
 */
public class ATMWithdrawal {

	static int[][] base = { { 1, 1 }, { 1, 1 }, { 1, 1 }, { 2, 2 }, { 1, 1 }, { 2, 2 }, { 2, 1 }, { 2, 1 }, { 3, 3 } };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			boolean isValid = true;
			// input
			long W = scanner.nextLong(); // Số tiền cần rút
			int c = scanner.nextInt(); // Số mũ để tính ra bộ các loại tiền

			long maxCurrency = (long) (5 * Math.pow(10, c)); // Giá trị lớn nhất trong bộ tiền
			long N = 0; // Số loại tiền rút
			int S = 1; // Số cách rút mà cho N ít nhất

			if (W % 1000 != 0) { // Số tiền cần rút ko là bội của 1000
				isValid = false;
			}
			if (isValid) {
				W /= 1000;
				if (W % maxCurrency == 0) { // Nếu chia hết thì tính đc luôn số tờ cần rút
					N = W / maxCurrency;
				} else if (W / maxCurrency < 2) {
					while (W > 0) { // Tách từng số rồi so với bảng base để tính N, S
						int number = (int) (W % 10); // number = 1..9
						W = W / 10;
						if (number != 0) {
							N += base[number - 1][0];
							S *= base[number - 1][1];
						}
					}
				} else {
					// W = part1 + part2
					long div = W / maxCurrency;
					while (div > 0) {
						long part2 = W - div * maxCurrency;
						if (part2 < maxCurrency) {
							div--;
						} else {
							N += div;
							while (part2 > 0) { // Tách từng số rồi so với bảng base để tính N, S
								int number = (int) (part2 % 10); // number = 1..9
								part2 = part2 / 10;
								if (number != 0) {
									N += base[number - 1][0];
									S *= base[number - 1][1];
								}
							}
							break;
						}
					}
				}
			}

			// output
			if (N == 0) { // Ko rút được tiền
				System.out.println(0);
			} else {
				System.out.println(N + " " + S);
			}
		}
		scanner.close();
	}

}
