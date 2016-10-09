package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HoleyNQueens {
	static int[] queens;
	static boolean[][] holes;
	static int n, m, count;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			count = 0;
			String[] line = reader.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			if (n == 0 && m == 0) {
				break;
			}
			queens = new int[n + 1];
			holes = new boolean[n + 1][n + 1];
			for (int i = 0; i <= n; i++) {
				queens[i] = -1;
				for (int j = 0; j <= n; j++) {
					holes[i][j] = true;
				}
			}
			// holes
			for (int i = 0; i < m; i++) {
				line = reader.readLine().split(" ");
				int row = Integer.parseInt(line[0]) + 1;
				int col = Integer.parseInt(line[1]) + 1;
				holes[row][col] = false;
			}
			TRY(1);
			System.out.println(count);
		}
	}

	static boolean candidate(int col, int row) {
		if (!holes[row][col]) {
			return false;
		}
		for (int j = 1; j <= row - 1; j++) {
			if (queens[j] == col || Math.abs(queens[j] - col) == Math.abs(j - row)) {
				return false;
			}
		}
		return true;
	}

	static void TRY(int row) {
		for (int col = 1; col <= n; col++) {
			if (candidate(col, row)) {
				queens[row] = col;
				if (row == n) {
					count++;
				} else {
					TRY(row + 1);
				}
			}
		}
	}
}
