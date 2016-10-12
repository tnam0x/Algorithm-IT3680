package week_5;

import java.util.Scanner;

/**
 * @author Nam Tran
 *         <p>
 *         Code tham khao.
 *         Thuat toan duyet het cac canh co the chua cac node tu 1..n.
 *         Dung mot vong for de chon canh bat dau duyet.
 *         Moi lan duyet duoc k canh thi tang count.
 *         Ket thuc thi in ra man hinh count.
 *         <p>
 *         Do phuc tap thuat toan: O(n^n)
 */
public class KPath {
	static int n, k, m, count;
	static boolean visited[], G[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		m = scanner.nextInt();
		visited = new boolean[n];
		G = new boolean[n][n];
		int x, y;
		for (int i = 0; i < m; i++) {
			x = scanner.nextInt() - 1;
			y = scanner.nextInt() - 1;
			G[x][y] = true;
			G[y][x] = true;
		}
		scanner.close();
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			Try(0, i);
			visited[i] = false;
		}
		System.out.println(count / 2);
	}

	private static void Try(int i, int x) {
		for (int v = 0; v < n; v++)
			if (!visited[v] && G[v][x]) {
				visited[v] = true;
				if (i == k - 1)
					count++;
				else
					Try(i + 1, v);
				visited[v] = false;
			}
	}
}
