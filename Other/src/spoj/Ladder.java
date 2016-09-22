package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author namtran
 */
public class Ladder {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int h, v;
		String[] line = reader.readLine().split(" ");
		h = Integer.parseInt(line[0]);
		v = Integer.parseInt(line[1]);
		System.out.println((int) Math.ceil(h / Math.sin(Math.toRadians(v))));
	}
}
