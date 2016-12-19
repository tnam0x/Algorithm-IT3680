package daysofcode;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] scores = new int[n];
		int rank = 1;
		scores[rank++] = in.nextInt();
		for (int scores_i = 1; scores_i < n; scores_i++) {
			int score = in.nextInt();
			if (score != scores[rank - 1]) {
				scores[rank++] = score;
			}
		}
		int m = in.nextInt();
		int[] alice = new int[m];
		for (int alice_i = 0; alice_i < m; alice_i++) {
			alice[alice_i] = in.nextInt();
		}
		in.close();
		// your code goes here
		n = rank - 1;
		for (int i = 0; i < m; i++) {
			while (n > 0) {
				if (alice[i] >= scores[n]) {
					rank--;
					n--;
				} else {
					break;
				}
			}
			System.out.println(rank <= 0 ? 1 : rank);
		}
	}
}
