package midterm_exam_2;

import java.util.Scanner;

/**
 * @author namtran
 */
public class MINPATH {
	static int n, m, start, end;
	static int g[][], leng[], path[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		// input
		n = scanner.nextInt(); // số đỉnh
		m = scanner.nextInt(); // số cạnh
		g = new int[n][n];
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt() - 1;
			int v = scanner.nextInt() - 1;
			g[u][v] = 1;
			g[v][u] = 1;
		}
		scanner.close();
		start = 0;
		end = n - 1;
		int max = m; // trọng số lớn nhất (do trọng số mỗi cạnh là 1)

		leng = new int[n]; // chi phi di tu start --> i
		visited = new boolean[n]; // danh sach cac diem da xet
		path = new int[n]; // duong di tu start --> end

		// dat vo cung cho tat ca cap canh khong noi voi nhau
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && g[i][j] == 0)
					g[i][j] = max;
			}
		}
		for (int i = 0; i < n; i++) {
			leng[i] = max; // khoi tao do dai tu a toi moi dinh la vo cung
			path[i] = start; // dat diem bat dau cua moi diem la a
		}
		leng[start] = 0;

		// tim duong di ngan nhat tu 1 dinh den moi dinh khac thi thay bang vong for:
		int i = 0;
		while (!visited[end]) { // trong khi diem cuoi chua duoc xet
			for (i = 0; i < n; i++) // tim 1 vi tri ma khong phai la vo cung
				if (!visited[i] && leng[i] < max)
					break;

			// i >= n tuc la duyet het cac dinh ma khong the tim thay dinh b -> thoat
			if (i >= n) {
				break;
			}

			for (int j = 0; j < n; j++) { // tim diem co vi tri ma do dai la min
				if (!visited[j] && leng[i] > leng[j]) {
					i = j;
				}
			}

			visited[i] = true; // cho i vao danh sach xet roi

			for (int j = 0; j < n; j++) { // tinh lai do dai cua cac diem chua xet
				if (!visited[j] && leng[i] + g[i][j] < leng[j]) {
					leng[j] = leng[i] + g[i][j]; // thay doi len
					path[j] = i; // danh dau diem truoc no
				}
			}
		}
		if (leng[end] > 0 && leng[end] < max) {
			System.out.println(leng[end]);
		} else {
			System.out.println(-1);
		}
	}

}
