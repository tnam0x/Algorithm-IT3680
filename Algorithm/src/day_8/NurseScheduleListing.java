package day_8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author namtran
 *         <p>
 *         Xét 2 trường hợp schedule[0] = 0 và schedule[0] = 1.
 *         Nếu vị trí trước đó = 0 và số bit còn lại >= k1, ta set k1 bit tiếp
 *         theo = 1.
 *         Nếu không, ta xét nếu số bit 1 hiện tại >= k1 và < k2, ta set vị trí
 *         hiện tại = 0 và = 1 rồi tiếp tục
 *         <p>
 *         Độ phức tạp thuật toán: do phải duyệt chuỗi bit độ dài n nên độ phức
 *         tạp là 2^n
 */
public class NurseScheduleListing {

	static int n, k1, k2, schedule[];
	static BufferedWriter writer;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		n = scanner.nextInt();
		k1 = scanner.nextInt();
		k2 = scanner.nextInt();
		scanner.close();
		schedule = new int[n];
		schedule[0] = 0;
		TRY(1, 0);
		schedule[0] = 1;
		TRY(1, 1);
	}

	static void TRY(int pos, int numberOfOne) throws Exception {
		if (pos == n) {
			for (int i = 0; i < n; i++) {
				writer.write(schedule[i] + '0');
			}
			writer.newLine();
			writer.flush();
		} else if (schedule[pos - 1] == 0) {
			if (n - pos >= k1) { // Số bit còn lại >= k1
				// Gán k1 bit tiếp theo = 1
				for (int i = pos; i < pos + k1; i++) {
					schedule[i] = 1;
				}
				TRY(pos + k1, k1);
			}
		} else {
			// 0
			if (numberOfOne >= k1) {
				schedule[pos] = 0;
				TRY(pos + 1, 0);
			}
			// 1
			if (numberOfOne < k2) {
				schedule[pos] = 1;
				TRY(pos + 1, numberOfOne + 1);
			}
		}
	}
}
