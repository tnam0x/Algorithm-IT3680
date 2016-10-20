package week_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 *         Code tham khảo trên internet.
 *         <p>
 *         Ta chuyển tất cả wine ở nhà này tới nhà tiếp theo dù là âm hay dương.
 *         Công việc sẽ là giá trị tuyệt đối của của wine ở nhà đó.
 *         <p>
 *         Độ phức tạp thuật toán: O(n)
 */
public class GERGOVIA {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] wines;
		while (N > 0) {
			wines = new int[N];
			String[] line = reader.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				wines[i] = Integer.parseInt(line[i]);
			}
			long amountOfWork = 0;
			// Do tổng wines = 0 nên khi ko cần cộng amountOfWork ở vị trí N-1
			for (int i = 1; i < N; i++) {
				wines[i] += wines[i - 1];
				amountOfWork += (wines[i - 1] >= 0) ? wines[i - 1] : -wines[i - 1];
				System.out.println(wines[i]);
			}
			System.out.println(amountOfWork);
			N = Integer.parseInt(reader.readLine());
		}
	}

}
