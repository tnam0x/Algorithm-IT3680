package week_6;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class MoneyChanging {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money = 1000 - scanner.nextInt();
		int[] currency = { 1, 5, 10, 50, 100, 500 };
		int count = 0, k = currency.length - 1;
		while (money > 0) {
			if (currency[k] <= money) {
				count += money / currency[k];
				money = money % currency[k];
			}
			k--;
		}
		if (count == 0) {
			System.out.println("no solution ");
		} else {
			System.out.println(count);
		}
		scanner.close();
	}

}
