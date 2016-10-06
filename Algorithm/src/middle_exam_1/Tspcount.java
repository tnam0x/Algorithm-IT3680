package middle_exam_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 */
public class Tspcount {
	static int n, m, cmin, cost, total, x[], cities[][];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = reader.readLine().split(" ");
		n = Integer.parseInt(line1[0]);
		m = Integer.parseInt(line1[1]);
		cities = new int[n][n];
		visited = new boolean[n];
		x = new int[n];
		cmin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			String[] line = reader.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				cities[i][j] = Integer.parseInt(line[j]);
				if (cities[i][j] != 0 && cmin > cities[i][j]) {
					cmin = cities[i][j];
				}
			}
		}
		x[0] = 0;
		visited[x[0]] = true;
		TRY(1);
		System.out.println(total);
	}

	static void TRY(int k) {
		for (int v = 1; v < n; v++) {
			if (!visited[v]) {
				x[k] = v;
				visited[v] = true;
				if (cities[x[k - 1]][x[k]] > 0) {
					cost += cities[x[k - 1]][x[k]];
					if (k == n - 1) {
						if (cost + cities[x[k]][x[0]] <= m) {
							total++;
						}
					} else {
						int z = cost + (n - k) * cmin;
						if (z <= m) {
							TRY(k + 1);
						}
					}
					cost -= cities[x[k - 1]][x[k]];
				}
				visited[v] = false;
			}
		}
	}
}
