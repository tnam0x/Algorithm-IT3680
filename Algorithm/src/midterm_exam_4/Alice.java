package midterm_exam_4;

import java.util.Scanner;

public class Alice {
	static int n, m, a[];

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		scan.close();
		long sum1 = 0;
		long sum2 = 0;
		int count = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == m) {
				count++;
				if (count % 2 == 0) {
					sum1 = 0;
					sum2 += a[i];
					max = max < sum2 ? sum2 : max;
				} else {
					sum2 = 0;
					sum1 += a[i];
					max = max < sum1 ? sum1 : max;
				}
			} else if (a[i] > m) {
				sum1 += a[i];
				max = max < sum1 ? sum1 : max;
				sum2 += a[i];
				max = max < sum2 ? sum2 : max;
			} else {
				sum1 = 0;
				sum2 = 0;
			}
		}
		System.out.println(max);
	}

}
