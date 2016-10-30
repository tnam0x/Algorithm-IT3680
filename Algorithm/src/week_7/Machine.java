package week_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Nam Tran
 *         <p>
 *         Code tham khảo
 *         <p>
 *         Độ phức tạp thuật toán: O(n)
 */
public class Machine {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		int max_s = 0, min_f = 2000000;
		int start[] = new int[2000000], finish[] = new int[2000000];
		int si, fi, produce;
		tokenizer = new StringTokenizer(reader.readLine(), " ");
		si = Integer.parseInt(tokenizer.nextToken());
		fi = Integer.parseInt(tokenizer.nextToken());
		max_s = si;
		min_f = fi;
		produce = fi - si;
		start[si] = produce;
		finish[fi] = produce;
		int maxProduce = 0;
		for (int i = 1; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine(), " ");
			si = Integer.parseInt(tokenizer.nextToken());
			fi = Integer.parseInt(tokenizer.nextToken());
			produce = fi - si;
			if (max_s < si)
				max_s = si;
			if (min_f > fi)
				min_f = fi;
			if (start[si] < produce) {
				start[si] = produce;
				for (int k = si - 1; k >= min_f && start[k] < produce; k--)
					if (maxProduce < produce + finish[k])
						maxProduce = produce + finish[k];
			}
			if (finish[fi] < produce) {
				finish[fi] = produce;
				for (int k = fi + 1; k <= max_s && finish[k] < produce; k++)
					if (maxProduce < produce + start[k])
						maxProduce = produce + start[k];
			}
		}
		System.out.println(maxProduce);
	}
}
