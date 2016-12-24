package final_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 */
public class Kseq {
	static int a[], n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line[] = reader.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		a = new int[n];
		String line1[] = reader.readLine().split(" ");
		int max = 0, sum = 0;
		int len = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(line1[i]);
			sum += a[i];
			len++;
			if (len == k) {
				max = max > sum ? max : sum;
				sum -= a[i - k + 1];
				len--;
			}

		}
		System.out.println(max);
	}
}
