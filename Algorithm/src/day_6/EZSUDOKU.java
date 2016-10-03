package day_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author namtr
 */
public class EZSUDOKU {
	static int[][] matrix = new int[8][8];
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int test = 1; test <= testCases; test++) {
			int startX = -1, startY = -1;
			// Đọc ma trận
			for (int i = 0; i < 8; i++) {
				String[] rows = reader.readLine().split(" ");
				for (int j = 0; j < 8; j++) {
					matrix[i][j] = Integer.parseInt(rows[j]);
					if (matrix[i][j] == 0 && startX == -1) {
						startX = i;
						startY = j;
					}
				}
			}
			if (test != testCases) {
				reader.readLine();
			}
			flag = false;
			if (checkAllBlocks() && checkAllRowsCols()) { // Ma trận hợp lệ
				TRY(startX, startY);
				if (flag) {
					System.out.println("Test case #" + test + ": YES");
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							System.out.print(matrix[i][j] + " ");
						}
						System.out.println();
					}
				} else {
					System.out.println("Test case #" + test + ": NO");
				}
			} else {
				System.out.println("Test case #" + test + ": NO");
			}
		}
	}

	// Điền số còn thiếu vào vị trí (x,y) = 0
	static void TRY(int x, int y) {
		if (x >= 8) { // Thoát khi đã duyệt xong ma trận
			flag = true;
			return;
		}
		if (matrix[x][y] != 0) {
			if (y < 7) {
				TRY(x, y + 1);
			} else {
				TRY(x + 1, 0); // Xuống hàng mới
			}
		} else {
			for (int i = 1; i <= 8; i++) {
				matrix[x][y] = i;
				if (checkRowCol(x, y) && checkBlocks(x, y)) { // Hợp lệ
					if (y < 7) { // Chưa duyệt hết hàng
						TRY(x, y + 1);
					} else {
						TRY(x + 1, 0); // Xuống hàng mới
					}
				}
				if (flag) { // Thoát khi đã duyệt xong ma trận
					return;
				}
				matrix[x][y] = 0;
			}
		}
	}

	// Kiểm tra xem vị trí (x,y) có xuất hiện quá 2 lần trại ma trận con 4x4 hay không
	static boolean checkBlocks(int x, int y) {
		int startX = x / 4;
		int startY = y / 4;
		int endX = startX * 4 + 4;
		int endY = startY * 4 + 4;
		int[] duplicateNumbers = new int[9]; // Lưu số lần xuất hiện của 1 số trong ma trận 4x4
		// Bắt đầu kiểm tra
		for (int i = startX * 4; i < endX; i++) {
			for (int j = startY * 4; j < endY; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}
				duplicateNumbers[matrix[i][j]]++;
				if (duplicateNumbers[matrix[i][j]] > 2) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkAllBlocks() {
		if (checkBlocks(0, 0) && checkBlocks(0, 4) && checkBlocks(4, 0) && checkBlocks(4, 4)) {
			return true;
		}
		return false;
	}

	// Kiểm tra vị trí giá trị tại (x,y) đã tồn tại hay không
	static boolean checkRowCol(int x, int y) {
		int[] rows = new int[9];
		int[] cols = new int[9];
		// Hàng
		for (int i = 0; i < 8; i++) {
			if (matrix[x][i] == 0) {
				continue;
			}
			rows[matrix[x][i]]++;
			if (rows[matrix[x][i]] > 1) {
				return false;
			}
		}
		// Cột
		for (int i = 0; i < 8; i++) {
			if (matrix[i][y] == 0) {
				continue;
			}
			cols[matrix[i][y]]++;
			if (cols[matrix[i][y]] > 1) {
				return false;
			}
		}
		return true;
	}

	static boolean checkAllRowsCols() {
		for (int i = 0; i < 8; i++) {
			if (!checkRowCol(i, i)) {
				return false;
			}
		}
		return true;
	}
}
