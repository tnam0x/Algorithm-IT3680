package week_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nam Tran
 */
public class KPath {
	static int n, k, m, count;
	static boolean visited[], g[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		m = scanner.nextInt();
		visited = new boolean[n];
		Arrays.fill(visited, true);
		g = new boolean[n][n];
		int x, y;
		for (int i = 0; i < m; i++) {
			x = scanner.nextInt() - 1;
			y = scanner.nextInt() - 1;
			g[x][y] = true;
			g[y][x] = true;
		}
		count = 0;
		for (int i = 0; i < n; i++) {
			visited[i] = false;
			Try(0, i);
			visited[i] = true;
		}
		scanner.close();
		System.out.println(count / 2);
	}

	private static void Try(int i, int x) {
		for (int v = 0; v < n; v++)
			if (visited[v] && g[v][x]) {
				visited[v] = false;
				if (i == k - 1)
					count++;
				else
					Try(i + 1, v);
				visited[v] = true;
			}
	}
}
