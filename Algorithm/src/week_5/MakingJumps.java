package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Nam Tran
 */
public class MakingJumps {

	static boolean board[][] = new boolean[10][10];
	static int best_c;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(s.nextToken());
		int x, y, case_num = 1, x_f = 0, y_f = 0;
		while (n != 0) {
			//input
			int count = 0;
			boolean f = true;
			for (int i = 0; i != 10; ++i) {
				if (s.hasMoreTokens()) {
					x = Integer.parseInt(s.nextToken());
					y = Integer.parseInt(s.nextToken());
					for (int j = 0; j != 10; ++j) {
						if (j >= x && j < x + y) {
							board[i][j] = true;
						} else {
							board[i][j] = false;
						}
						if (f) {
							x_f = i;
							y_f = j;
							f = false;
						}
					}
					count += y;
				} else {
					for (int j = 0; j != 10; ++j) {
						board[i][j] = false;
					}
				}
			}
			//giai thuat
			best_c = Integer.MAX_VALUE;
			Try(x_f, y_f, count);
			//ket qua
			if (best_c == 1) {
				System.out.println("Case " + case_num + ", 1 square can not be reached.");
			} else {
				System.out.println("Case " + case_num + ", " + best_c + " squares can not be reached.");
			}
			//next input
			case_num++;
			s = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(s.nextToken());
		}
	}

	private static void Try(int x, int y, int count) {
		board[x][y] = false;
		//try
		if (x - 2 >= 0 && y - 1 >= 0 && board[x - 2][y - 1]) {
			Try(x - 2, y - 1, count - 1);
		}

		if (x - 2 >= 0 && y + 1 < 10 && board[x - 2][y + 1]) {
			Try(x - 2, y + 1, count - 1);
		}

		if (x - 1 >= 0 && y - 2 >= 0 && board[x - 1][y - 2]) {
			Try(x - 1, y - 2, count - 1);
		}

		if (x - 1 >= 0 && y + 2 < 10 && board[x - 1][y + 2]) {
			Try(x - 1, y + 2, count - 1);
		}

		if (x + 1 < 10 && y - 2 >= 0 && board[x + 1][y - 2]) {
			Try(x + 1, y - 2, count - 1);
		}

		if (x + 1 < 10 && y + 2 < 10 && board[x + 1][y + 2]) {
			Try(x + 1, y + 2, count - 1);
		}

		if (x + 2 < 10 && y + 1 < 10 && board[x + 2][y + 1]) {
			Try(x + 2, y + 1, count - 1);
		}

		if (x + 2 < 10 && y - 1 >= 0 && board[x + 2][y - 1]) {
			Try(x + 2, y - 1, count - 1);
		}
		//tra lai
		if (best_c > count - 1)
			best_c = count - 1;
		board[x][y] = true;
	}
}
