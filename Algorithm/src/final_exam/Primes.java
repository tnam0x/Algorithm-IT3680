package final_exam;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class Primes {
	static int ways, n, k, sum, count;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		scanner.close();
		if (k == 1) {
			if (isPrime(n)) {
				ways = 1;
			}
		} else if (k == 2) {
			if (n % 2 == 0 && n >= 5 || isPrime(n - 2)) {
			}
		} else if (k == 3) {
			if (n >= 10) {
			}
		} else {
			if (n >= 2 * k) {
			}
		}
		System.out.println(ways);
	}

	static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
