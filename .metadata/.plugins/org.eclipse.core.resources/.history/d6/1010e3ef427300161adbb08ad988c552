package day_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] inputData;
		Scanner inp = new Scanner(System.in);
		int numberOfInteger = Integer.parseInt(inp.nextLine());
		inputData = new int[numberOfInteger];

		for (int i = 0; i < numberOfInteger; i++) {
			inputData[i] = inp.nextInt();
		}
		inp.close();
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
