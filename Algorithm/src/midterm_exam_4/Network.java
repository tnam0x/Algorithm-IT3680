package midterm_exam_4;

import java.util.Scanner;

public class Network {
	static int N, c[][], d[];
	static boolean visited[];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		c = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				c[i][j] = scan.nextInt();
			}
		}
		scan.close();
		visited[0] = true;
		long result = 0;
		d = new int[N];

		// install
		for (int i = 1; i < N; i++) {
			d[i] = c[0][i];
		}
		// algo
		int count = 1;
		while (count < N) {
			int v = min();
			visited[v] = true;
			result += d[v];
			count++;
			for (int i = 1; i < N; i++) {
				if (!visited[i]) {
					if (d[i] > c[v][i]) {
						d[i] = c[v][i];
					}
				}
			}
		}
		System.out.println(result);
	}

	private static int min() {
		int min = Integer.MAX_VALUE;
		int v = 0;
		for (int i = 1; i < N; i++) {
			if (!visited[i]) {
				if (min > d[i]) {
					min = d[i];
					v = i;
				}
			}
		}
		return v;
	}

}
