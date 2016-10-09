package week_3;

import java.util.Scanner;

/**
 * @author namtran
 * <p>
 * Thuật toán duyệt từng phần tử của ma trận.
 * Dùng 3 mảng 2 chiều: 1 mảng int lưu ma trận đọc vào, 2 mảng boolean lưu quân dominos và phần tử
 * trên ma trận đã được duyệt hay chưa.
 * Với mỗi vị trí (x,y) ta duyệt cặp vị trí theo hàng dọc (x,y)-(x+1,y) hoặc hàng ngang (x,y)-(x,y+1).
 * Cứ như vậy đến khi duyệt hết ma trận thì ta được 1 đáp án
 */
public class VONNY {
	static boolean[][] dominos, visited;
	static int[][] board;
	static int count;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		board = new int[7][8];
		int testCases = scanner.nextInt();
		for (int test = 0; test < testCases; test++) {
			dominos = new boolean[7][7];
			visited = new boolean[7][8];
			count = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 8; j++) {
					board[i][j] = scanner.nextInt();
				}
			}
			TRY(0, 0);
			System.out.println(count);
		}
		scanner.close();
	}

	static void TRY(int x, int y) {
		if (x == 7) { // Duyệt xong ma trận
			count++;
			return;
		}
		if (visited[x][y]) { // Phần tử đã được duyệt
			if (y < 7) {
				TRY(x, y + 1);
			} else {
				TRY(x + 1, 0);
			}
		} else {// Phần tử chưa được duyệt
			int one, two;
			one = board[x][y]; // Phần tử đầu tiên
			for (int i = 0; i < 2; i++) { // Duyệt theo hàng dọc hoặc ngang
				int tempX = x + dx[i];
				int tempY = y + dy[i];
				if (tempX >= 0 && tempX < 7 && tempY >= 0 && tempY < 8 && !visited[tempX][tempY]) {
					two = board[tempX][tempY]; // Phần tử thứ hai
					if (one <= two && !dominos[one][two]) {
						dominos[one][two] = true;
						visited[x][y] = visited[tempX][tempY] = true;
						// Duyệt tiếp phần tử tiếp theo
						if (y < 7) {
							TRY(x, y + 1);
						} else {
							TRY(x + 1, 0);
						}
						visited[x][y] = visited[tempX][tempY] = false;
						dominos[one][two] = false;
					} else if (one >= two && !dominos[two][one]) {
						dominos[two][one] = true;
						visited[x][y] = visited[tempX][tempY] = true;
						// Duyệt tiếp phần tử tiếp theo
						if (y < 7) {
							TRY(x, y + 1);
						} else {
							TRY(x + 1, 0);
						}
						visited[x][y] = visited[tempX][tempY] = false;
						dominos[two][one] = false;
					}
				}
			}
		}
	}
}
