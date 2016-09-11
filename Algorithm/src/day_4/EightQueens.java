package day_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EightQueens {

	public static void main(String[] args) throws FileNotFoundException {
		boolean[] row = new boolean[8]; // Hàng
		boolean[] col = new boolean[8]; // Cột
		// Đường chéo
		boolean[] diagonal_right = new boolean[15];
		boolean[] diagonal_left = new boolean[15];
		// Điều kiện hợp lệ của vị trí quân queen
		boolean isValid = true;
		int numberOfQueen = 0; // Số quân queen, tối đa là 8

		for (int i = 0; i < 15; i++) {
			if (i < 8) {
				row[i] = true;
				col[i] = true;
			}
			diagonal_right[i] = true;
			diagonal_left[i] = true;
		}

		System.setIn(new FileInputStream("D:\\input_8queens.txt"));
		Scanner scanner = new Scanner(System.in);
		for (int r = 0; r < 8; r++) {
			String line = scanner.nextLine();
			for (int c = 0; c < 8; c++) {
				if (line.charAt(c) == '*') {
					numberOfQueen++;
					// Nếu queen nằm trong hàng, cột hay đường chéo của queen khác thì kết thúc
					if (!row[r] || !col[c] || !diagonal_left[r + c] || !diagonal_right[7 - r + c]) {
						isValid = false;
						break;
					} else {
						row[r] = false;
						col[c] = false;
						diagonal_left[r + c] = false;
						diagonal_right[7 - r + c] = false;
					}
				}
				// Kiểm tra điều kiện kết thúc
				if (!isValid) {
					break;
				}
			}
			// Kiểm tra điều kiện kết thúc
			if (!isValid) {
				break;
			}
		}
		// Kết thúc
		if (isValid && numberOfQueen == 8) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}

		scanner.close();
	}
}