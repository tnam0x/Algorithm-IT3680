package midterm_exam_4;

import java.util.Scanner;

public class Entity {
	static int n, m, c[][], num[], vt[][];
	static boolean visited[], connect[][];

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		visited = new boolean[n];
		c = new int[n][n];
		vt = new int[m][2];
		num = new int[n];
		connect = new boolean[n][n];
		int x, y;
		for (int i = 0; i < m; i++) {
			x = scan.nextInt() - 1;
			y = scan.nextInt() - 1;
			num[x]++;
			num[y]++;
			vt[i][0] = x;
			vt[i][1] = y;
			connect[x][y] = true;
			connect[x][x] = true;
		}
		scan.close();
		for (int i = 0; i < n; i++) {
			c[i] = new int[num[i]];
			num[i] = 0;
		}
		for (int i = 0; i < m; i++) {
			c[vt[i][0]][num[vt[i][0]]++] = vt[i][1];
			c[vt[i][1]][num[vt[i][1]]++] = vt[i][0];
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			for (int h = 0; h < num[i] - 1; h++) {
				if (!visited[c[i][h]])
					for (int k = h + 1; k < num[i]; k++) {
						if (!visited[c[i][k]] && connect[c[i][h]][c[i][k]])
							count++;
					}
			}
		}
		System.out.println(count);
	}
}