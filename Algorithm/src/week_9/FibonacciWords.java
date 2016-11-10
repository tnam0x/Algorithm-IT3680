package week_9;

import java.util.Scanner;

/**
 * @author namtran
 *         <p>
 *         Code tham khảo
 *         <p>
 *         Độ phức tạp thuật toán: O(n^2)
 */
public class FibonacciWords {
	static char[] p, first_fn_2, last_fn_2, first_fn_1, last_fn_1;
	static int leng, leng_n2, leng_n1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = 1;
		while (scanner.hasNext()) {
			int n = Integer.parseInt(scanner.nextLine());
			p = scanner.nextLine().toCharArray();
			leng = p.length;
			long f[] = new long[n + 1];
			if (leng > 1) {
				first_fn_2 = new char[leng - 1];
				last_fn_2 = new char[leng - 1];
				first_fn_1 = new char[leng - 1];
				last_fn_1 = new char[leng - 1];
				leng_n1 = 1;
				leng_n2 = 1;
				first_fn_2[0] = '0';
				last_fn_2[leng - 2] = '0';
				first_fn_1[0] = '1';
				last_fn_1[leng - 2] = '1';
			}
			f[0] = 0;
			f[1] = 0;
			if (leng == 1) {
				if (p[0] == '0')
					f[0] = 1;
				else
					f[1] = 1;
			}

			for (int i = 2; i <= n; i++) {
				if (leng > 1) {
					f[i] = f[i - 1] + f[i - 2];
					if (check(p, last_fn_1, leng_n1, first_fn_2, leng_n2) != 0) {
						f[i] += 1;
					}
					change();
				} else
					f[i] = f[i - 1] + f[i - 2];
			}
			System.out.println("Case " + (testCases++) + ": " + f[n]);
		}
		scanner.close();
	}

	static int check(char[] p, char[] last_fn_1, int leng_n1, char[] first_fn_2, int leng_n2) {
		if (leng_n1 + leng_n2 >= leng) {
			for (int i = leng - leng_n2 - 1; i <= leng_n1 - 1; i++) {
				boolean b = true;
				for (int j = 0; j <= i && b; j++)
					if (last_fn_1[leng - 2 - j] != p[i - j])
						b = false;
				for (int j = 0; j < leng - i - 1 && b; j++)
					if (first_fn_2[j] != p[i + 1 + j])
						b = false;
				if (b)
					return 1;
			}
		}
		return 0;
	}

	private static void change() {
		//char[] tempF = first_fn_2;
		char[] tempF = new char[leng_n2];
		for (int i = 0; i < leng_n2; i++)
			tempF[i] = first_fn_2[i];

		//char[] tempL = last_fn_2;
		char[] tempL = new char[leng_n2];
		for (int i = 0; i < leng_n2; i++)
			tempL[leng_n2 - 1 - i] = last_fn_2[leng - 2 - i];
		//first_fn_2  = first_fn_1;
		for (int i = 0; i < leng_n1; i++)
			first_fn_2[i] = first_fn_1[i];
		//last_fn_2 = last_fn_1;
		for (int i = 0; i < leng_n1; i++)
			last_fn_2[leng - 2 - i] = last_fn_1[leng - 2 - i];
		leng_n2 = leng_n1;
		leng_n1 = Math.min(leng - 1, leng_n2 + tempF.length);
		for (int i = 0; i < leng_n1; i++) {
			//copy first
			if (i < leng_n2)
				first_fn_1[i] = first_fn_2[i];
			else {
				first_fn_1[i] = tempF[i - leng_n2];
			}
			//copy last
			if (i < tempL.length)
				last_fn_1[leng - i - 2] = tempL[tempL.length - i - 1];
			else
				last_fn_1[leng - i - 2] = last_fn_2[leng - 2 - i + tempL.length];
		}
	}
}