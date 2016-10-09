package week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Nam Tran
 *         <p>
 *         Thuat toan: Tim duong trong ma tran.
 *         Nhap ma tran, vi tri chua cong vao, tuong chan, bay trong ma tran.
 *         Xet vi tri cua cong vao.
 *         Tim cac vi tri co the la duong di quanh toa do do. (Khong phai la
 *         tuong).
 *         Tai moi vi tri (i,j) su dung thuat toan duyet quay lui:
 *         + Xet 4 diem lan can la ben tren(i-1,j), ben duoi(i+1,j), ben
 *         trai(i,j-1), ben phai (i,j+1).
 *         + Neu khong phai la tuong => co kha nang di duoc => tiep tuc xet tiep
 *         diem do.
 *         Trong qua trinh xet duyet cac diem tren duong neu thay so bay vuot
 *         qua so lan tranh bay => duong do sai.
 *         Duyet het cac con duong co the di den vi tri kho bau x.
 *         neu so lan tranh bay >= 2 lan so bay (thoa man ca di ca ve) thi me
 *         cung do SUCCESS
 *         Neu duyet het cac con duong ma khong thoa man thi me cung do
 *         IMPOSSIBLE.
 */
public class SpikyMazes {
	static char maze[][];
	static int n, m, num_s;
	static boolean[][] visited, visited2;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		num_s = Integer.parseInt(s.nextToken());
		int count = num_s;
		ArrayList<Integer> list = new ArrayList<>();
		maze = new char[n][m];
		visited = new boolean[n][m];
		visited2 = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] c = reader.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				visited2[i][j] = true;
				maze[i][j] = c[j];
				if (maze[i][j] == '@')
					list.add(i * 100 + j);
			}
		}
		//
		for (int i = 0; i < list.size(); i++) {
			Try(list.get(i) / 100, list.get(i) % 100, count, true);
		}
		System.out.println("IMPOSSIBLE");
	}

	private static void Try(int x, int y, int count, boolean canStop) {
		visited[x][y] = false;
		switch (maze[x][y]) {
			case 's':
				count--;
				if (count < 0)
					canStop = false;
				break;
			case 'x':
				if (2 * count >= num_s) {
					System.out.println("SUCCESS");
					System.exit(0);
				} else {
					Try2(x, y, count, true);
				}
				break;
		}
		//chon diem tiep theo ben tren
		if (canStop && x > 0 && maze[x - 1][y] != '#' && maze[x - 1][y] != '@' && visited[x - 1][y])
			Try(x - 1, y, count, canStop);
		//ben duoi
		if (canStop && x < n - 1 && maze[x + 1][y] != '#' && maze[x + 1][y] != '@' && visited[x + 1][y])
			Try(x + 1, y, count, canStop);
		//ben trai
		if (canStop && y > 0 && maze[x][y - 1] != '#' && maze[x][y - 1] != '@' && visited[x][y - 1])
			Try(x, y - 1, count, canStop);
		//ben phai
		if (canStop && y < m - 1 && maze[x][y + 1] != '#' && maze[x][y + 1] != '@' && visited[x][y + 1])
			Try(x, y + 1, count, canStop);
		visited[x][y] = true;
	}

	private static void Try2(int x, int y, int count, boolean canStop) {
		visited2[x][y] = false;
		switch (maze[x][y]) {
			case 's':
				count--;
				if (count < 0)
					canStop = false;
				break;
			case '@':
				System.out.println("SUCCESS");
				System.exit(0);
				break;
		}
		//chon diem tiep theo ben tren
		if (canStop && x > 0 && maze[x - 1][y] != '#' && visited2[x - 1][y])
			Try2(x - 1, y, count, canStop);
		//ben duoi
		if (canStop && x < n - 1 && maze[x + 1][y] != '#' && visited2[x + 1][y])
			Try2(x + 1, y, count, canStop);
		//ben trai
		if (canStop && y > 0 && maze[x][y - 1] != '#' && visited2[x][y - 1])
			Try2(x, y - 1, count, canStop);
		//ben phai
		if (canStop && y < m - 1 && maze[x][y + 1] != '#' && visited2[x][y + 1])
			Try2(x, y + 1, count, canStop);
		visited[x][y] = true;
	}
}
