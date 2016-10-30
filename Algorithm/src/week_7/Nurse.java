package week_7;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <p>
 *         Code tham khảo
 *         <p>
 *         Độ phức tạp thuật toán: O(n^2)
 *         <p>
 */
public class Nurse {

	public static void main(String[] args) throws Exception {
		int n, k1, k2;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k1 = scanner.nextInt();
		k2 = scanner.nextInt();
		scanner.close();
		int zFirst[] = new int[n + 1];
		int zLast[] = new int[n + 1];
		zFirst[0] = 1;
		zFirst[1] = 1;
		zLast[k1] = 1;
		for (int i = 2; i < k1; i++) {
			zFirst[i] = 0;
			zLast[i - 1] = 0;
		}

		for (int i = k1 + 1; i <= n; i++) {
			zFirst[i] = zLast[i - 1];
			for (int j = k1; j <= k2 && i >= j; j++) {
				zLast[i] += zFirst[i - j];
			}
		}
		System.out.println(zFirst[n] + zLast[n]);
	}

}
