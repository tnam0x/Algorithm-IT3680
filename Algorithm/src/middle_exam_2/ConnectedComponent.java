package middle_exam_2;

import java.util.Scanner;

/**
 * @author namtran
 */
public class ConnectedComponent {
	static boolean visited[];
	static int edge[][], node[];

	public static void main(String[] args) {
		int n, m, count = 0;

		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		edge = new int[n][n];
		node = new int[n]; // lưu số đỉnh (node[i]) nối với đỉnh i
		visited = new boolean[n];

		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt() - 1;
			int v = scanner.nextInt() - 1;
			edge[u][node[u]++] = v;
			edge[v][node[v]++] = u;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				Try(i);
			}
		}
		System.out.println(count);
		scanner.close();
	}

	static void Try(int k) {
		visited[k] = true;
		for (int i = 0; i < node[k]; i++) {
			int d = edge[k][i];
			if (!visited[d]) {
				Try(d);
			}
		}
	}
}
