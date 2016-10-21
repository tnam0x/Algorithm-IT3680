package week_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 */
public class Machine {
	static int[][] periods;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		periods = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] line = reader.readLine().split(" ");
			periods[i][0] = Integer.parseInt(line[0]);
			periods[i][1] = Integer.parseInt(line[1]);
		}
		
		int maxProduce = -1;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (periods[j][0] > periods[i][1] || periods[j][1] < periods[i][0]) {
					int produce = (periods[i][1] - periods[i][0]) + (periods[j][1] - periods[j][0]);
					maxProduce = maxProduce > produce ? maxProduce : produce;
				}
			}
		}
		System.out.println(maxProduce);
	}

}
