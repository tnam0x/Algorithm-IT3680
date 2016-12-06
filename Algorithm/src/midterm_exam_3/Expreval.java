package midterm_exam_3;

import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class Expreval {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int max = 1000000007;
		int n = scanner.nextInt();
		int[] value = new int[n];
		int[] operator = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = scanner.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			operator[i] = scanner.nextInt();
		}
		int[] val = new int[n];
		int[] opt = new int[n];
		int k = 0, l = 0;
		for (int i = 0; i < n - 1; i++) {
			if (operator[i] == 2) {
				val[k] = (value[i] * value[i + 1]) % max;
				value[i + 1] = val[k];
			} else {
				val[k++] = value[i];
				opt[l++] = operator[i];
			}
		}
		if (operator[n - 1] < 2) {
			val[k] = value[n - 1];
			k++;
		}
		long out = val[0];
		for (int i = 1; i <= l; i++) {
			if (opt[i - 1] == 0) {
				out -= val[i];
			} else {
				out += val[i];
			}
			out = out % max;
		}
		if (out < 0) {
			out += max;
		}
		System.out.println(out);
		scanner.close();
	}
}
