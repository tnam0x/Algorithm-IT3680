package day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class LargestWeightedSubsequence {
	public static final String PATH_FILE = "input_sequence.txt";
	private static int DISK_BLOCK_SIZE = 4096;
	public static int[] inp;

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		readInput();
		System.out.println(dynamicProgrammingAlgo(inp));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime + "ms");
	}

	public static void readInput() {
		try {
			FileReader reader = new FileReader(PATH_FILE);
			BufferedReader bis = new BufferedReader(reader, DISK_BLOCK_SIZE);
			Scanner scanner = new Scanner(bis);
			// FileInputStream fis = new FileInputStream(PATH_FILE);
			// BufferedInputStream bis = new BufferedInputStream(fis,
			// DISK_BLOCK_SIZE);
			// DataInputStream dis = new DataInputStream(bis);
			// Scanner scanner = new Scanner(dis);
			scanner.useDelimiter(" ");

			int numberOfInteger = Integer.parseInt(scanner.nextLine());
			System.out.println(numberOfInteger);
			inp = new int[numberOfInteger];

			for (int i = 0; i < numberOfInteger; i++) {
				inp[i] = scanner.nextInt();
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Scan all possible subsequences Compute and keep the largest weight
	 * subsequence
	 */
	public static long directAlgo(int[] a) {
		int n = a.length;
		long max = a[0];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++)
					sum = sum + a[k];
				max = max < sum ? sum : max;
			}
		}
		return max;
	}

	/**
	 * Quét các dãy con độ dài từ i-n Tính toán dãy con có tổng lớn nhất
	 */
	public static long fasterAlgo(int[] a) {
		int n = a.length;
		long max = a[0];
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				max = max < sum ? sum : max;
			}
		}
		return max;
	}

	/**
	 * Divide the sequence into 2 subsequences at the middle s = s1 :: s2 The
	 * largest subsequence might be in s1 or be in s2 or start at some position
	 * of s1 and end at some position of s2
	 */
	public static long devideAndConpuerAlgo(int[] a) {
		int n = a.length;
		return maxSequence(0, n - 1);
	}

	private static long maxSequence(int left, int right) {
		if (left == right) {
			return inp[left];
		}
		int m = (left + right) / 2;
		long mSeqLeft = maxSequence(left, m);
		long mSeqRight = maxSequence(m + 1, right);

		long maxLeft = maxLeft(left, m);
		long maxRight = maxRight(m + 1, right);

		long max = mSeqLeft > mSeqRight ? mSeqLeft : mSeqRight;
		long maxLR = maxLeft + maxRight;
		max = max < maxLR ? maxLR : max;
		return max;
	}

	private static long maxLeft(int i, int j) {
		long maxL = inp[i];
		int sum = 0;
		for (int k = j; k >= i; k--) {
			sum += inp[k];
			maxL = maxL < sum ? sum : maxL;
		}
		return maxL;
	}

	private static long maxRight(int i, int j) {
		long maxR = inp[i];
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += inp[k];
			maxR = maxR < sum ? sum : maxR;
		}
		return maxR;
	}

	/**
	 * General Principle Division: divide the initial problem into smaller
	 * similar problems (subproblems) Storing solutions to subproblems: store
	 * the solution to subproblems into memory Aggregation: establish the
	 * solution to the initial problem by aggregating solutions to subproblems
	 * stored in the memory
	 */
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
