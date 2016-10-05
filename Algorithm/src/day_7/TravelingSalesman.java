package day_7;

import java.util.Scanner;

/**
 * @author namtran
 */
public class TravelingSalesman {

	static int n, cost[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		cost = new int[n][n];
		for (int index = 0; index < m; index++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			int c = scanner.nextInt();
			cost[i][j] = c;
		}
		scanner.close();
	}

}
