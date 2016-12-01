package midterm_exam_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nam Tran
 */
public class Sumod {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] line = reader.readLine().split(" ");
		reader.close();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(line[i]);
		}
		System.out.println(sum % 1000000007);
	}

}
