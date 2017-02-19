package crackingthecodinginterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClimbStaircase {
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		for (int a0 = 0; a0 < s; a0++) {
			int n = in.nextInt();
			System.out.println(climb(n));
		}
		in.close();
	}

	static int climb(int n) {
		if (n < 0)
			return 0;
		if (n == 0 || n == 1)
			return 1;
		if (!map.containsKey(n)) {
			int count = climb(n - 1) + climb(n - 2) + climb(n - 3);
			map.put(n, count);
		}
		return map.get(n);
	}
}
