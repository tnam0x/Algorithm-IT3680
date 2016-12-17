package week_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Y tuong thuat toan la chia nho bai toan thanh van de nho hon
 * Giai quyet van de nho roi luu vao bo nho
 * Thiet lap giai phap de khoi tao van de bang viec lien ket voi cac van de nho
 * da luu
 * Do phuc tap thuat toan: O(n)
 */
public class LWS {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numberOfInteger = scanner.nextInt();
		int[] a = new int[numberOfInteger];
		String[] line = reader.readLine().split(" ");
		for (int i = 0; i < numberOfInteger; i++) {
			a[i] = Integer.parseInt(line[i]);
		}
		scanner.close();
		System.out.println(dynamicProgrammingAlgo(a));
	}

	public static long dynamicProgrammingAlgo(int[] a) {
		int n = a.length;
		int[] s = new int[n];
		s[0] = a[0];
		long max = s[0];
		for (int i = 1; i < n; i++) {
			if (s[i - 1] > 0) {
				s[i] = s[i - 1] + a[i];
			} else {
				s[i] = a[i];
			}
			max = max > s[i] ? max : s[i];
		}
		return max;
	}
}
