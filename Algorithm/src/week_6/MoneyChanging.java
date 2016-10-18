package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <p>
 *         Dùng 1 vòng while để tính số tờ tiền cần rút.
 *         Kiểm tra nếu giá trị tờ tiền <= tiền cần rút thì chia lấy nguyên số
 *         tiền cần rút cho giá trị tờ tiền,
 *         chia lấy dư để được số tiền cần rút còn lại, lặp lại đến khi số tiền
 *         cần rút = 0.
 *         <p>
 *         Độ phức tạp thuật toán: O(1)
 */
public class MoneyChanging {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] currency = { 1, 5, 10, 50, 100, 500 };
		int testCases = scanner.nextInt();
		for (int test = 0; test < testCases; test++) {
			int money = 1000 - scanner.nextInt();
			int count = 0, k = currency.length - 1;
			while (money > 0) {
				if (currency[k] <= money) {
					count += money / currency[k];
					money = money % currency[k];
				}
				k--;
			}
			if (count == 0) {
				System.out.println("no solution");
			} else {
				System.out.println(count);
			}
		}
		scanner.close();
	}

}
