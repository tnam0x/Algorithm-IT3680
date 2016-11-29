package week_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author namtran
 */
public class MINPATH {
	static int n, m, start, end, sum;
	static int g[][], leng[], s[], p[];

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// input
		String[] line1 = reader.readLine().split(" ");
		n = Integer.parseInt(line1[0]); // số cạnh
		m = Integer.parseInt(line1[1]); // số đỉnh
		g = new int[m][m];
		for (int i = 0; i < n; i++) {
			String[] line2 = reader.readLine().split(" ");
			int u = Integer.parseInt(line2[0]) - 1;
			int v = Integer.parseInt(line2[1]) - 1;
			int c = Integer.parseInt(line2[2]);
			g[u][v] = c;
			g[v][u] = c;
			sum += c;
		}
		String[] line = reader.readLine().split(" ");
		start = Integer.parseInt(line[0]) - 1;
		end = Integer.parseInt(line[1]) - 1;

		leng = new int[m];
		s = new int[m];
		p = new int[m];

		// dat vo cung cho tat ca cap canh khong noi voi nhau
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i != j && g[i][j] == 0)
					g[i][j] = sum;
			}
		}
		for (int i = 0; i < m; i++) {
			leng[i] = sum; // khoi tao do dai tu a toi moi dinh la vo cung
			s[i] = 0; // danh sach cac diem da xet
			p[i] = start; // dat diem bat dau cua moi diem la a
		}
		leng[start] = 0;

		// tim duong di ngan nhat tu 1 dinh den moi dinh khac thi thay bang vong for:
		//for (int k = 0; k < n; k++)
		int i = 0;
		while (s[end] == 0) { // trong khi diem cuoi chua duoc xet
			for (i = 0; i < m; i++) // tim 1 vi tri ma khong phai la vo cung
				if (s[i] == 0 && leng[i] < sum)
					break;

			// i >=n tuc la duyet het cac dinh ma khong the tim thay dinh b -> thoat
			if (i >= m) {
				break;
			}

			for (int j = 0; j < m; j++) { // tim diem co vi tri ma do dai la min
				if (s[j] == 0 && leng[i] > leng[j]) {
					i = j;
				}
			}

			s[i] = 1; // cho i vao danh sach xet roi

			for (int j = 0; j < m; j++) { // tinh lai do dai cua cac diem chua xet
				if (s[j] == 0 && leng[i] + g[i][j] < leng[j]) {
					leng[j] = leng[i] + g[i][j]; // thay doi len
					p[j] = i; // danh dau diem truoc no
				}
			}
		}
		System.out.println(leng[end]);
		while (i != start) {
			System.out.print(i + 1 + " ");
			i = p[i];
		}
		System.out.println(start + 1);
	}

}
