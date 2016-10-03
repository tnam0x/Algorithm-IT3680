package day_8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author namtran
 *         <p>
 *         Thuật toán dùng backtracking để tìm chuỗi nhị phân độ dài n.
 *         Đếm số bit 1 trong dãy nếu > h thì ko gọi đệ qui nữa.
 *         Mỗi lần tìm được chuỗi kiểm tra nếu số bit 1 = h thì in chuỗi đó
 *         <p>
 *         Độ phức tạp thuật toán: do ta liệt kê chuỗi nhị phân nên tổng kết quả
 *         phải xét là 2^n
 */
public class TheHammingDistance {
	static int n, h;
	static int[] hamming;
	static boolean isValid;
	static BufferedWriter writer;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int numberOfTestCase = scanner.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			n = scanner.nextInt();
			h = scanner.nextInt();
			hamming = new int[n];
			isValid = true;
			TRY(0, 0);
			writer.newLine();
			writer.flush();
		}
		scanner.close();
	}

	static void TRY(int pos, int numberOfOne) throws Exception {
		for (int b = 0; b <= 1; b++) {
			hamming[pos] = b;
			if (hamming[pos] == 1) {
				numberOfOne++;
				if (numberOfOne > h) {
					isValid = false;
				}
			}
			if (pos == n - 1) {
				if (numberOfOne == h) {
					for (int i = 0; i < n; i++) {
						writer.write(hamming[i] + '0');
					}
					writer.newLine();
				}
				writer.flush();
			} else if (isValid) {
				TRY(pos + 1, numberOfOne);
			}
			isValid = true;
		}
	}
}
